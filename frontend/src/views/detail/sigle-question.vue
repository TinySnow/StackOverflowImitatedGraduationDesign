<template>
    <question-detail />
    <divider />
    <question-comment-list />
    <divider />
    <publish-comment />
</template>


<script lang="ts" setup>

import QuestionCommentList from '@/components/lists/comment-list-question.vue';
import QuestionDetail from '@/components/details/question-detail.vue';
import Divider from "@/components/others/divider.vue";
import PublishComment from "@/components/others/publish-comment.vue";

</script>


<style scoped>
.divide {
    padding: 1%;
}
</style>