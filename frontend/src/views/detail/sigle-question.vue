<template>
    <question-header />
    <question-detail />
    <divider v-if="flag" />
    <best-answer v-if="flag" :comment="props.comment" :userDto="props.userDto" />
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
import BestAnswer from "@/components/others/best-answer.vue";
import { useRoute } from 'vue-router';
import { onMounted, reactive, ref } from "vue";
import { backend } from "@/utils/baseurl";
import api from "@/apis/main";

const route = useRoute();
const questionId = route.params.id.toString()
const flag = ref(false)


const props = reactive({
    comment: {
        id: Number,
        questionId: Number,
        parent: Number,
        author: '',
        content: '',
        upvote: Number,
        devote: Number,
        createdTime: Date,
        updatedTime: Date,
        status: Boolean,
    },
    userDto: {
        point: {
            id: '',
            point: Number,
        },
        user: {
            id: '',
            username: '',
            email: '',
            password: '',
            birthday: '',
            gender: '',
            registerTime: ''
        }
    }
})


onMounted(async () => {
    backend.get(api.getBestAnswer + questionId).then(res => {
        // console.log(res);
        if (res.data.data !== undefined) {
            flag.value = true
        }
        Object.assign(props, res.data.data)
    }).catch(err => {
        console.log(err);
    })
})
</script>


<style scoped></style>