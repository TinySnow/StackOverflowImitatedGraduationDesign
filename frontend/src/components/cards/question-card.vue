<template>
    <el-row>
        <el-col :span="me ? 22 : 24">
            <el-collapse v-model="activeNames">
                <el-collapse-item :title="data.question.title" :name="data.question.id">
                    <md-editor v-model="data.question.content" preview-only />
                </el-collapse-item>
            </el-collapse>
        </el-col>
        <el-col v-if="me" :span="2" class="button-style">
            <el-dropdown>
                <el-button type="primary" plain>
                    操作<el-icon class="el-icon--right"><arrow-down /></el-icon>
                </el-button>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item>
                            <span class="primary" @click="questionDetail()">详情</span>
                        </el-dropdown-item>
                        <el-dropdown-item>
                            <span class="warning" @click="editQuestion()">编辑</span>
                        </el-dropdown-item>
                        <el-dropdown-item>
                            <span class="danger" @click="reconfirmVisiable = true">删除</span>
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </el-col>
    </el-row>
    <update-question :question-id="data.question.id.toString()" :show="isUpdateShow" @close="close" />
    <el-dialog v-model="reconfirmVisiable" title="最终确认" width="30%">
        <p>问题标题：</p>
        <p>{{ data.question.title }}</p>
        <br />
        <p>确认删除此问题？此操作不可撤销！</p>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="reconfirmVisiable = false">取消</el-button>
                <el-button type="primary" @click="deleteQuestion">确定</el-button>
            </span>
        </template>
    </el-dialog>
</template>


<script lang="ts" setup>
import { useUserIdStore } from '@/stores/store';
import { ref } from 'vue'
import { ArrowDown } from '@element-plus/icons-vue'
import UpdateQuestion from "@/components/update/update-question.vue";
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { useRouter } from 'vue-router';
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { showMessagesForError, showMessagesForSuccess } from '@/utils/show-messages';


const router = useRouter()
const isUpdateShow = ref(false);

const activeNames = ref([''])
const userIdStore = useUserIdStore()
const reconfirmVisiable = ref(false)

const data = defineProps<{
    question: {
        id: string,
        title: string,
        author: string,
        content: string,
        reward: number,
        bestAnswer: boolean,
        createdTime: Date,
        updatedTime: Date
    }, userId: string | null
}>()

const me = data.userId === userIdStore.userId

const questionDetail = () => {
    router.push("/question/" + data.question.id)
}

const editQuestion = () => {
    isUpdateShow.value = true
}


const deleteQuestion = () => {
    backend.delete(api.deleteQuestion + data.question.id, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        if (res.data.success) {
            showMessagesForSuccess("成功删除问题！问题 id：" + data.question.id)
        } else {
            showMessagesForError(res.data.msg);
        }
        reconfirmVisiable.value = false
        close()
    }).catch(error => {
        console.log(error);
    })
}
const emits = defineEmits(["update"])

const delay = (ms: number) => {
    return new Promise(resolve => setTimeout(resolve, ms));
};

const close = async () => {
    isUpdateShow.value = false
    await delay(1000)
    await emits("update", false)
}
</script>


<style scoped>
.button-style {
    text-align: right;
}

.primary {
    color: var(--el-color-primary)
}

.warning {
    color: var(--el-color-warning)
}

.danger {
    color: var(--el-color-danger)
}
</style>