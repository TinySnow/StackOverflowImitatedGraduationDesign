<template>
  <el-row>
    <el-col :span="3">
      <el-tabs v-model="active" tab-position="left" class="demo-tabs">
        <el-tab-pane label="问题" name="question" />
        <!-- <el-tab-pane label="文章" name="post" /> -->
        <el-tab-pane label="评论" name="comment" />
        <el-tab-pane label="问题集" name="collection" />
      </el-tabs>
    </el-col>
    <el-col :span="21">
      <home-question-list v-if="active === 'question'" />
      <home-post-list v-if="active === 'post'" />
      <home-comment-list v-if="active === 'comment'" />
      <home-collection-list v-if="active === 'collection'" />
    </el-col>
  </el-row>
</template>


<script lang="ts" setup>
import { ref } from 'vue'

import HomeQuestionList from "@/components/lists/home-question-list.vue";
import HomePostList from "@/components/lists/home-post-list.vue";
import HomeCommentList from "@/components/lists/home-comment-list.vue";
import HomeCollectionList from "@/components/lists/home-collection-list.vue";

const active = ref("question")
</script>


<style scoped>
.demo-tabs>.el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
</style>