<template>
    <el-space fill direction="vertical" class="whole-line" size="large">
        <el-card shadow="hover">
            <el-row>
                <el-col :span="2">
                    <el-avatar size="large"
                        :src="props.userDto.user.avatar !== null ? props.userDto.user.avatar : ('https://api.multiavatar.com/' + Math.random() + '.svg')" />
                </el-col>
                <el-col :span="16">
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
                <el-col :span="2">
                    <el-button type="primary" @click="reply()">回复</el-button>
                </el-col>
                <el-col :span="4">
                    <el-space fill direction="vertical" class="space">
                        <el-row class="button-row">
                            <el-button type="primary">
                                <Top class="svg" />
                                赞：{{ props.comment.upvote }}
                            </el-button>
                        </el-row>
                        <el-row class="button-row">
                            <el-button type="info">
                                <Bottom class="svg" />
                                踩：{{ props.comment.devote }}
                            </el-button>
                        </el-row>
                    </el-space>
                </el-col>
            </el-row>
            <hr />
            <md-editor v-model="props.comment.content" preview-only />
        </el-card>
    </el-space>
</template>


<script lang="ts" setup>
import { Top, Bottom, Male, Female } from '@element-plus/icons-vue'
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';

const props = defineProps<{
    comment: {
        id: number,
        questionId: number,
        parent: number,
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

.avatar-col {
    /* background-color: lightseagreen; */
    align-self: center;
    display: flex;
    justify-content: center;
}

.whole-line {
    width: 100%;
}

.points {
    color: rgb(248, 156, 27);
    font-size: x-large;
    margin-top: 3%;
    margin-bottom: 0%;
}
</style>