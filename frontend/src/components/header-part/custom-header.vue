<template>
    <!-- 考虑换成响应式布局 -->
    <el-row :gutter="20">
    <el-col :span="4"><div class="grid-content ep-bg-purple" /></el-col>
    <el-col :span="16"><div class="grid-content ep-bg-purple" /></el-col>
    <el-col :span="4"><div class="grid-content ep-bg-purple" /></el-col>
  </el-row>
</template>

<style scoped>
.el-col {
    border-radius: 4px;
}
/* 测试，为使布局可见，临时样式 */
.el-row{
    background-color: blue;
}

.grid-content {
    border-radius: 4px;
    min-height: 36px;
}
</style>
