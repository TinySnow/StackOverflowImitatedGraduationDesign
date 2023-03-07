<template>
    <h1>{{ detail.title }}</h1>
    <md-editor v-model="detail.content" preview-only />
</template>


<script lang="ts" setup>
import url from '@/utils/baseurl';
import backend from "@/apis/backend";
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { reactive, onMounted,onBeforeMount } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute()

let detail = reactive({
    id: route.params.id,
    author: '',
    title: '',
    content: '',
    bestAnswer: '',
    reward: Number,
    createdTime: Date,
    updatedTime: Date,
})

onMounted(async () => {
    url.get(backend.questionDetail + detail.id).then(res => {
        // console.log(res);
        Object.assign(detail,res.data.data)
    }).catch(error => {
        console.log(error);
    });
})

</script>

<style scoped></style>