
<template>
  <router-view />
</template>
<script setup>
import {onMounted} from "vue";
onMounted(() => {
  document.body.style.setProperty('--el-color-primary', '#c5fcab');
  document.body.style.setProperty('--el-color-primary-light-9', '#F5FBF0');
  document.body.style.setProperty('--el-color-primary-light-3', '#95d475');
})

</script>
<style>
@import './assets/css/main.css';
@import './assets/css/color-dark.css';
</style>
