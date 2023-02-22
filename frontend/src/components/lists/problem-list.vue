<template>
    <el-row>
        <el-col v-for="item in 6" :key="item">
            <el-card @click="intoProblem(item)">
                <h3>Problem {{ item }}</h3>
                <hr />
                <p>Description {{ item }}</p>
            </el-card>
        </el-col>
    </el-row>
</template>


<script lang="ts" setup>

const intoProblem = function (item :Object) {
    console.log("点击了 "+ item );
}

</script>


<style scoped></style>