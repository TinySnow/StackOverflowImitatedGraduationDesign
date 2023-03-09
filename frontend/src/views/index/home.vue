
<!-- TODO: 这里后续可能还要加上 jwt 的 token 一起判断是否登录 -->

<template>
    <!-- 如果需要要求用户登录，需要此处为真，所以： -->
    <!-- 如果用户本地没有 token 的情况下，logined 还为 false，则要求用户登录 -->
    <please-login v-if="storage.token === null && !judge.logined" />
    <div v-else>
        <home-detail />
    </div>
</template>


<script lang="ts" setup>
import PleaseLogin from '@/components/premise/please-login.vue';
import HomeDetail from '@/components/details/home-detail.vue';


import { useLoginedStore, useTokenStore } from '@/stores/store';
import { onMounted } from 'vue';


const judge = useLoginedStore()

const storage = useTokenStore()

onMounted(() => {

})

</script>


<style scoped></style>