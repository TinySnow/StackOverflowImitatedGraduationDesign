<!-- TODO: birthday 日期存入数据库格式不正常 -->


<template>
    <el-form ref="ruleFormRef" :model="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm" size="large"
        status-icon>
        <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username" placeholder="请输入用户名" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
            <el-input v-model="ruleForm.email" placeholder="请输入邮箱，邮箱为唯一凭证" />
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input v-model="ruleForm.password" type="password" placeholder="请输入密码，不少于五位" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
            <el-select v-model="ruleForm.gender" placeholder="请选择性别">
                <el-option label="男" value=false />
                <el-option label="女" value=true />
            </el-select>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
            <el-date-picker v-model="ruleForm.birthday" type="date" placeholder="请选择日期" />
        </el-form-item>
        <el-form-item label="注册时间">
            <el-input v-model="exhibtion.time" disabled />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="register(ruleFormRef)">注册</el-button>
        </el-form-item>
    </el-form>
</template>


<script lang="ts" setup>

import { onBeforeUnmount, onMounted, reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { useRouter } from 'vue-router';
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { showMessagesForError } from '@/utils/show-messages';

const router = useRouter()

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
    username: '',
    email: '',
    password: '',
    birthday: '',
    gender: '',
    registerTime: '',
})

const exhibtion = reactive({
    time: ''
})

const rules = reactive<FormRules>({
    username: [
        { required: true, message: '请输入用户名', trigger: 'blur' }
    ],
    email: [
        { required: true, message: '请输入邮箱', trigger: 'blur' },
        { type: 'email', message: '请输入正确的邮箱格式', trigger: 'blur' }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' },
        { min: 5, message: '密码不低于 5 位', trigger: 'change' }
    ],
    gender: [
        { required: true, message: '请选择性别', trigger: 'change' }
    ],
    birthday: [
        { required: true, message: '请选择生日', trigger: 'change' }
    ],
})

let timer: any = null;

onMounted(() => {
    // 每 1s 刷新数据
    timer = setInterval(() => {
        ruleForm.registerTime = new Date().toJSON()
        exhibtion.time = new Date().toLocaleString()
    }, 1000);
})

onBeforeUnmount(() => {
    clearInterval(timer)
    timer = null;
})

const register = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    console.log(ruleForm.birthday);
    console.log(new Date(Date.parse(ruleForm.birthday)).toJSON());
    await formEl.validate((valid, fields) => {
        if (valid) {
            // 推送至后端
            console.log(ruleForm);
            backend.post(api.registerUser, {
                username: ruleForm.username,
                email: ruleForm.email,
                password: ruleForm.password,
                birthday: ruleForm.birthday,
                gender: ruleForm.gender,
                registerTime: ruleForm.registerTime,
                points: 0
            }).then(res => {
                console.log(res);
                if (res.data.success) {
                    // 注册成功后跳转至登录
                    router.push('/login')
                } else {
                    showMessagesForError(res.data.msg);
                }
            }).catch(error => {
                console.log(error);
            })

        } else {
            console.log('error submit!', fields)
        }
    })
}
</script>


<style scoped></style>