<template>
    <el-table :data="data" stripe table-layout="auto" :highlight-current-row="true">
        <el-table-column fixed prop="id" label="评论 ID" width="72px" sortable />
        <el-table-column prop="question" label="问题 ID" />
        <el-table-column prop="parent" label="父评论 ID" />
        <el-table-column prop="author" label="作者 ID" />
        <el-table-column prop="content" label="内容" />
        <el-table-column prop="upvote" label="点赞数" />
        <el-table-column prop="devote" label="点踩数" />
        <el-table-column prop="createdTime" label="创建时间" sortable />
        <el-table-column prop="updatedTime" label="最后更新" sortable />
        <el-table-column prop="status" label="评论状态" />
        <el-table-column fixed="right" label="操作" width="180">
            <template #default="scope">
                <el-button type="primary" size="small">编辑</el-button>
                <el-button type="danger" size="small">删除</el-button>
            </template>
        </el-table-column>
    </el-table>
</template>


<script lang="ts" setup>

import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { showMessagesForError, showMessagesForSuccess } from '@/utils/show-messages';
import { reactive, onMounted } from 'vue';

const data = reactive([{}])

const getList = async () => {
    backend.get(api.getAllComments).then(res => {
        Object.assign(data, res.data.data)
    }).catch(error => {
        showMessagesForError(error);
    })
}

onMounted(getList)
</script>


<style scoped></style>