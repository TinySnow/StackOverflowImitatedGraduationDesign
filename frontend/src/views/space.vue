<template>
    <el-row :gutter="24">
        <el-col :span="5">
            <rank-list />
        </el-col>
        <el-col :span="18">
            <problem-list />
        </el-col>
    </el-row>
</template>


<script lang="ts" setup>
import ProblemList from '@/components/lists/question-list.vue';
import RankList from '@/components/lists/rank-list.vue';


</script>


<style scoped></style>