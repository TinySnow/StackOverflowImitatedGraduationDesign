<template>
  <h2 class="rank-head">助人点排行榜</h2>
  <el-space :fill=true>
    <el-card v-for="item in 6" :key="item">
      <el-avatar size="" :src="'https://api.multiavatar.com/' + Math.random() + '.svg'" />
      <span class="point">{{ item }} 分</span>
    </el-card>
  </el-space>
</template>


<script lang="ts" setup>

import { reactive, toRefs } from 'vue';

</script>


<style scoped>
.rank-head {
  text-align: center;
  font-weight: bolder;
  color: rgb(228, 215, 44);
}

/* .point {
  padding: auto;
} */
</style>