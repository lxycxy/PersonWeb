<template>
  <div class="sidemenu">
    <el-menu
        active-text-color="#ffd04b"
        default-active="2"
        text-color="#242f42"
        active-background-color="#20a0ff"
    >
      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <span>Navigator Two</span>
      </el-menu-item>
      <el-menu-item index="3">
        <el-icon><document /></el-icon>
        <span>Navigator Three</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>Navigator Four</span>
      </el-menu-item>
    </el-menu>
  </div>

</template>

<script lang="ts" setup>
import {Document, Menu as IconMenu, Setting} from '@element-plus/icons-vue'
</script>

<style scoped>
.sidemenu {
  overflow: hidden;
  width: 80%;
}
.el-menu :hover {
  background: #00AEEC !important;
  color: #ffffff !important;

}
.sidebar > ul {
  height: 100%;
}
</style>