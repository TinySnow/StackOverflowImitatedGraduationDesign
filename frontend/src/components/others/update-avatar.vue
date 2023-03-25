<template>
    <div v-if="isShow">
        <el-dialog v-model="isShow" title="上传头像" width="70%" :show-close="false">
            <el-upload ref="upload" drag action="#" :auto-upload="false" :on-change="onChange" :limit="1"
                :on-exceed="handleExceed">
                <el-icon class="el-icon--upload"><upload-filled /></el-icon>
                <div class="el-upload__text">
                    拖拽图片 或 <em>点击上传</em>
                </div>
                <template #tip>
                    <div class="el-upload__tip">
                        jpg/png 文件应小于 500kb
                    </div>
                </template>
            </el-upload>
            <img w-full class="img" :src="imageUrl" />
            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="closeDialog()">取消</el-button>
                    <el-button type="primary" @click="uploadAvatar()">
                        确定
                    </el-button>
                </span>
            </template>
        </el-dialog>
    </div>
</template>


<script lang="ts" setup>
import { UploadFilled } from '@element-plus/icons-vue'
import type { UploadRawFile, UploadFile, UploadProps } from 'element-plus'
import { backend } from '@/utils/baseurl';
import api from "@/apis/main";
import { showMessagesForError, showMessagesForSuccess } from '@/utils/show-messages';
import type { UploadInstance } from 'element-plus'
import { ref, watchEffect } from 'vue';

const props = defineProps<{
    userId: string | null,
    show: boolean
}>()

const emits = defineEmits(["close"])

const isShow = ref(props.show);
const imageUrl = ref('')
const upload = ref<UploadInstance>()

watchEffect(() => {
    if (props.show) {
        isShow.value = true
    }
})

const handleExceed: UploadProps['onExceed'] = (files) => {
    upload.value!.clearFiles()
    const file = files[0] as UploadRawFile
    upload.value!.handleStart(file)
}

const onChange = (uploadFile: UploadFile) => {
    const reader = new FileReader();
    reader.readAsDataURL(uploadFile.raw as File);
    reader.onload = () => {
        imageUrl.value = reader.result as string;
    };
    console.log(imageUrl.value);
}

const uploadAvatar = () => {
    closeDialog()
    backend.put(api.updateAvatar + props.userId, {
        url: imageUrl.value
    }, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        console.log(res);
        if (res.data.success) {
            // showMessagesForSuccess("头像更新成功，请刷新页面")
        } else {
            showMessagesForError(res.data.msg);
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


<style scoped>
.img {
    width: 30%;
    height: 50%;
}
</style>