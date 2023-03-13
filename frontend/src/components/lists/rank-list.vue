<template>
  <h2 class="rank-head">助人点排行榜</h2>
  <el-space :fill=true>
    <el-card v-for="item in lists" :key="item.id">
      <el-row>
        <el-col class="avatar" :span="8">
          <el-avatar size="large" :src="'https://api.multiavatar.com/' + Math.random() + '.svg'" />
        </el-col>
        <el-col :span="16">
            <p>{{ item.username }}</p>
            <p class="point">{{ item.points }} 分</p>
        </el-col>
      </el-row>
    </el-card>
  </el-space>
</template>


<script lang="ts">
// TODO: 修改卡片樣式，使其左右幷排
import { backend } from '@/utils/baseurl';
import api from "@/apis/main"

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
      // console.log(item);
    },
    sort(lists: Array<any>) {
      const list = lists.sort((a, b) => b.points - a.points)
      // console.log(list);
      this.$data.lists = list
    }
  },
  created() {
    backend.get(api.userList).then(res => {
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

.avatar{
  padding: auto;
  text-align: start;
  align-self: center;
}
.point {
  padding: 0px auto;
  text-align: right;
}
</style>