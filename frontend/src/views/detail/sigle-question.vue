<template>
    <el-page-header @back="goBack" class="head"></el-page-header>
    <question-detail />
    <divider />
    <question-comment-list />
    <divider />
    <publish-comment type="question" :id="questionId"/>
</template>


<script lang="ts" setup>

import QuestionCommentList from '@/components/lists/comment-list-question.vue';
import QuestionDetail from '@/components/details/question-detail.vue';
import Divider from "@/components/others/divider.vue";
import PublishComment from "@/components/others/publish-comment.vue";
import { useRoute,useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const questionId = route.params.id.toString()

const goBack = () => {
    router.back();
}
</script>


<style scoped>
.divide {
    padding: 1%;
}
</style>