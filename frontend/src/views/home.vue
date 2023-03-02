<template>
    <please-login v-if="!judge.logined" />
    <div v-else>
        <p class="personal-center">个人中心</p>
    </div>
</template>


<script lang="ts" setup>
import PleaseLogin from '@/components/404/please-login.vue';
import { useLoginedStore } from '@/stores/counter';
import { onMounted } from 'vue';
const judge = useLoginedStore()

onMounted(() => {
    console.log(judge.logined);
})

</script>


<style scoped>
.personal-center {
    background-color: lightpink;
    text-align: center;
    padding: 10%;
}
</style>