<template>
  <div class="back">
    <LoginDialog></LoginDialog>
  </div>

</template>

<script setup lang="ts">
import LoginDialog from "@/components/LoginDialog.vue";

</script>

<style scoped>
.back {
  background-image: url("../assets/img/theme.png");
  background-size: 100%;
  width: 100%;
  height: 100%;

}
</style>