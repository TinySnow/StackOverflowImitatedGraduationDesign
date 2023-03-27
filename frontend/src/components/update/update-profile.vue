<template>
    <el-dialog v-model="isShow" title="更新个人信息" width="70%" :show-close="false" @close="closeDialog" draggable>
        <el-form ref="ruleFormRef" :model="form" :rules="rules" label-width="120px">
            <el-form-item label="用户名" prop="username">
                <el-input v-model="form.username" placeholder="新的用户名" />
            </el-form-item>
            <el-form-item label="邮箱" prop="email">
                <el-input v-model="form.email" placeholder="新的邮箱，请谨慎修改！" />
            </el-form-item>
            <el-form-item label="性别" prop="gender">
                <el-radio-group v-model="form.gender">
                    <el-radio label="false" @change="test">男</el-radio>
                    <el-radio label="true" @change="test">女</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item label="生日" prop="birthday">
                <el-date-picker v-model="form.birthday" type="date" placeholder="新的生日" />
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="closeDialog">取消</el-button>
                <el-button type="primary" @click="updateProfile">更新</el-button>
            </span>
        </template>
    </el-dialog>
</template>


<script lang="ts" setup>
import { ref, watchEffect, reactive } from 'vue';
import { backend } from '@/utils/baseurl';
import type { FormInstance, FormRules } from 'element-plus'
import { showMessagesForSuccess } from '@/utils/show-messages';
import api from "@/apis/main";

const props = defineProps<{
    userId: string | null,
    show: boolean
}>()

const ruleFormRef = ref<FormInstance>()

const form = reactive({
    username: '',
    email: '',
    gender: true,
    birthday: '',
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

const emits = defineEmits(["close"])
const isShow = ref(props.show);

watchEffect(() => {
    if (props.show) {
        isShow.value = true
        getProfile()
    }
})

const test = () => {
    console.log(form.gender);
}

const updateProfile = () => {
    closeDialog()
    backend.put(api.updateProfile + props.userId, {
        id: props.userId,
        username: form.username,
        email: form.email,
        gender: form.gender,
        birthday: form.birthday
    }, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        showMessagesForSuccess("个人资料更新成功")
        // console.log(res);
    }).catch(error => {
        console.log(error);
    })
}

const closeDialog = () => {
    isShow.value = false;
    emits("close", false);
}

const getProfile = async () => {
    backend.get(api.getUserProfile, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        console.log(res);
        Object.assign(form, res.data.data.user)
    }).catch(err => {
        console.log(err);
    })
}
</script>


<style scoped></style>