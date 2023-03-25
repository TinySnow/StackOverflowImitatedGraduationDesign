<template>
    <div>
        <el-container>
            <el-header class="outer-header">
                <!-- <el-row> -->
                <el-col class="header">
                    管理员后端
                </el-col>
                <!-- </el-row> -->
            </el-header>
            <el-container>
                <el-aside class="sidebar">
                    <sidebar />
                </el-aside>
                <el-container>
                    <el-main>Main</el-main>
                    <el-footer>Footer</el-footer>
                </el-container>
            </el-container>
        </el-container>
    </div>
</template>


<script lang="ts" setup>

import Sidebar from "@/components/sidebar/custom-sidebar.vue";


</script>


<style scoped>
.outer-header {
    background-color: rgb(196, 232, 255);
    border-radius: 4px;
    display: flex;
    align-items: center;
}

.header {
    background-color: rgb(125, 182, 218);
    text-align: center;
    border-radius: 10px;
    font-size: larger;
}

.sidebar {
    width: 150px;
    height: 100%;
}
</style>