<template>
    <!-- 考虑换成响应式布局 -->
    <el-row :gutter="20">
        <el-col :span="4" @click="() => router.push('/search')">
            <p class="content">搜索</p>
        </el-col>
        <el-col :span="16" @click="() => router.push('space')">
            <p class="content">首页</p>
        </el-col>
        <el-col :span="4" @click="() => router.push('/home')">
            <p class="content">个人中心</p>
            <!-- <el-avatar class="avatar-style" size="large" :src="imgurl" /> -->
        </el-col>
    </el-row>
</template>

<script lang="ts" setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const imgurl = 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png';


</script>

<style scoped>
.content {
    background-color: rgb(125, 182, 218);
    text-align: center;
    border-radius: 10px;
    font-size: larger;
}

.avatar-style {
    text-align: right;
}
</style>
