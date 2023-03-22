<template>
    <el-empty v-if="hits.length === 0" description="没有匹配的评论，请换关键词后再尝试" />
    <el-space v-else fill direction="vertical" class="space">
        <comment-card-simple v-for="hit in hits" :comment="hit['_source']" :userId="''"
            @click="details(hit['_source'].question)" />
    </el-space>
</template>


<script lang="ts" setup>
import CommentCardSimple from "@/components/cards/comment-card-simple.vue";
import { watchEffect } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const result = defineProps<{
    hits: [{
        _source: {
            id: number,
            question: string,
            parent: number,
            author: string,
            content: string,
            upvote: number,
            devote: number,
            createdTime: Date,
            updatedTime: Date,
            status: boolean,
        }
    }]
}>()

// 需要监听才能取得父组件传递的 hits
watchEffect(
    () => result.hits
)

const details = (questionId: string) => {
    router.push("/question/" + questionId);
}
</script>


<style scoped>
.space {
    width: 100%;
}
</style>