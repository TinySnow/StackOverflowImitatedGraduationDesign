<template>
    <!-- <p class="index">首页</p> -->
    <el-container>
        <el-aside>
            <rank-list />
        </el-aside>
        <el-main>
            <problem-list/>
        </el-main>
    </el-container>
</template>


<script lang="ts" setup>
import ProblemList from '@/components/lists/problem-list.vue';
import RankList from '@/components/lists/rank-list.vue';


</script>


<style scoped>
.index {
    background-color: lightpink;
    text-align: center;
    padding: 10%;
}
</style>