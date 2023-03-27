<template>
    <el-dialog v-model="isShow" title="更新问题" width="90%" :show-close="false" @close="closeDialog" draggable>
        <el-form ref="ruleFormRef" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="问题标题" prop="title">
                <el-input v-model="form.title" placeholder="新的问题标题" />
            </el-form-item>
            <el-form-item label="问题详情" prop="content">
                <md-editor v-model="form.content" />
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="closeDialog">取消</el-button>
                <el-button type="primary" @click="updateQuestion">更新</el-button>
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
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';

const props = defineProps<{
    questionId: string | null,
    show: boolean
}>()

const ruleFormRef = ref<FormInstance>()

const form = reactive({
    title: '',
    content: ''
})

const rules = reactive<FormRules>({
    title: [
        { required: true, message: '请输入用户名', trigger: 'blur' }
    ],
    content: [
        { required: true, message: '请输入邮箱', trigger: 'blur' }
    ]
})

const emits = defineEmits(["close"])
const isShow = ref(props.show);

watchEffect(() => {
    if (props.show) {
        isShow.value = true
        getSingleQuestion()
    }
})

const updateQuestion = () => {
    closeDialog()
    backend.put(api.updateQuestion, {
        id: props.questionId,
        title: form.title,
        content: form.content
    }, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        showMessagesForSuccess("问题 " + props.questionId + " 更新成功")
    }).catch(error => {
        console.log(error);
    })
}

const closeDialog = () => {
    isShow.value = false;
    emits("close", false);
}

const getSingleQuestion = async () => {
    backend.get(api.getQuestion + props.questionId).then(res => {
        // console.log(res);
        Object.assign(form, res.data.data)
    }).catch(err => {
        console.log(err);
    })
}
</script>


<style scoped></style>