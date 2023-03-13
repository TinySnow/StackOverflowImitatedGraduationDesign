<template>
    <el-result icon="error" title="404" sub-title="页面未找到，请检查输入">
        <template #extra>
            <el-button type="primary" @click="goBack">返回</el-button>
        </template>
    </el-result>
</template>


<script lang="ts" setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const goBack = () => {
    router.back();
}
</script>


<style scoped></style>