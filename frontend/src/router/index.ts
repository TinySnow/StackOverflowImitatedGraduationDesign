import { createRouter, createWebHistory } from "vue-router";
import space from "@/views/space.vue";

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
      component: () => import("@/views/home.vue"),
    },
    {
      path: "/login",
      name: "登录",
      component: () => import("@/views/login.vue"),
    },
    {
      path: "/register",
      name: "注册",
      component: () => import("@/views/register.vue"),
    },
    {
      path: "/editor",
      name: "编辑器",
      component: () => import("@/views/md-editor.vue"),
    },
    {
      path: "/question/:id",
      name: "问题详情页",
      component: () => import("@/views/sigle-question.vue"),
    },
  ],
});

export default router;
