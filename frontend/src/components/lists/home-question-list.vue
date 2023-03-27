<template>
    <el-space fill direction="vertical" class="space">
        <question-card v-for="question in questions" :question="question" :user-id="userIdStore.userId" @update="update"/>
    </el-space>
</template>


<script lang="ts" setup>
import QuestionCard from "@/components/cards/question-card.vue";
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { onMounted, reactive } from 'vue';
import { useUserIdStore } from '@/stores/store';

const userIdStore = useUserIdStore()

const questions = reactive([{
    id: '',
    title: '',
    author: '',
    content: '',
    reward: Number,
    bestAnswer: Boolean,
    createdTime: Date,
    updatedTime: Date,
}])

const update = ()=>{
    getQuestionListOfOneAuthor()
}

const getQuestionListOfOneAuthor = async () => {
    backend.get(api.getQuestionListOfOneAuthor + userIdStore.userId, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        // console.log(res);
        Object.assign(questions, res.data.data)
    }).catch(error => {
        console.log(error);
    });
}


onMounted(getQuestionListOfOneAuthor)
</script>


<style scoped>
.space {
    width: 100%;
}
</style>