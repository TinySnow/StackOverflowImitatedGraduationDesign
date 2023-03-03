<template>
    <el-card v-for="item in lists" @click="intoProblem(item)">
        <h3>{{ item.title }}</h3>
        <hr />
        <p>{{ item.content }}</p>
    </el-card>
</template>


<script lang="ts">
import api from '@/utils/baseurl';
import backend from "@/apis/api";

export default {
    data() {
        return {
            // 返回的数据结构类型
            lists: [{
                id: Number,
                title: '',
                author: '',
                content: '',
                reward: Number,
                bestAnswer: Boolean,
                createdTime: Date,
                updatedTime: Date,
            }]
        }
    },
    methods: {
        intoProblem(item: Object) {
            console.log(item);
        }
    },
    created() {
        api.get(backend.questionList).then(res => {
            // console.log(res);
            this.$data.lists = res.data.data
        }).catch(error => {
            console.log(error);
        })
    }
}
</script>


<style scoped></style>