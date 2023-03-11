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
          <el-input v-model="form.username" style="width: 320px;height: 40px" placeholder="输入用户名">
            <template #prepend><el-icon><User /></el-icon></template>
          </el-input>
        </el-form-item>
        <el-form-item >
          <el-input type='password' v-model="form.password" style="width: 320px; height: 40px" placeholder="输入密码">
            <template #prepend><el-icon><View /></el-icon></template>
          </el-input>
        </el-form-item>
        <el-form-item v-if="!change">
          <el-input type='password' v-model="form.confirmedPassword" style="width: 320px; height: 40px" placeholder="请确认密码">
            <template #prepend><el-icon><View /></el-icon></template>
          </el-input>
        </el-form-item>
      </el-form>

      <div class="pari-button" v-if="change">
        <a href="#" v-on:click="onChange()">前往注册</a>
        <el-button class="login-button" type="login" round @click="login">登录</el-button>
      </div>
      <div class="pari-button" v-else>
        <a href="#" v-on:click="onChange()">前往登录</a>
        <el-button class="login-button" type="login" round @click="register">注册</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script setup lang="ts">
import {reactive, ref} from "vue";
import {User, View} from "@element-plus/icons-vue";
import loginImg from '../assets/img/login-header.png'
import axios from "axios";
import {ElMessage} from "element-plus";
import {useUserStore} from "@/store/user";
import router from "@/router";

const userStore = useUserStore();

let Visible = ref(true);
let change = ref(true)

const onChange = () => {
  change.value = ! change.value;
}

let form = reactive({
  username:'',
  password:'',
  confirmedPassword:'',
})

const register = () => {
  axios({
    url:"http://localhost:3000/api/register/",
    method:"POST",
    params:{
      username: form.username,
      password: form.password,
      confirmedPassword: form.confirmedPassword,
    }
  }).then((resp) => {
    if(resp.data.info === 'success') {

      ElMessage({
        message:"注册成功",
        type:'success',
      });

      onChange();
    } else {
      ElMessage({
        message: resp.data.info,
        type:'error',
      })
    }
  }).catch((resp) => {
    ElMessage({
      message: "网络错误",
      type:'error',
    })
  })
}
const login = () => {
    axios({
      url:"http://localhost:3000/api/login/",
      method:"POST",
      params:{
        username: form.username,
        password: form.password,
      }
    }).then((resp) => {
      if(resp.data.info === 'success') {
        localStorage.setItem("jwt_token", resp.data.token);
        userStore.$patch({
          token: resp.data.token,
        })
        ElMessage({
          message:"登录成功",
          type:'success',
        });
        router.push("/dashboard");
      } else {
        ElMessage({
          message: resp.data.info,
          type:'error',
        })
      }
    }).catch((resp) => {
      ElMessage({
        message: "网络错误",
        type:'error',
      })
    })
}


</script>

<style scoped>
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
   position: relative;left: 12%;
   background-color: #FF9696 !important;
   color: white !important;
   width: 160px;
 }

 a {
   cursor: pointer;
   color: #6b6a6a;
 }

 a :hover{
   color: #FF9696;
 }
</style>