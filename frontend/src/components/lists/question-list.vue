<template>
    <el-card v-for="item in lists" @click="intoProblem(item.id)">
        <h3>{{ item.title }}</h3>
        <hr />
        <p>{{ item.content }}</p>
    </el-card>
</template>


<script lang="ts">
import { backend } from '@/utils/baseurl';
import api from "@/apis/main"

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
        intoProblem(id: Object) {
            // console.log(id);
            this.$router.push({
                path: '/question/' + id
            })
        }
    },
    created() {
        backend.get(api.questionList).then(res => {
            // console.log(res);
            this.$data.lists = res.data.data
        }).catch(error => {
            console.log(error);
        })
    }
}
</script>


<style scoped></style>