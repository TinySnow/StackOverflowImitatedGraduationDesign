<template>
    <el-space fill direction="vertical" class="space">
        <comment-card-simple v-for="comment in comments" :comment="comment" :userId="userIdStore.userId" @update="update"/>
    </el-space>
</template>


<script lang="ts" setup>
import CommentCardSimple from "@/components/cards/comment-card-simple.vue";
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { onMounted, reactive } from 'vue';
import { useUserIdStore } from '@/stores/store';

const userIdStore = useUserIdStore()

const comments = reactive([{
    id: '',
    questionId: '',
    parent: Number,
    author: '',
    content: '',
    upvote: Number,
    devote: Number,
    createdTime: Date,
    updatedTime: Date,
    status: Boolean,
}])

const update = () => {
    comments.length = 0
    getCommentListOfOneAuthor()
}

const getCommentListOfOneAuthor = async () => {
    backend.get(api.getCommentListOfOneAuthor + userIdStore.userId, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        Object.assign(comments, res.data.data)
    }).catch(error => {
        console.log(error);
    });
}

onMounted(getCommentListOfOneAuthor)
</script>


<style scoped>
.space {
    width: 100%;
}
</style>