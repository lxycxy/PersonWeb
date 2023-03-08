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
  background-image: url("../assets/img/background.png");
  background-size: auto;
  width: 100%;
  height: 1000px;

}
</style>