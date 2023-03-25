<template>
  <admin v-if="route.path.match('/admin')" />
  <application v-else />
</template>

<script setup lang="ts">

import admin from '@/views/admin/index.vue'
import application from '@/views/application.vue'
import { useRoute } from 'vue-router';

const route = useRoute()

</script>

<style>

</style>