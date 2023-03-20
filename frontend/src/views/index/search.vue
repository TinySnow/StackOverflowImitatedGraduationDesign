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
                            <el-option label="问题集" value="set" />
                        </el-select>
                    </template>
                    <template #append>
                        <el-button :icon="Search" @click="searchElastic(type, keywords)" />
                    </template>
                </el-input>

            </el-col>
            <el-col :span="2">
                <el-button size="large" type="primary" @click="searchElastic(type, keywords)">搜索</el-button>
            </el-col>
        </el-row>
    </div>
    <div>
        <el-tabs type="border-card" :stretch="true">
            <el-tab-pane label="用户">
                {{ result }}
            </el-tab-pane>
            <el-tab-pane label="问题">
                {{ result }}
            </el-tab-pane>
            <el-tab-pane label="文章">
                {{ result }}
            </el-tab-pane>
            <el-tab-pane label="评论">
                {{ result }}
            </el-tab-pane>
            <el-tab-pane label="问题集">
                {{ result }}
            </el-tab-pane>
        </el-tabs>
        
    </div>
</template>


<script lang="ts" setup>

import { ref, reactive } from 'vue'
import { Search } from '@element-plus/icons-vue'
import { search } from "@/utils/baseurl";
import api from '@/apis/main';

const keywords = ref('')
const type = ref('')
const result = reactive([])

const searchElastic = (type: string, keywords: string) => {
    console.log("类型：" + type + "\n" + "关键词：" + keywords);
    search.post(api.elastic.search(type), api.elastic.content({ username: keywords })).then(res => {
        console.log(res);
        Object.assign(result, res.data.hits.hits)
    }).catch(err => {
        console.log(err);
    })
}
</script>


<style scoped>
.expand {
    padding: 10%;
}
</style>