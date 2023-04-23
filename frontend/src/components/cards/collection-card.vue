<template>
    <el-row>
        <el-col :span="me ? 22 : 24">
            <el-collapse v-model="activeNames">
                <el-collapse-item :title="data.collection.title" :name="data.collection.id">
                    
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
    <!-- <update-question :question-id="data.collection.id.toString()" :show="isUpdateShow" @close="close" /> -->
    <el-dialog v-model="reconfirmVisiable" title="最终确认" width="30%">
        <p>问题标题：</p>
        <p>{{ data.collection.title }}</p>
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
import QuestionCard from "@/components/cards/question-card.vue";
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
    collection: {
        id: string,
        title: string,
        author: string,
        description: string,
        createdTime: Date,
        updatedTime: Date
        question: []
    },
    userId: string | null
}>()

const me = data.userId === userIdStore.userId

const questionDetail = () => {

}

const editQuestion = () => {
    isUpdateShow.value = true
}


const deleteQuestion = () => {

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