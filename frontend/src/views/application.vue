<template>
  <div>
    <el-container>
      <el-header class="outer-header">
        <single />
      </el-header>
      <el-main>
        <RouterView />
      </el-main>
      <el-footer class="outer-footer">
        <p>Copyright ©2023 报错解决查助系统 All rights reserved. | 南国微雪 Miyuki 毕业设计制作 | For Bachelor Graduation.</p>
      </el-footer>
    </el-container>
  </div>
</template>


<script setup lang="ts">

import { RouterView } from 'vue-router'
import single from '@/components/header/custom-header.vue'

</script>


<style scoped>
.outer-footer {
  background-color: rgb(196, 232, 255);
  border-radius: 4px;
  text-align: center;
  padding: auto;
}

.outer-header {
  background-color: rgb(196, 232, 255);
  border-radius: 4px;
  text-align: center;
  padding: auto;
}
</style>