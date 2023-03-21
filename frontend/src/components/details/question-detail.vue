<template>
    <h1 class="title">{{ detail.title }}</h1>
    <md-editor v-model="detail.content" preview-only />
    <div v-if="tags[0].id !== ''">
        <el-space size="large">
            <el-tag v-for="item in tags" :key="item.label" effect="light">
                {{ item.label }}
            </el-tag>
        </el-space>
    </div>
</template>


<script lang="ts" setup>
// TODO：加入收藏问题集功能
// TODO：显示悬赏助人点
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { reactive, onMounted } from 'vue';
import { useRoute } from 'vue-router';

const route = useRoute()

const detail = reactive({
    id: '',
    author: '',
    title: '',
    content: '',
    bestAnswer: '',
    reward: Number,
    createdTime: Date,
    updatedTime: Date,
})

const tags = reactive([{
    id: '',
    label: ''
}])

onMounted(async () => {
    backend.get(api.questionDetail + route.params.id).then(res => {
        // console.log(res);
        Object.assign(detail, res.data.data)
    }).catch(error => {
        console.log(error);
    });

    backend.get(api.getTagList + route.params.id).then(res => {
        // console.log(res);
        Object.assign(tags, res.data.data)
        console.log(tags);

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