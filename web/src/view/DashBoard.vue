<template>
  <div>DashBoard</div>
</template>

<script setup lang="ts">
import {useUserStore} from "@/store/user";
import axios from "axios";
import router from "@/router";

const userStore = useUserStore();
const getInfo = () => {
  axios({
    url:"http://localhost:3000/api/getinfo/",
    method:"POST",
    headers:{
      Authorization: localStorage.getItem("jwt_token")
    },
    params:{
      token: localStorage.getItem("jwt_token")
    }
  }).then((resp) => {
    userStore.$patch({
      id: resp.data.id,
      username: resp.data.username,
      photo: resp.data.photo,
    })
  }).catch((resp) => {
    router.push('/login');
  })
}
getInfo()

</script>

<style scoped>

</style>