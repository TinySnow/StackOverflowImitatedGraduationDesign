<template>
    <el-form ref="ruleFormRef" :model="ruleForm" :rules="rules" label-width="120px" class="demo-ruleForm" size="large"
        status-icon>
        <el-form-item label="用户名" prop="username">
            <el-input v-model="ruleForm.username" placeholder="邮箱" />
        </el-form-item>
        <el-form-item label="密码" prop="password">
            <el-input v-model="ruleForm.password" type="password" placeholder="密码" />
        </el-form-item>
        <el-form-item label="性别" prop="gender">
            <el-select v-model="ruleForm.gender" placeholder="请选择性别">
                <el-option label="男" value=0 />
                <el-option label="女" value=1 />
            </el-select>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-date-picker
            v-model="ruleForm.birthday"
            type="date"
            placeholder="请选择日期"
          />
        </el-form-item>
        <el-form-item label="注册时间">
            <el-input v-model="ruleForm.registerTime" disabled />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="register(ruleFormRef)">注册</el-button>
        </el-form-item>
    </el-form>
</template>


<script lang="ts" setup>

import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { useRouter } from 'vue-router';

const router = useRouter()

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
    username: '',
    password: '',
    birthday: '',
    gender: '',
    registerTime: new Date().toLocaleString(),
})



const rules = reactive<FormRules>({
    username: [
        { required: true, message: '请输入用户名或邮箱', trigger: 'blur' }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'change' }
    ],
    gender: [
        { required: true, message: '请选择性别', trigger: 'change' }
    ],
    birthday: [
        { required: true, message: '请选择生日', trigger: 'change' }
    ],
})

const register = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
            // 推送至后端
            
            // 注册成功后跳转至登录
            router.push('/login')
        } else {
            console.log('error submit!', fields)
        }
    })
}
</script>


<style scoped>

</style>