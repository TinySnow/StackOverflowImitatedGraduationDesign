<template>
    <el-dialog v-model="isShow" title="更新问题集" width="90%" :show-close="false" @close="closeDialog" draggable>
        <el-row v-for="item in questions">
            <el-col :span="2">
                <p class="question-id">问题 ID<br />{{ item.id }}</p>
            </el-col>
            <el-col :span="20">
                <el-collapse v-model="activeNames">
                    <el-collapse-item :title="item.title" :name="item.id">
                        <md-editor v-model="item.content" preview-only />
                    </el-collapse-item>
                </el-collapse>
            </el-col>
            <el-col :span="2">
                <el-button type="warning" plain @click="updateCollection(item.id)">移出</el-button>
            </el-col>
        </el-row>
        <template #footer>
            <span class="dialog-footer">
                <el-button @click="closeDialog">取消</el-button>
                <el-button type="primary" @click="closeDialog">确定</el-button>
            </span>
        </template>
    </el-dialog>
</template>


<script lang="ts" setup>
import { ref, watchEffect, reactive } from 'vue';
import { backend } from '@/utils/baseurl';
import { showMessagesForSuccess } from '@/utils/show-messages';
import api from "@/apis/main";
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';

const props = defineProps<{
    collectionId: string | null,
    show: boolean
}>()


const questions = reactive([{
    id: '',
    title: '',
    content: '',
    createdTime: Date,
    updatedTime: Date
}])

const emits = defineEmits(["close"])
const isShow = ref(props.show);
const activeNames = ref([''])

watchEffect(() => {
    if (props.show) {
        isShow.value = true
        getQuestionsOfSpecificCollection()
    }
})

const updateList = async () => {
    await delayAndClear(500)
    await getQuestionsOfSpecificCollection()
}

const updateCollection = (id: string) => {
    backend.put(api.updateCollection, {
        collectionId: props.collectionId,
        questionId: id
    }, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        if (res.data.data) {
            showMessagesForSuccess("问题 " + id + "移出问题集 " + props.collectionId + " 更新成功")
        }
    }).catch(error => {
        console.log(error);
    })
    updateList()
    emits("close", false);
}

const delayAndClear = (ms: number) => {
    return new Promise(resolve => {
        questions.length = 0
        setTimeout(resolve, ms)
    });
};

const closeDialog = () => {
    isShow.value = false;
    emits("close", true);
}

const getQuestionsOfSpecificCollection = async () => {
    backend.get(api.getQuestionsOfSpecificCollection + props.collectionId, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        console.log(res.data.data);
        Object.assign(questions, res.data.data)
    }).catch(err => {
        console.log(err);
    })
}
</script>


<style scoped></style>