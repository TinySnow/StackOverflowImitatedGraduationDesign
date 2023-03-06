<template>
    <h1>{{ detail.title }}</h1>
    <md-editor v-model="detail.content" preview-only/>
    <p>{{ detail.content }}</p>

</template>


<script lang="ts">
import api from '@/utils/baseurl';
import backend from "@/apis/api";
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';

export default{
    setup(){
    },
    data() {
        return {
            detail: {
                id: this.$route.params.id,
                author: '',
                title: '',
                content: '',
                bestAnswer: '',
                reward: Number,
                createdTime: Date,
                updatedTime: Date,
            }
        };
    },
    methods: {},
    created() {
        api.get(backend.questionDetail + this.detail.id).then(res => {
            console.log(res);
            this.detail = res.data.data
        }).catch(error => {
            console.log(error);
        });
    }
}


</script>


<style scoped>

</style>