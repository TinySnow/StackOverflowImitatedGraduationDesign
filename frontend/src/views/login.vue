<template>
    <el-form ref="ruleFormRef" :model="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm" size="large"
        status-icon>
        <el-form-item label="登录账户" prop="email">
            <el-input v-model="ruleForm.email" placeholder="仅支持邮箱登录" />
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input v-model="ruleForm.password" type="password" placeholder="请输入密码" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="login(ruleFormRef)">登录</el-button>
            <el-button @click="jumpToRegister(ruleFormRef)">注册</el-button>
        </el-form-item>
    </el-form>
</template>


<script lang="ts" setup>

import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { showMessagesForError } from "@/utils/show-messages";
import { useRouter } from 'vue-router'
import api from '@/utils/baseurl';
import { useLoginedStore } from '@/stores/counter';

const router = useRouter()
const logined = useLoginedStore()

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
    email: '',
    password: ''
})

const rules = reactive<FormRules>({
    email: [
        { required: true, message: '请输入用户名或邮箱', trigger: 'blur' },
        { type: 'email', message: '请输入正确的邮箱格式', trigger: 'blur' }
    ],
    password: [
        {
            required: true,
            message: '请输入密码',
            trigger: 'change',
        },
    ]
})

const login = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
            api.post('login/body', {
                "email": ruleForm.email,
                "password": ruleForm.password
            }).then(res => {
                console.log(res);
                if (res.data.success) {
                    logined.login()
                    jumpToHome();
                } else {
                    showMessagesForError(res.data.msg);
                }
            }).catch(error => {
                console.log(error);
            })
            // console.log('submit!')
        } else {
            console.log('error submit!', fields)
        }
    })
}

const jumpToHome = () => {
    router.push('/home')
}

const jumpToRegister = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    router.push('/register')
}
</script>


<style scoped></style>