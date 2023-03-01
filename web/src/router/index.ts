import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../view/Home.vue';
const routes:RouteRecordRaw[]  = [
    {
        //路由初始指向
        path: '/',
        redirect:'/dashboard'
    },{
        path:'/',
        name:'Home',
        component:Home,
        children:[
            {
                path:"/dashboard",
                name:'dashboard',
                component: () => import("../view/DashBoard.vue")
            }
        ]
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
