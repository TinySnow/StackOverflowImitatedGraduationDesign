<template>
    <el-empty v-if="hits.length === 0" description="没有匹配的问题，请换关键词后再尝试" />
    <el-space fill direction="vertical" class="space">
        <question-card v-for="hit in hits" :question="hit['_source']" :userId="''" @click="details(hit['_source'].id)" />
    </el-space>
</template>


<script lang="ts" setup>
import QuestionCard from "@/components/cards/question-card.vue";
import { watchEffect } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const result = defineProps<{
    hits: [{
        _source: {
            id: string,
            title: string,
            author: string,
            content: string,
            reward: number,
            bestAnswer: boolean,
            createdTime: Date,
            updatedTime: Date
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