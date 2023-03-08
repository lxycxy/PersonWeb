<template>
  <div class="header">
    <el-row>
      <el-col :span="8">
       <el-image :src="themeImg" :fit="contain" ></el-image>
      </el-col>
      <el-col :offset="8" :span="8">
        <div class="header-user-con">
          <!-- 用户头像 -->
          <el-avatar class="user-avator" :size="30" :src="userStore.photo" />
          <!-- 用户名下拉菜单 -->
          <el-dropdown class="user-name" trigger="click" @command="handleCommand">
					<span class="el-dropdown-link">
						{{ userStore.username }}
						<el-icon class="el-icon--right">
							<arrow-down />
						</el-icon>
					</span>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item command="user" @click="loginVisible = true">个人中心</el-dropdown-item>
                <el-dropdown-item divided command="loginout" @click="userStore.logout()">退出登录</el-dropdown-item>
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-col>
    </el-row>

  </div>


</template>

<script lang="ts" setup>
import {useUserStore} from "@/store/user";
import themeImg from '../assets/img/logo.png'
const userStore = useUserStore();


</script>

<style scoped>
.header {
  position: relative;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 22px;
  color: #fff;
}

.header {
  float: left;
  line-height: 70px;
  margin-left: 40px;
  color: #324157;
}
  /*.el-icon--logo {*/
  /*  background-image: url("@/assets/img/theme.png");*/
  /*  background-size: 100% 100%;*/
  /*  width: 200px;*/
  /*  height: 100px;*/
  /*}*/
.header-user-con {
  display: flex;
  height: 70px;
  align-items: center;
}

.user-name {
  margin-left: 10px;
}
.user-avator {
  margin-left: 20px;
}
.el-dropdown-link {
  color: #324157;
  cursor: pointer;
  display: flex;
  align-items: center;
}
</style>