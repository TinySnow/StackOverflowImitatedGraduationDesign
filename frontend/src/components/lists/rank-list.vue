<template>
  <h2 class="rank-head">助人点排行榜</h2>
  <el-space :fill=true>
    <el-card v-for="item in lists" :key="item.id">
      <el-avatar size="" :src="'https://api.multiavatar.com/' + Math.random() + '.svg'" />
      <span class="point">{{ item.points }} 分</span>
    </el-card>
  </el-space>
</template>


<script lang="ts">

import api from '@/utils/baseurl';

export default {
  data() {
    return {
      // 返回的数据结构类型
      lists: [{
        id: Number,
        username: '',
        // password: '',
        avatar: '',
        // email: Number,
        gender: Boolean,
        // birthday: Date,
        points: Number,
        // registerTime: Date,
      }]
    }
  },
  methods: {
    intoProblem(item: Object) {
      console.log(item);
    },
    sort(lists: Array<any>) {
      const list = lists.sort((a, b) => b.points - a.points)
      // console.log(list);
      this.$data.lists = list
    }
  },
  created() {
    api.get('user').then(res => {
      this.sort(res.data.data)
    }).catch(error => {
      console.log(error);
    })
  }
}

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