import { createRouter, createWebHistory } from "vue-router";
import space from "@/views/index/space.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "root",
      redirect: "/space",
    },
    {
      path: "/space",
      name: "主页",
      component: space,
    },
    {
      path: "/home",
      name: "个人中心",
      component: () => import("@/views/index/home.vue"),
    },
    {
      path: "/login",
      name: "登录",
      component: () => import("@/views/login/login.vue"),
    },
    {
      path: "/register",
      name: "注册",
      component: () => import("@/views/login/register.vue"),
    },
    {
      path: "/editor",
      name: "编辑器",
      component: () => import("@/views/test/md-editor.vue"),
    },
    {
      path: "/question/:id",
      name: "问题详情页",
      component: () => import("@/views/detail/sigle-question.vue"),
    },
    {
      path: "/search",
      name: "搜索页面",
      component: () => import("@/views/index/search.vue"),
    },
    {
      path: "/404",
      name: "页面不存在",
      component: () => import("@/views/404.vue"),
    },    
    {
      path: "/:pathMatch(.*)*",
      redirect: "/404"
    }
  ],
});

export default router;
