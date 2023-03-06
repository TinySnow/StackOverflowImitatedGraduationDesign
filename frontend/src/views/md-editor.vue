<template>
    <md-editor v-model="text" preview-only/>
</template>
  
<script lang="ts" setup>
import { ref } from 'vue';
import MdEditor from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';

const text = ref('# Hello Editor \n ```bash\necho one\n```');
</script>