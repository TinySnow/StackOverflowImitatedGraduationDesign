<template>
  <div class="common-layout">
    <el-container>
      <el-header class="outer-header">
        <single />
      </el-header>
      <el-main>
        <RouterView />
      </el-main>
      <el-footer class="outer-footer">
        <p> Temporary a footer. </p>
      </el-footer>
    </el-container>
  </div>
</template>


<script setup lang="ts">

import { RouterView } from 'vue-router'
import single from '@/components/header-part/custom-header.vue'
// import sidebar from '@/components/sidebar-part/custom-sidebar.vue'

</script>


<style scoped>
/* 测试，为使布局可见，临时样式 */
.outer-footer {
  background-color: orange;
  text-align: center;
  padding: auto;
}

.outer-header {
  background-color: orange;
  text-align: center;
  padding: auto;
}
</style>