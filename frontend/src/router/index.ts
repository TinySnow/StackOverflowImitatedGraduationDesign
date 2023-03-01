import { createRouter, createWebHistory } from 'vue-router'
import space from '@/views/space.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'root',
      redirect: '/space'
    },
    {
      path: '/space',
      name: 'space',
      component: space
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('@/views/home.vue')
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login.vue')
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/views/register.vue')
    },
    {
      path: '/editor',
      name: 'editor',
      component: () => import('@/views/md-editor.vue')
    }
  ]
})

export default router
