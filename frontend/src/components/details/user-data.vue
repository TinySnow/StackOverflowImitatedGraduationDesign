<template>
    <el-collapse v-model="numbers">
      <el-collapse-item title="问题" name="1">
      </el-collapse-item>
      <el-collapse-item title="文章" name="2">
      </el-collapse-item>
      <el-collapse-item title="评论" name="3">
      </el-collapse-item>
      <el-collapse-item title="问题集" name="4">
      </el-collapse-item>
    </el-collapse>
</template>


<script lang="ts" setup>
import { ref } from 'vue'

const numbers = ref(['0'])
</script>


<style scoped>
</style>