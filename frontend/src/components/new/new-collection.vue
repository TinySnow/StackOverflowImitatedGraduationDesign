<template>
    <el-dialog v-model="isShow" title="新建问题集" width="90%" :show-close="false" @close="closeDialog" draggable>
        <el-form ref="ruleFormRef" :model="form" :rules="rules" label-width="100px">
            <el-form-item label="问题集标题" prop="title">
                <el-input v-model="form.title" placeholder="标题建议简短精炼，不超过 64 字" />
            </el-form-item>
            <el-form-item label="问题集描述" prop="description">
                <el-input v-model="form.description" autosize type="textarea" placeholder="描述无字数限制" />
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="closeDialog">取消</el-button>
                <el-button type="primary" @click="submit(ruleFormRef)">确定</el-button>
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
    title: '',
    description: ''
})

const rules = reactive<FormRules>({
    title: [
        { required: true, message: '标题不能为空', trigger: 'change' }
    ],
    description: [
        { required: true, message: '标题不能为空', trigger: 'change' }
    ]
})

const emits = defineEmits(["close"])
const isShow = ref(props.show);

watchEffect(() => {
    if (props.show) {
        isShow.value = true
    }
})

const submit = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
            insert()
            closeDialog()
        } else {
            console.log('error submit!', fields)
        }
    })
}

const insert = () =>{
    backend.post(api.newCollection, {
        title: form.title,
        author: props.userId,
        description: form.description
    }, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        if (res.data.data) {
            showMessagesForSuccess("问题集创建成功")
        }
    }).catch(error => {
        console.log(error);
    })
}

const closeDialog = () => {
    isShow.value = false;
    emits("close", false);
}
</script>


<style scoped></style>