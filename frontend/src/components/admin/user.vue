<template>
    <el-table :data="data" stripe table-layout="auto" :highlight-current-row="true">
        <el-table-column fixed prop="user.id" label="用户 ID" width="72px" sortable />
        <el-table-column prop="user.username" label="用户名" />
        <el-table-column prop="user.password" label="密码" />
        <el-table-column prop="user.email" label="邮箱" />
        <el-table-column prop="user.gender" label="性别" />
        <el-table-column prop="user.birthday" label="生日" sortable />
        <el-table-column prop="user.registerTime" label="注册时间" sortable />
        <el-table-column prop="point.point" label="助人点数" sortable  />
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
    backend.get(api.userList).then(res => {
        Object.assign(data, res.data.data)
    }).catch(error => {
        showMessagesForError(error);
    })
}

onMounted(getList)
</script>


<style scoped></style>