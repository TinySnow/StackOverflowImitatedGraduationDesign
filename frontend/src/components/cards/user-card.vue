<template>
    <el-card class="card">
        <el-row>
            <el-col class="avatar" :span="10">
                <el-avatar size="large"
                    :src="user.avatar !== null ? user.avatar : ('https://api.multiavatar.com/' + Math.random() + '.svg')" />
            </el-col>
            <el-col :span="14">
                <p>{{ user.username }}</p>
                <!-- <p class="point">5 分</p> -->
            </el-col>
        </el-row>
    </el-card>
</template>


<script lang="ts" setup>
import { useUserIdStore } from '@/stores/store';
import { ref } from 'vue'
import { ArrowDown } from '@element-plus/icons-vue'
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';

const userIdStore = useUserIdStore()

const props = defineProps<{
    user: {
        id: number,
        username: string,
        avatar: string,
        gender: boolean,
    },
    // points: number
}>()

</script>


<style scoped>
.card{
    width: 200px;
}

.avatar {
  padding: auto;
  text-align: center;
  align-self: center;
}
</style>