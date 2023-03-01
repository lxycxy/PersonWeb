import { createApp } from 'vue'
import App from './App.vue'
import router from "./router";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import './assets/css/icon.css'
import {createPinia} from "pinia";
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
const app = createApp(App);
const pinia = createPinia();

app.use(router).use(ElementPlus).use(pinia).mount('#app')

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}