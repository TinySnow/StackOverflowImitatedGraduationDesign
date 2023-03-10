<template>
    <h1 class="title">{{ detail.title }}</h1>
    <md-editor v-model="detail.content" preview-only />
</template>


<script lang="ts" setup>
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { reactive, onMounted } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute()

let detail = reactive({
    id: '',
    author: '',
    title: '',
    content: '',
    bestAnswer: '',
    reward: Number,
    createdTime: Date,
    updatedTime: Date,
})

onMounted(async () => {
    backend.get(api.questionDetail + route.params.id).then(res => {
        // console.log(res);
        Object.assign(detail, res.data.data)
    }).catch(error => {
        console.log(error);
    });
})

</script>

<style scoped>
.title {
    text-align: center;
}
</style>