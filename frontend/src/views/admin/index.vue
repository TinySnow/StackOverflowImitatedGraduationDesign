<template>
    <el-container>
        <el-header class="outer-header">
            <el-col class="header">管理员端</el-col>
        </el-header>
        <el-container>
            <el-aside class="sidebar">
                <sidebar />
            </el-aside>
            <el-main>
                <RouterView />
            </el-main>
        </el-container>
        <el-footer class="outer-footer">
            <custom-footer />
        </el-footer>
    </el-container>
</template>


<script lang="ts" setup>

import Sidebar from "@/components/layout/custom-sidebar.vue";
import customFooter from '@/components/layout/custom-footer.vue'

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
    width: 120px;
    height: 100%;
}
</style>