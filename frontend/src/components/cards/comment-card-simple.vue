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
                            <span class="primary" @click="questionDetail()">详情</span>
                        </el-dropdown-item>
                        <el-dropdown-item>
                            <span class="warning" @click="editQuestion()">编辑</span>
                        </el-dropdown-item>
                        <el-dropdown-item>
                            <span class="danger" @click="deleteQuestion()">删除</span>
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </el-col>
    </el-row>
</template>


<script lang="ts" setup>
import { useUserIdStore } from '@/stores/store';
import { ArrowDown } from '@element-plus/icons-vue'
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';

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

const questionDetail = () => {

}

const editQuestion = () => {

}
const deleteQuestion = () => {

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