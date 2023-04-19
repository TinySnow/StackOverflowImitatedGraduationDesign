<template>
    <el-space fill direction="vertical" class="space">
        <collection-card v-for="collection in collections" :collection="collection" :userId="userIdStore.userId" />
        
    </el-space>
</template>


<script lang="ts" setup>
import CollectionCard from "@/components/cards/collection-card.vue";
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { onMounted, reactive } from 'vue';
import { useUserIdStore } from '@/stores/store';

const userIdStore = useUserIdStore()

const collections = reactive([{
    id: '',
    title: '',
    author: '',
    description: '',
    createdTime: Date,
    updatedTime: Date,
}])


onMounted(async () => {
    backend.get(api.getCollectionListOfOneAuthor + userIdStore.userId, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        // console.log(res);
        Object.assign(collections, res.data.data)
    }).catch(error => {
        console.log(error);
    });
})
</script>


<style scoped>
.space {
    width: 100%;
}
</style>