<template>
    <p class="best-answer-text">✨最佳答案✨</p>
    <comment-card class="best" :comment="props.comment" :userDto="props.userDto" />
</template>


<script lang="ts" setup>
import CommentCard from "@/components/cards/comment-card.vue";

const props = defineProps<{
    comment: {
        id: number,
        questionId: number,
        parent: number,
        author: string,
        content: string,
        upvote: number,
        devote: number,
        createdTime: Date,
        updatedTime: Date,
        status: boolean,
    },
    userDto: {
        point: {
            id: string,
            point: number
        },
        user: {
            id: string,
            username: string,
            avatar: string,
            email: string,
            birthday: string,
            gender: string,
            registerTime: string,
        }
    }
}>()

</script>


<style scoped>
.best {
    /* background-color: lightpink; */
}

.best-answer-text {
    background-color: rgb(196, 232, 255);
    font-size: xx-large;
    text-align: center;
    margin: 0% auto;
}
</style>