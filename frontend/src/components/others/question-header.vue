<template>
    <el-page-header @back="goBack" class="head">
        <template #content>
            <div class="to-center">
                <el-avatar :size="32"
                    :src="user.avatar !== null ? user.avatar : ('https://api.multiavatar.com/' + Math.random() + '.svg')" />
                <span class="to-center">　{{ user.username }}</span>
            </div>
        </template>
        <template #extra>
            <el-dropdown class="to-center">
                <span class="el-dropdown-link">
                    加入问题集
                    <el-icon class="el-icon--right">
                        <arrow-down />
                    </el-icon>
                </span>
                <template #dropdown>
                    <el-dropdown-menu v-if="storage.token === null && !judge.logined">
                        <el-dropdown-item>请先登录</el-dropdown-item>
                    </el-dropdown-menu>
                    <el-dropdown-menu v-else>
                        <el-dropdown-item>Action 1</el-dropdown-item>
                        <el-dropdown-item>Action 2</el-dropdown-item>
                        <el-dropdown-item>Action 3</el-dropdown-item>
                    </el-dropdown-menu>
                </template>
            </el-dropdown>
        </template>
    </el-page-header>
</template>


<script lang="ts" setup>
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { reactive, onMounted } from 'vue';
import { ArrowDown } from '@element-plus/icons-vue'
import { useRoute, useRouter } from 'vue-router';
import { useLoginedStore, useTokenStore } from '@/stores/store';

const judge = useLoginedStore()
const storage = useTokenStore()
const route = useRoute();
const router = useRouter();

const questionId = route.params.id.toString()

const goBack = () => {
    router.back();
}

const user = reactive({
    id: Number,
    username: '',
    avatar: '',
    email: '',
    gender: '',
    birthday: '',
    registerTime: Date(),
})

onMounted(async () => {
    backend.get(api.getQuestionAuthor(questionId)).then(res => {
        // console.log(res);
        Object.assign(user, res.data.data)
    }).catch(error => {
        console.log(error);
    });
})
</script>


<style scoped>
.el-dropdown-link {
    cursor: pointer;
    color: var(--el-color-primary);
    display: flex;
    align-items: center;
}

.to-center {
    display: flex;
    align-self: center;
    text-align: center;
}
</style>