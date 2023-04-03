<template>
    <el-row>
        <el-col :span="me ? 22 : 24">
            <el-card shadow="hover">
                <md-editor v-model="comment.content" preview-only />
            </el-card>
        </el-col>
        <el-col v-if="me" :span="2" class="button-style">
            <el-dropdown>
                <el-button type="primary" plain>
                    操作<el-icon class="el-icon--right"><arrow-down /></el-icon>
                </el-button>
                <template #dropdown>
                    <el-dropdown-menu>
                        <el-dropdown-item>
                            <span class="primary" @click="commentDetail()">详情</span>
                        </el-dropdown-item>
                        <el-dropdown-item>
                            <span class="warning" @click="editComment()">编辑</span>
                        </el-dropdown-item>
                        <el-dropdown-item>
                            <span class="danger" @click="reconfirmVisiable = true">删除</span>
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </el-col>

        <update-comment :comment-id="data.comment.id.toString()" :show="isUpdateShow" @close="close" />
        <el-dialog v-model="reconfirmVisiable" title="最终确认">
            <p>评论内容：</p>
            <md-editor v-model="comment.content" preview-only />
            <br />
            <p>确认删除此评论？此操作不可撤销！</p>
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="reconfirmVisiable = false">取消</el-button>
                    <el-button type="primary" @click="deleteComment">确定</el-button>
                </span>
            </template>
        </el-dialog>
    </el-row>
</template>


<script lang="ts" setup>
import { useUserIdStore } from '@/stores/store';
import { ArrowDown } from '@element-plus/icons-vue'
import UpdateComment from "@/components/update/update-comment.vue";
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { showMessagesForError, showMessagesForSuccess } from '@/utils/show-messages';

const router = useRouter()

const isUpdateShow = ref(false)
const reconfirmVisiable = ref(false)
const userIdStore = useUserIdStore()

const data = defineProps<{
    comment: {
        id: number,
        question: string,
        parent: number,
        author: string,
        content: string,
        upvote: number,
        devote: number,
        createdTime: Date,
        updatedTime: Date,
        status: boolean,
    }, userId: string
}>()

const me = data.userId === userIdStore.userId

const commentDetail = () => {
    router.push("/question/" + data.comment.question)
}

const editComment = () => {
    isUpdateShow.value = true
}
const deleteComment = () => {
    backend.delete(api.deleteComment + data.comment.id, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        if (res.data.success) {
            showMessagesForSuccess("成功删除问题！评论 id：" + data.comment.id)
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