<template>
  <div>
    <el-container>
      <el-header class="outer-header">
        <custom-header />
      </el-header>
      <el-main>
        <RouterView />
      </el-main>
      <el-footer class="outer-footer">
        <custom-footer />
      </el-footer>
    </el-container>
  </div>
</template>


<script setup lang="ts">

import { RouterView } from 'vue-router'
import customHeader from '@/components/layout/custom-header.vue'
import customFooter from '@/components/layout/custom-footer.vue'

</script>


<style scoped></style>