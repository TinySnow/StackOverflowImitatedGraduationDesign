<template>

</template>


<script lang="ts" setup>
// TODO：加入问题集搜索
import { watchEffect } from 'vue';


const result = defineProps<{
    hits: object
}>()

// 需要监听才能取得父组件传递的 hits
watchEffect(
    () => result.hits
)

</script>


<style scoped>

</style>