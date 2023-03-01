<template>
  <div class="header">
    <div class="logo">
      <el-image style="width: 150px;height: 100px" :src="logoImg" :fit="cover"/>
    </div>
    <div class="header-right">
      <div class="header-user-con">
        <!-- 用户头像 -->
        <el-avatar class="user-avator" :size="30" :src="qqImg" />
        <!-- 用户名下拉菜单 -->
        <el-dropdown class="user-name" trigger="click" @command="handleCommand">
					<span class="el-dropdown-link">
						name
						<el-icon class="el-icon--right">
							<arrow-down />
						</el-icon>
					</span>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item command="user">个人中心</el-dropdown-item>
              <el-dropdown-item divided command="loginout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import qqImg from '../assets/img/qq.png'
import logoImg from '../assets/img/logo.svg'
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

.header .logo {
  float: left;
  width: 300px;
  line-height: 70px;
  margin-left: 40px;
  color: #324157;
}
.header-right {
  float: right;
  padding-right: 50px;
}
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