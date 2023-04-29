<template>
    <el-row>
        <el-col :span="me ? 22 : 24">
            <el-collapse v-model="activeNames">
                <el-collapse-item :title="data.collection.title" :name="data.collection.id">
                    <el-row v-for="item in data.collection.question">
                        <el-col :span="2">
                            <p class="question-id">问题 ID<br />{{ item.id }}</p>
                        </el-col>
                        <el-col :span="22">
                            <el-collapse v-model="inner">
                                <el-collapse-item :title="item.title" :name="item.id">
                                    <md-editor v-model="item.content" preview-only />
                                </el-collapse-item>
                            </el-collapse>
                        </el-col>
                    </el-row>
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
                            <span class="warning" @click="edit">编辑</span>
                        </el-dropdown-item>
                        <el-dropdown-item>
                            <span class="danger" @click="reconfirm = true">删除</span>
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </el-col>
    </el-row>
    <update-collection :collection-id="data.collection.id.toString()" :show="isUpdateShow" @close="close" />
    <el-dialog v-model="reconfirm" title="最终确认" width="30%">
        <p>问题集标题：</p>
        <p>{{ data.collection.title }}</p>
        <br />
        <p>确认删除此问题集？此操作不可撤销！</p>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="reconfirm = false">取消</el-button>
                <el-button type="primary" @click="deletee">确定</el-button>
            </span>
        </template>
    </el-dialog>
</template>


<script lang="ts" setup>
import { useUserIdStore } from '@/stores/store';
import { ref } from 'vue'
import { ArrowDown } from '@element-plus/icons-vue'
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { useRouter } from 'vue-router';
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import UpdateCollection from "@/components/update/update-collection.vue";
import { showMessagesForError, showMessagesForSuccess } from '@/utils/show-messages';


const router = useRouter()
const isUpdateShow = ref(false);

const activeNames = ref([''])
const inner = ref([''])
const userIdStore = useUserIdStore()
const reconfirm = ref(false)

const data = defineProps<{
    collection: {
        id: string,
        title: string,
        author: string,
        description: string,
        createdTime: Date,
        updatedTime: Date
        question: [{
            id: string,
            title: string,
            author: string,
            content: string,
            reward: number,
            bestAnswer: boolean,
            createdTime: Date,
            updatedTime: Date
        }]
    },
    userId: string | null
}>()

const me = data.userId === userIdStore.userId

const edit = () => {
    isUpdateShow.value = true
}

const deletee = () => {
    reconfirm.value = false
    del()
}
const emits = defineEmits(["update"])

const delay = (ms: number) => {
    return new Promise(resolve => setTimeout(resolve, ms));
};

const close = async (isUpdate: boolean) => {
    if (!isUpdate) {
        isUpdateShow.value = false
    }
    await delay(1000)
    await emits("update", true)
}

const del = async () => {
    backend.delete(api.deleteCollection + data.collection.id, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        if (res.data.success) {
            showMessagesForSuccess("成功删除问题！问题集 id：" + data.collection.id)
        } else {
            showMessagesForError(res.data.msg);
        }
    }).catch(error => {
        console.log(error);
    })
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

.question-id {
    margin-top: 0%;
    color: var(--el-color-info);
}
</style>