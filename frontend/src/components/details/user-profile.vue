<template>
    <el-row class="info">
        <el-col :span="3" class="avatar-col">
            <el-avatar shape="circle" :size="100" fit="scale-down"
                :src="profile.user.avatar !== null ? profile.user.avatar : 'https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png'">
            </el-avatar>
        </el-col>
        <el-col :span="12">
            <el-row>
                <el-col :span="10" class="to-center">
                    <h2>{{ profile.user.username }}</h2>
                </el-col>
                <el-col :span="4" class="to-buttom-and-center">
                    <p>
                        性别:
                        <el-icon size="large">
                            <female v-if="profile.user.gender" />
                            <male v-else />
                        </el-icon>
                    </p>
                </el-col>
                <el-col :span="10" class="to-buttom-and-center">
                    <p>出生日期：{{ new Date(profile.user.birthday).toLocaleDateString() }}</p>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="14" class="to-center">
                    邮箱：{{ profile.user.email }}
                </el-col>
                <el-col :span="10" class="to-center">
                    注册时间：{{ new Date(profile.user.registerTime).toLocaleDateString() }}
                </el-col>
            </el-row>
        </el-col>
        <el-col :span="5">
            <el-space fill direction="vertical" class="space" size="large">
                <el-row>
                    <el-col :span="16" class="to-center">
                        <p class="points">{{ profile.point.point }}</p>
                    </el-col>
                    <el-col :span="8" class="vertical-center">
                        <p>助人点</p>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col>
                        <p class="user-id">用户 ID：{{ profile.user.id }}</p>
                    </el-col>
                </el-row>
            </el-space>
        </el-col>
        <el-col :span="4" class="button-group">
            <el-space fill direction="vertical" class="space">
                <el-row class="button-row">
                    <el-button type="info" @click="logout()">退出登录</el-button>
                </el-row>
                <el-row class="button-row">
                    <el-button type="warning">修改信息</el-button>
                </el-row>
                <el-row class="button-row">
                    <el-button type="danger">删除账号</el-button>
                </el-row>
            </el-space>
        </el-col>
    </el-row>
</template>


<script lang="ts" setup>

import { onMounted, reactive } from 'vue'
import { Male, Female } from '@element-plus/icons-vue'

import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { useLoginedStore } from '@/stores/store';
import { useRouter } from 'vue-router';

const status = useLoginedStore();

const router = useRouter();

const profile = reactive({
    user: {
        id: Number,
        username: '',
        avatar: '',
        email: '',
        gender: '',
        birthday: '',
        registerTime: Date(),
    },
    point: {
        point: Number
    }
})

const logout = () => {
    localStorage.removeItem("token");
    status.loginout();
    router.push("/login");
}

onMounted(async () => {
    backend.get(api.getUserProfile, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        Object.assign(profile.user, res.data.data.user)
        Object.assign(profile.point, res.data.data.point)
        // console.log(res);
        // console.log(profile.user.avatar);
    }).catch(err => {
        console.log(err);
    })
})
</script>


<style scoped>
.avatar-col {
    /* background-color: lightseagreen; */
    align-self: center;
    display: flex;
    justify-content: center;
}

.space {
    width: 100%;
    text-align: right;
}

.button-row {
    display: flex;
    justify-content: right;
}

.to-center {
    text-align: center;
}

.to-buttom-and-center {
    text-align: center;
    align-self: center;
}

.to-right {
    text-align: right;
}

.to-buttom {
    align-self: flex-end;
}

.vertical-center {
    display: flex;
    align-self: center;
}

.points {
    color: lightseagreen;
    font-size: xx-large;
    margin: 10% auto;
}

.user-id {
    text-align: center;
    margin: 0% auto;
    align-self: bottom;
    font-size: smaller;
}

.info {
    background-color: lightskyblue;
}
</style>