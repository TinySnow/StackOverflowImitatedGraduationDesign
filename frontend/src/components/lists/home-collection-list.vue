<template>
    <el-card class="new-collection" @click="popup">
        <el-link type="primary">创建新的问题集</el-link>
    </el-card>
    <custom-divider />
    <el-empty v-if="collections[0].id === ''" description="暂无收藏的问题集" />
    <el-space v-else fill direction="vertical" class="space">
        <collection-card v-for="collection in collections" :collection="collection" :userId="userIdStore.userId" />
    </el-space>
    <new-collection :user-id="userIdStore.userId" :show="isDialogShow" @close="close" />
</template>


<script lang="ts" setup>
import CustomDivider from "@/components/layout/divider.vue";
import CollectionCard from "@/components/cards/collection-card.vue";
import NewCollection from "@/components/new/new-collection.vue";
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { onMounted, reactive, ref } from 'vue';
import { useUserIdStore } from '@/stores/store';

const userIdStore = useUserIdStore()
const isDialogShow = ref(false)

const collections = reactive([{
    id: '',
    title: '',
    author: '',
    description: '',
    createdTime: Date,
    updatedTime: Date,
    question: []
}])

const popup = () => {
    isDialogShow.value = true
}
const close = () => {
    isDialogShow.value = false
}
onMounted(async () => {
    backend.get(api.getCollectionListOfOneAuthor + userIdStore.userId, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        console.log(res.data.data);
        Object.assign(collections, res.data.data)
        localStorage.setItem("collections",JSON.stringify(res.data.data))
    }).catch(error => {
        console.log(error);
    });
})
</script>


<style scoped>
.space {
    width: 100%;
}

.new-collection {
    text-align: center;
}
</style>