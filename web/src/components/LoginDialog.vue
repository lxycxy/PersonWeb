<template>
  <div class="login">
    <el-dialog
        v-model="Visible"
        width="400"
        :close-on-click-modal="false"
        :show-close="false"
        style="border-radius: 20px"
    >
      <div class="login-img">
        <el-image :src="loginImg" style="width: 65px;height: 65px;position: absolute;left: 40%;"></el-image>
      </div>

      <el-form
          label-position='right'
          label-width="20px"

      >
        <el-form-item >
          <el-input v-model="form.username" style="width: 320px" placeholder="输入用户名">
            <template #prepend><el-icon><User /></el-icon></template>
          </el-input>
        </el-form-item>
        <el-form-item >
          <el-input type='password' v-model="form.password" style="width: 320px" placeholder="输入密码">
            <template #prepend><el-icon><View /></el-icon></template>
          </el-input>
        </el-form-item>
      </el-form>
      <div class="pari-button">
        <el-row>
          <el-col :offset="2" :span="6">
            <el-button class="login-button" type="info" round>取消</el-button>
          </el-col>
          <el-col :offset="4" :span="6">
            <el-button class="login-button" type="login" round>登录</el-button>
          </el-col>
        </el-row>
      </div>

    </el-dialog>
  </div>

</template>

<script setup lang="ts">
import {reactive, ref} from "vue";
import {User, View} from "@element-plus/icons-vue";
import loginImg from '../assets/img/login-header.png'
let Visible = ref(true);

let form = reactive({
  username:'',
  password:'',
})
</script>

<style>
.box-card {
  margin: 0;
  padding: 0;
}
.login-button {
  width: 130px;
}

.login-img {
  margin-bottom: 30px;
  padding: 0;

  width: 65px;
  height: 65px;
}
 .pari-button {
   margin-top: 30px;
 }

 .el-button--login {
   background-color: #FF9696 !important;
   color: white !important;
 }
</style>