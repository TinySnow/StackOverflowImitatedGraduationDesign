<template>
    <div v-if="storage.token === null && !judge.logined" class="notice">
        <el-card shadow="hover" class="remind-login-card">
            若要评论 请先登录
        </el-card>
    </div>
    <div v-else>
        <el-row>
            <el-col :span="22">
                <el-card shadow="hover" class="logined-card">
                    在下方，书写你的看法！
                </el-card>
            </el-col>
            <el-col :span="2" class="button-style">
                <el-button type="primary" size="large" @click="publish(text)">
                    <p>发表</p>
                </el-button>
            </el-col>
        </el-row>
    </div>
    <md-editor v-model="text" :show-code-row-number="true" />
</template>
  
<script lang="ts" setup>
import { ref } from 'vue';
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { useLoginedStore,useTokenStore } from '@/stores/store';

const judge = useLoginedStore()
const storage = useTokenStore()

const text = ref('');

const publish = (text: string) => {
    console.log(text);
}

</script>

<style scoped>
.notice {
    text-align: center;
    margin-bottom: 3%;
}

.remind-login-card{
    background-color: rgb(209, 233, 248);
}

.button-style {
    text-align: right;
}

.logined-card{
    margin-bottom: 3%;
}
</style>