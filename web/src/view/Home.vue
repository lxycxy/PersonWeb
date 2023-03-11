<template>
  <SideMenu />

<!--  内容页使用动画并缓存每个内容页-->
  <div class="content-box">
      <router-view v-slot="{Component}">
      <transition name="move" mode="out-in">
        <keep-alive :include="tags.listName">
          <component :is="Component"></component>
        </keep-alive>
      </transition>
    </router-view>
  </div>
</template>

<script setup lang="ts">
import {useTagsStore} from "@/store/tags";
import SideMenu from "@/components/SideMenu.vue";

const tags = useTagsStore();
</script>

<style scoped>

</style>