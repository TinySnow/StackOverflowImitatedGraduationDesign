<template>
    <el-dialog v-model="isShow" title="更新评论" width="90%" :show-close="false" @close="closeDialog" draggable>
        <el-form ref="ruleFormRef" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="评论内容" prop="content">
                <md-editor v-model="form.content" />
            </el-form-item>
        </el-form>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="closeDialog">取消</el-button>
                <el-button type="primary" @click="updateComment">更新</el-button>
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
    commentId: string | null,
    show: boolean
}>()

const ruleFormRef = ref<FormInstance>()

const form = reactive({
    title: '',
    content: ''
})

const rules = reactive<FormRules>({
    content: [
        { required: true, message: '内容不能为空', trigger: 'change' }
    ]
})

const emits = defineEmits(["close"])
const isShow = ref(props.show);

watchEffect(() => {
    if (props.show) {
        isShow.value = true
        getSingleComment()
    }
})

const updateComment = () => {
    closeDialog()
    backend.put(api.updateComment, {
        id: props.commentId,
        content: form.content
    }, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        if (res.data.data) {
            showMessagesForSuccess("评论 " + props.commentId + " 更新成功")
        }
    }).catch(error => {
        console.log(error);
    })
}

const closeDialog = () => {
    isShow.value = false;
    emits("close", false);
}

const getSingleComment = async () => {
    backend.get(api.getSingleComment + props.commentId).then(res => {
        Object.assign(form, res.data.data)
    }).catch(err => {
        console.log(err);
    })
}
</script>


<style scoped></style>