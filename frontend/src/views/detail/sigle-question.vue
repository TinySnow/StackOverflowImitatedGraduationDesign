<template>
    <question-header />
    <question-detail />
    <divider />
    <question-comment-list />
    <divider />
    <publish-comment type="question" :id="questionId" />
</template>


<script lang="ts" setup>
import QuestionCommentList from '@/components/lists/comment-list-question.vue';
import QuestionDetail from '@/components/details/question-detail.vue';
import Divider from "@/components/others/divider.vue";
import QuestionHeader from "@/components/others/question-header.vue";
import PublishComment from "@/components/others/publish-comment.vue";
import { useRoute } from 'vue-router';

const route = useRoute();

const questionId = route.params.id.toString()


</script>


<style scoped></style>