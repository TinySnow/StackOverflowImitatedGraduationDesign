<template>
    <div class="expand">
        <el-row :gutter="20">
            <el-col :span="22">
                <el-input v-model="keywords" size="large" placeholder="输入关键词以启动搜索" class="input-with-select">
                    <template #prepend>
                        <el-select size="large" v-model="type" placeholder="搜索类型" style="width: 115px">
                            <el-option label="用户" value="user" />
                            <el-option label="问题" value="question" />
                            <el-option label="文章" value="post" />
                            <el-option label="评论" value="comment" />
                        </el-select>
                    </template>
                    <template #append>
                        <el-button :icon="Search" @click="searchBackend(type, keywords)" />
                    </template>
                </el-input>

            </el-col>
            <el-col :span="2">
                <el-button size="large" type="primary" @click="searchBackend(type, keywords)">搜索</el-button>
            </el-col>
        </el-row>
    </div>
</template>


<script lang="ts" setup>

import { ref } from 'vue'
import { Search } from '@element-plus/icons-vue'

const keywords = ref('')
const type = ref('')

const searchBackend = (type: string, keywords: string) => {
    console.log("类型：" + type + "\n" + "关键词：" + keywords);
}
</script>


<style scoped>
.expand {
    padding: 10%;
}
</style>