<template>
  <div>DashBoard</div>
</template>

<script>
import axios from "axios";
import LoginDialog from "@/components/LoginDialog.vue";

export default {
  name: "DashBoard",
  components: {LoginDialog},
}
  //
  // axios({
  //     url:"http://localhost:3000/api/login/",
  //     method:"GET",
  //     params:{
  //       username:'lxy',
  //       password:'plxy',
  //     }
  //   }).then((resp) => {
  //     console.log(resp.data);
  //   })

  axios({
    url:"http://localhost:3000/api/getuser/",
    method:"GET",
    headers:{
      Authorization:"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6InBseHkiLCJleHAiOjE2Nzg1ODcyMTIsImlhdCI6MTY3Nzk4MjQxMiwidXNlcm5hbWUiOiJseHkifQ.M1khf-siefYIJZcemYqQ-psve40XqPGRG0gfhVUfv04"
    }
  }).then((resp) => {
    console.log(resp);
  })

</script>

<style scoped>

</style>