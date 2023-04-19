<template>
    <el-card shadow="hover">
        <el-row>
            <el-col :span="2">
                <el-avatar size="large"
                    :src="userDto.user.avatar !== null ? userDto.user.avatar : ('https://api.multiavatar.com/' + Math.random() + '.svg')" />
            </el-col>
            <el-col :span="18">
                <el-row>
                    {{ props.userDto.user.username }}
                    <el-icon size="large">
                        <female v-if="props.userDto.user.gender" />
                        <male v-else />
                    </el-icon>
                </el-row>
                <el-row>
                    <p class="points">{{ props.userDto.point.point }} 助人点</p>
                </el-row>
            </el-col>
            <el-col :span="4">
                <el-space fill direction="vertical" class="space">
                    <el-row class="button-row">
                        <el-button-group class="ml-4">
                            <el-button type="primary">
                                <Top class="svg" />{{ props.comment.upvote }}
                            </el-button>
                            <el-button type="info">
                                <Bottom class="svg" />{{ props.comment.devote }}
                            </el-button>
                        </el-button-group>
                    </el-row>
                    <el-row class="button-row">
                        <el-dropdown>
                            <el-button type="info">
                                <el-icon>
                                    <More class="svg" />
                                </el-icon>
                            </el-button>
                            <template #dropdown>
                                <el-dropdown-menu>
                                    <el-dropdown-item :icon="ChatDotRound">
                                        <span class="primary-color">回复</span>
                                    </el-dropdown-item>
                                    <el-dropdown-item :icon="Check">
                                        <span class="success-color" @click="markAsBestAnswer">标记为最佳答案</span>
                                    </el-dropdown-item>
                                    <el-dropdown-item v-if="props.comment.author === user.userId" :icon="Warning">
                                        <el-popconfirm width="220" title="确认删除评论？" :icon="InfoFilled" icon-color="#FF0000"
                                            confirm-button-text="确认" cancel-button-text="取消" @confirm="del()">
                                            <template #reference>
                                                <span class="danger-color">删除</span>
                                            </template>
                                        </el-popconfirm>
                                    </el-dropdown-item>
                                </el-dropdown-menu>
                            </template>
                        </el-dropdown>
                    </el-row>
                </el-space>
            </el-col>
        </el-row>
        <hr />
        <md-editor v-model="props.comment.content" preview-only />
    </el-card>
</template>


<script lang="ts" setup>
import { useUserIdStore } from '@/stores/store';
import { backend } from '@/utils/baseurl';
import { Top, Bottom, Male, Female, More, ChatDotRound, Check, Warning, InfoFilled } from '@element-plus/icons-vue';
import api from "@/apis/main";
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { showMessagesForError, showMessagesForSuccess } from '@/utils/show-messages';
import { useRoute } from 'vue-router';

const user = useUserIdStore()
const route = useRoute()

const props = defineProps<{
    comment: {
        id: number,
        questionId: number,
        parent: number,
        author: string,
        content: string,
        upvote: number,
        devote: number,
        createdTime: Date,
        updatedTime: Date,
        status: boolean,
    },
    userDto: {
        point: {
            id: string,
            point: number
        },
        user: {
            id: string,
            username: string,
            avatar: string,
            email: string,
            birthday: string,
            gender: string,
            registerTime: string,
        }
    }
}>()


const reply = () => {
    // TODO：子传父组件，标记回复 ID
}

const del = () => {
    backend.delete(api.deleteComment + props.comment.id, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        console.log(res);
        if (res.data.success) {
            showMessagesForSuccess(res.data.msg)
        } else {
            showMessagesForError(res.data.msg);
        }
    }).catch(error => {
        console.log(error);
    })
}

const markAsBestAnswer = () => {
    backend.put(api.markBest, {
        questionId: route.params.id,
        bestAnswerId: props.comment.id,
    }, {
        headers: {
            Authorization: localStorage.getItem("token")
        }
    }).then(res => {
        console.log(res);
        if (res.data.success) {
            showMessagesForSuccess(res.data.msg)
        } else {
            showMessagesForError(res.data.msg);
        }
    }).catch(error => {
        console.log(error);
    })
}
</script>


<style scoped>
.svg {
    width: 1.2em;
    height: 1.2em;
}

.button-row {
    display: flex;
    justify-content: right;
}

.space {
    width: 100%;
    text-align: right;
}

.points {
    color: rgb(248, 156, 27);
    font-size: x-large;
    margin-top: 3%;
    margin-bottom: 0%;
}

.danger-color {
    color: #f89898;
}

.success-color {
    color: #95d475;
}

.primary-color {
    color: #79bbff;
}
</style>