<template>
  <div class="sidemenu">
    <div class="logo">
      <el-row>
        <el-col :offset="2" :span="8">
          <el-image :src="logoImg" style="height: 50px"></el-image>
        </el-col>
        <el-col :offset="6" :span="8" >
          <el-popover
              placement="bottom-start"
              :width="250"
          >
            <el-row>
              <el-col :offset="2" :span="6">
                <img style="width: 35px; border-radius: 100%" :src="userStore.photo">
              </el-col>
              <el-col :offset="8" :span="8" >
               <span style="height: 40px; line-height: 40px">{{userStore.username}}</span>
              </el-col>
            </el-row>

            <el-divider style="margin: 5px"/>
            <div class="introduce">
              <span> 这个人很懒，什么都没留下~</span>
            </div>

            <el-divider style="margin: 5px"/>

            <el-row class="logout-button" justify="end">
              <el-button type="info" round @click="userStore.logout()"><el-icon><Right /></el-icon></el-button>
            </el-row>

            <template #reference>
              <el-button class="logo-button">
                <span class="logo-content">
                  <img style="width: 35px; border-radius: 100%" :src="userStore.photo">
                </span>
              </el-button>
            </template>
          </el-popover>

        </el-col>
      </el-row>
    </div>

    <el-menu
        active-text-color="#00AEEE"
        default-active="2"
        text-color="#242f42"
        active-background-color="#20a0ff"
    >
      <el-menu-item index="2">
        <el-icon><icon-menu /></el-icon>
        <span>首页</span>
      </el-menu-item>
      <el-menu-item index="3">
        <el-icon><document /></el-icon>
        <span>日记库</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><setting /></el-icon>
        <span>Navigator Four</span>
      </el-menu-item>
    </el-menu>
  </div>




</template>

<script lang="ts" setup>
import {Document, Menu as IconMenu, Setting, ArrowDownBold} from '@element-plus/icons-vue'
import logoImg from '@/assets/img/logo2.png'
import {useUserStore} from "@/store/user";
import {ref} from "vue";
const userStore = useUserStore();

</script>

<style scoped>

.logo {
  background-color: #f0f0f0;
}
.sidemenu {
  overflow: hidden;
  width: 18%;
  height: 100%;
}
.el-menu :hover {
  background: #00AEEC !important;
  color: #ffffff !important;
}
.introduce {
  margin-left: 5%;
}
.popove-content {
  margin: 0;
  padding: 0;
}
.logo-button {
  background-color:#f0f0f0 ;
  width: 50px;
  margin-top: 12%;
  border: #f0f0f0;
}
.logo-button :hover{
  background-color: #c5c3c3 !important;
  width: 50px;
  border-radius: 10px;
}

.sidebar > ul {
  height: 100%;
}
</style>