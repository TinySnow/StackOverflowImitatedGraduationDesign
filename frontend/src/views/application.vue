<template>
  <el-container>

    <el-header>
      <single />
    </el-header>

    <el-container>

      <el-aside>
        <sidebar />
      </el-aside>

      <el-main>
        <RouterView />
      </el-main>

    </el-container>

  </el-container>
</template>


<script setup lang="ts">

import { RouterView } from 'vue-router'
import single from '@/components/header-part/custom-header.vue'
import sidebar from '@/components/sidebar-part/custom-sidebar.vue'

</script>


<style>

</style>