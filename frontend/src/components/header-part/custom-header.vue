<template>
    <!-- 考虑换成响应式布局 -->
    <el-row :gutter="20">
        <el-col :span="4">
            <p class="header-rank-chacaters">搜索</p>
        </el-col>
        <el-col :span="16" @click="toSpace">
            <p class="header-index-chacaters">首页</p>
        </el-col>
        <el-col :span="4" @click="toHome">
            <p class="header-home-characters">个人中心</p>
            <!-- <el-avatar class="avatar-style" size="large" :src="imgurl" /> -->
        </el-col>
    </el-row>
</template>

<script lang="ts">
export default {
    props: ['initialCounter'],
    data() {
        return {
            imgurl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png'
        }
    },
    methods: {
        toSpace(){
            this.$router.push('/space')
        },
        toHome(){
            this.$router.push('/login')
        }
    }
}
</script>

<style scoped>
.header-rank-chacaters {
    background-color: red;
    text-align: center;
    font-size: larger;
}

.header-index-chacaters {
    background-color: purple;
    text-align: center;
    font-size: larger;
}

.header-home-characters {
    background-color: aqua;
    text-align: center;
    font-size: larger;
}

.avatar-style {
    text-align: right;
}
</style>
