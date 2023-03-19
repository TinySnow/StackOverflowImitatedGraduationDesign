<template>
  <h2 class="rank-head">助人点排行榜</h2>
  <el-space :fill=true>
    <el-card v-for="item in lists" :key="item.user.id">
      <el-row>
        <el-col class="avatar" :span="8">
          <el-avatar size="large"
            :src="item.user.avatar !== '' ? item.user.avatar : ('https://api.multiavatar.com/' + Math.random() + '.svg')" />
        </el-col>
        <el-col :span="16">
          <p>{{ item.user.username }}</p>
          <p class="point">{{ item.point.point }} 分</p>
          <!-- <p>{{ item.user.avatar }}</p> -->
        </el-col>
      </el-row>
    </el-card>
  </el-space>
</template>


<script lang="ts">
import { backend } from '@/utils/baseurl';
import api from "@/apis/main"

export default {
  data() {
    return {
      // 返回的数据结构类型
      lists: [{
        user: {
          id: Number,
          username: '',
          // password: '',
          avatar: '',
          // email: Number,
          gender: Boolean,
          // birthday: Date,
          points: Number,
          // registerTime: Date,
        },
        point: {
          point: Number,
        }
      }]
    }
  },
  methods: {
    intoProblem(item: Object) {
      // console.log(item);
    },
    sort(lists: Array<any>) {
      const list = lists.sort((a, b) => b.point.point - a.point.point)
      Object.assign(this.$data.lists,list)
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

.avatar {
  padding: auto;
  text-align: start;
  align-self: center;
}

.point {
  padding: 0px auto;
  text-align: right;
}
</style>