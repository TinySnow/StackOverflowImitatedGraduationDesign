<template>
    <el-row :gutter="24">
        <el-col :span="5">
            <rank-list />
        </el-col>
        <el-col :span="18">
            <question-list />
        </el-col>
    </el-row>
    <!-- <el-backtop :right="100" :bottom="100"/> -->
    <new-question-icon class="test" />
</template>


<script lang="ts" setup>

import QuestionList from '@/components/lists/question-list.vue';
import RankList from '@/components/lists/rank-list.vue';
import NewQuestionIcon from "@/components/others/new-question-icon.vue";

</script>


<style scoped>
.test {
    text-align: right;
}
</style>