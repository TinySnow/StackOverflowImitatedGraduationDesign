<template>
    <el-empty v-if="hits.length === 0" description="没有匹配的用户" />
    <el-space v-else warp>
        <user-card v-for="hit in hits" :user="hit['_source']" />
    </el-space>
</template>


<script lang="ts" setup>
import UserCard from "@/components/cards/user-card.vue";
import { watchEffect } from 'vue';


const result = defineProps<{
    hits: [{
        _source: {
            id: number,
            username: string,
            avatar: string,
            gender: boolean,
        }
    }]
}>()

// 需要监听才能取得父组件传递的 hits
watchEffect(
    () => result.hits
)

</script>


<style scoped>
.space {
    width: 100%;
}
</style>