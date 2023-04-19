<template>
  <RouterView>
    <admin v-if="route.path.match('/admin')" />
    <application v-else />
  </RouterView>
</template>

<script setup lang="ts">

import admin from '@/views/admin/index.vue'
import application from '@/views/application.vue'
import { useRoute } from 'vue-router';

const route = useRoute()

</script>

<style>
.outer-header {
  background-color: rgb(196, 232, 255);
  border-radius: 4px;
  text-align: center;
  padding: auto;
}

.outer-footer {
  background-color: rgb(196, 232, 255);
  border-radius: 4px;
  text-align: center;
  padding: auto;
}
</style>