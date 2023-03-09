<template>
    <el-card shadow="hover" v-for="item in comment" :key="item.id">
        作者：{{ item.author }}
        <hr />
        内容：{{ item.content }}
        <hr />
        点赞数：{{ item.upvote }}
        <hr />
        点踩数：{{ item.devote }}
    </el-card>
</template>


<script lang="ts" setup>

import api from "@/apis/main";
import { backend } from "@/utils/baseurl";
import { onMounted, reactive } from "vue";
import { useRoute } from "vue-router";

const route = useRoute()

const comment = reactive([{
    id: Number,
    questionId: Number,
    parent: Number,
    author: Number,
    content: '',
    upvote: Number,
    devote: Number,
    createdTime: Date,
    updatedTime: Date,
    status: Boolean,
    isTop: Boolean
}])

onMounted(async () => {
    backend.get(api.getCommentList + route.params.id).then(res =>{
        // console.log(res);
        Object.assign(comment,res.data.data)
    }).catch(err =>{
        console.log(err);
    })
})
</script>


<style scoped>

</style>