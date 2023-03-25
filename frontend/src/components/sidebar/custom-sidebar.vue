<template>
  <el-menu class="sidebar">
    <el-menu-item index="1">
      <span>用户</span>
    </el-menu-item>
    <el-menu-item index="2">
      <span>问题</span>
    </el-menu-item>
    <el-menu-item index="3">
      <span>评论</span>
    </el-menu-item>
    <el-menu-item index="4">
      <span>问题集</span>
    </el-menu-item>
  </el-menu>
</template>

<script lang="ts" setup>
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