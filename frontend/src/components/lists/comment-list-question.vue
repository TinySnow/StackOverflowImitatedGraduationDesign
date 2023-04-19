<template>
    <el-card v-if="total === 0" shadow="hover" class="no-comment">暂无回答</el-card>
    <el-space v-else fill direction="vertical" size="large" class="space">
        <comment-card v-for="item in data" :key="item.comment.id" :comment="item.comment" :userDto="item.userDto" />
    </el-space>
</template>


<script lang="ts" setup>
import api from "@/apis/main";
import CommentCard from "@/components/cards/comment-card.vue";
import { backend } from "@/utils/baseurl";
import { onMounted, reactive, ref } from "vue";
import { useRoute } from "vue-router";

const route = useRoute()

const data = reactive([{
    comment: {
        id: Number(),
        questionId: Number,
        parent: Number,
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
}])

let total = ref(0)

onMounted(async () => {
    backend.get(api.getCommentList + route.params.id).then(res => {
        total.value = res.data.data.length
        Object.assign(data, res.data.data)
    }).catch(err => {
        console.log(err);
    })
})
</script>


<style scoped>
.no-comment {
    background-color: rgb(209, 233, 248);
    text-align: center;
}

.space {
    width: 100%;
}
</style>