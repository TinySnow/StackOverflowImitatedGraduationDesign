<template>
    <el-empty description="没有权限，请先登录">
        <el-button type="primary" @click="() => router.push('/login')">登录</el-button>
    </el-empty>
</template>


<script lang="ts" setup>
import { useRouter } from 'vue-router';

const router = useRouter();
</script>


<style scoped></style>