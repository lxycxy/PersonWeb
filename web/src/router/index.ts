import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
const routes:RouteRecordRaw[]  = [
    {
        //路由初始指向
        path: '/',
        redirect:'/dashboard'
    },{
        path:'/',
        name:'Home',
        meta: {
            author:true,
        },
        component:() => import("../view/Home.vue"),
        children:[
            {
                path:"/dashboard",
                name:'dashboard',
                meta: {
                    author:true,
                },
                component: () => import("../view/DashBoard.vue"),
            }
        ]
    },{
        path:'/login',
        name:'login',
        meta: {
            author:false,
        },
        component: () => import("../view/Login.vue")
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})
/**
 * 非登录状态 限定路由
 */
router.beforeEach((to, from, next) => {

    if(to.meta.author && ! localStorage.getItem("jwt_token")) {
        next({name:'login'});
    } else {
        next();
    }
})
export default router
