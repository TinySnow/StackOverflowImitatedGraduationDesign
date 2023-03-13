<template>
    <el-affix position="bottom" :offset="100">
        <el-popover class="unlogined-popover" v-if="storage.token === null && !judge.logined" placement="top-start"
            :width="200" trigger="hover" content="若要提问，请先登录">
            <template #reference>
                <el-button class="logined-button" type="primary" size="large" :icon="Edit" circle></el-button>
            </template>
        </el-popover>
        <el-button v-else type="primary" size="large" :icon="Edit" @click="() => router.push('/question/new')"
            circle></el-button>
    </el-affix>
</template>


<script lang="ts" setup>

import { Edit } from '@element-plus/icons-vue'
import { useLoginedStore, useTokenStore } from '@/stores/store';
import { useRouter } from 'vue-router';

const router = useRouter();

const judge = useLoginedStore()

const storage = useTokenStore()

</script>


<style scoped>
.unlogined-popover {
    position: fixed;
    bottom: 10%;
    right: 10%;
    z-index: 100;
}

.logined-button {
    right: 10%;
    text-align: right;
}
</style>