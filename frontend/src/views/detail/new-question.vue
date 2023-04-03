<template>
    <el-page-header @back="goBack" class="head">
        <template #extra>
            <div>
                <el-button :disabled="true">保存</el-button>
                <el-button type="primary" @click="publish(formRef)">发表</el-button>
            </div>
        </template>
    </el-page-header>

    <el-form ref="formRef" :model="form" :rules="rules" label-width="5em" status-icon>
        <el-form-item label="标题" prop="title">
            <el-input v-model="form.title" />
        </el-form-item>
        <el-form-item label="悬赏点数" prop="reward">
            <el-input class="reward" v-model.number="form.reward" />
        </el-form-item>
        <el-form-item label="内容" prop="content">
            <md-editor v-model="form.content" />
        </el-form-item>
    </el-form>

    <el-alert :title="alert" type="warning" :closable="false" />
</template>


<script lang="ts" setup>
import { reactive, ref } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { useRouter } from 'vue-router';
import { backend } from '@/utils/baseurl';
import api from '@/apis/main';
import { showMessagesForError, showMessagesForSuccess } from '@/utils/show-messages';

const router = useRouter();

const alert = '注意：悬赏点数可不填，不填写即为不进行悬赏；点数不能大于账户助人点总数。'

const form = reactive({
    title: '',
    reward: null,
    content: ''
})

const formRef = ref<FormInstance>()

const rules = reactive<FormRules>({
    title: [
        { required: true, message: '请输入标题', trigger: 'blur' },
    ],
    reward: [
        { type: 'number', message: '悬赏点数必须为数字', trigger: 'change' },
    ],
    content: [
        { required: true, message: '内容不能为空', trigger: 'blur' },
    ],
})

const publish = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
            save()
        } else {
            console.log(fields)
        }
    })
}

const goBack = () => {
    router.back();
}

const save = () => {
    backend.post(api.newQuestion, {
        title: form.title,
        reward: form.reward,
        content: form.content,
        createdTime: new Date().toJSON()
    }, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        if (res.data.success) {
            // console.log(res);
            showMessagesForSuccess("发表成功！")
            jumpToSpace();
        } else {
            showMessagesForError(res.data.msg);
        }
    }).catch(err => {
        showMessagesForError(err);
    })
}

const jumpToSpace = () => {
    router.push('/space')
}
</script>
  

<style scoped>
.head {
    margin-bottom: 2%;
}

.reward {
    width: 6em;
}
</style>