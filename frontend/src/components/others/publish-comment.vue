<template>
    <div v-if="storage.token === null && !judge.logined" class="notice">
        <el-card shadow="hover" class="remind-login-card">
            若要回复 请先登录
        </el-card>
    </div>
    <div v-else>
        <el-row>
            <el-col :span="22">
                <el-card shadow="hover" class="logined-card">
                    <p>在下方，书写你的看法！</p>
                </el-card>
            </el-col>
            <el-col :span="2" class="button-style">
                <el-space fill direction="vertical" :size="28" class="space">
                    <el-row  class="button-row">
                        <el-button type="primary" @click="publish(text)">
                            <p>发表</p>
                        </el-button>
                    </el-row>
                    <el-row  class="button-row">
                        <el-button type="warning" @click="reset()">
                            <p>清空</p>
                        </el-button>
                    </el-row>
                </el-space>
            </el-col>
        </el-row>
    </div>
    <md-editor v-model="text" :show-code-row-number="true" />
</template>
  
<script lang="ts" setup>
// TODO：接入 api
import { ref } from 'vue';
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { useLoginedStore, useTokenStore } from '@/stores/store';
import { showMessagesForError, showMessagesForSuccess } from '@/utils/show-messages';
import { backend } from '@/utils/baseurl';
import api from '@/apis/main';

const judge = useLoginedStore()

const storage = useTokenStore()

const props = defineProps({
    type: String,
    id: String,
    level: Number
})

// const emit = defineEmits(['change', 'delete'])

const text = ref('');

const publish = (text: string) => {
    if (text === '') {
        showMessagesForError("评论不能为空");
    } else {
        request()
    }
}

const reset = () => {
    text.value = ''
}

const request = () => {
    backend.post(api.newComment, {
        question: props.id,
        parent: props.level,
        content: text.value,
        upvote: 0,
        devote: 0,
        createdTime: new Date().toJSON(),
        status: 1
    }, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        if (res.data.success) {
            // console.log(res);
            showMessagesForSuccess("评论发表成功，请刷新页面")
        } else {
            showMessagesForError(res.data.msg);
        }
    }).catch(err => {
        showMessagesForError(err);
    })
}

</script>

<style scoped>
.notice {
    text-align: center;
    margin-bottom: 3%;
}

.remind-login-card {
    background-color: rgb(209, 233, 248);
}

.button-style {
    text-align: right;
}

.logined-card {
    margin-bottom: 3%;
}

.space {
    width: 100%;
    justify-content: space-between;
}

.button-row {
    display: flex;
    justify-content: right;
}
</style>