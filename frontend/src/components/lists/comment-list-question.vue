<template>
    <el-card v-if="total === 0" shadow="hover" class="no-comment">暂无回答</el-card>
    <el-card v-else shadow="hover" v-for="item in comment" :key="item.id">
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
import { onMounted, reactive, ref } from "vue";
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

let total = ref(0)

onMounted(async () => {
    backend.get(api.getCommentList + route.params.id).then(res => {
        console.log(res);
        total.value = res.data.data.length
        Object.assign(comment, res.data.data)
    }).catch(err => {
        console.log(err);
    })
})
</script>


<style scoped>
.no-comment{
    background-color: rgb(209, 233, 248);
    text-align: center;
}
</style>