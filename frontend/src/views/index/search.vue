<template>
    <div class="expand">
        <el-input v-model="keywords" size="large" placeholder="输入关键词以启动搜索">
            <template #prepend>
                <el-select size="large" v-model="type" placeholder="搜索类型" style="width: 115px" @change="validate()">
                    <el-option label="用户" value="user" />
                    <el-option label="问题" value="question" />
                    <!-- <el-option label="文章" value="post" /> -->
                    <el-option label="评论" value="comment" />
                    <el-option label="问题集" value="collection" />
                </el-select>
            </template>
            <template #append>
                <el-button class="search-icon" type="primary" :icon="Search" @click="validate()"/>
            </template>
        </el-input>
    </div>
    <div>
        <search-user-list v-if="type === 'user'" :hits="result" />
        <search-question-list v-if="type === 'question'" :hits="result" />
        <!-- <search-post-list v-if="type === 'post'" :hits="result" /> -->
        <search-comment-list v-if="type === 'comment'" :hits="result" />
        <search-collection-list v-if="type === 'collection'" :hits="result" />
    </div>
</template>


<script lang="ts" setup>
import SearchUserList from "@/components/lists/search-user-list.vue";
import SearchQuestionList from "@/components/lists/search-question-list.vue";
// import SearchPostList from "@/components/lists/search-post-list.vue";
import SearchCommentList from "@/components/lists/search-comment-list.vue";
import SearchCollectionList from "@/components/lists/search-collection-list.vue";
import { showMessagesForError } from "@/utils/show-messages";
import { ref, reactive } from 'vue'
import { Search } from '@element-plus/icons-vue'
import { search } from "@/utils/baseurl";

const keywords = ref('')
const type = ref('')
const result = reactive([])
const isShow = ref(false)

interface Query {
    [key: string]: any
}


const confirmSearchFields = (type: string) => {
    let query: Query = new Object();
    if (type === 'user') {
        query = {
            query: {
                bool: {
                    should: [
                        { match: { username: keywords.value } }
                    ]
                }
            }
        };
    } else if (type === 'question') {
        query = {
            query: {
                bool: {
                    should: [
                        { match: { title: keywords.value } },
                        { match: { content: keywords.value } }
                    ]
                }
            }

        }
    } else if (type === 'comment') {
        query = {
            query: {
                bool: {
                    should: [
                        { match: { content: keywords.value } }
                    ]
                }
            }
        }
    } else if (type === 'collection') {
        query = {
            description: keywords.value
        }
    }
    return query;
}

const validate = () => {
    if (type.value === '') {
        showMessagesForError("请选择搜索类型");
    } else if (keywords.value === '') {
        showMessagesForError("请输入搜索关键词！");
    } else {
        searchElastic();
    }
}

const elastic = (type: string) => type + "/_search"


const searchElastic = () => {
    // console.log(confirmSearchFields(type.value));
    isShow.value = true;
    search.post(elastic(type.value), confirmSearchFields(type.value)).then(res => {
        console.log(res);
        if (res.data.hits.hits.length === 0) {
            result.length = 0
        } else {
            Object.assign(result, res.data.hits.hits)
        }
    }).catch(err => {
        console.log(err);
    })
}
</script>


<style scoped>
.expand {
    padding: 10%;
}
.search-icon{
    width: 80px;
    background-color:red;
}
</style>