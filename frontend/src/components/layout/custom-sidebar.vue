<template>
  <el-menu class="sidebar">
    <el-menu-item index="1" @click="router.push('/admin/user')">
      <span>用户</span>
    </el-menu-item>
    <el-menu-item index="2" @click="router.push('/admin/question')">
      <span>问题</span>
    </el-menu-item>
    <el-menu-item index="3" @click="router.push('/admin/comment')">
      <span>评论</span>
    </el-menu-item>
    <el-menu-item index="4" @click="router.push('/admin/collection')">
      <span>问题集</span>
    </el-menu-item>
  </el-menu>
</template>

<script lang="ts" setup>
import { useRouter } from "vue-router";

const router = useRouter()

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
</script>

<style scoped>
.sidebar{
  background-color: rgb(223, 233, 255);
}
</style>