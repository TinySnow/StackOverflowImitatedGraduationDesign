import { createRouter, createWebHistory } from 'vue-router'
import space from '@/views/space.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/space',
      name: 'space',
      component: space
    },
    {
      path: '/home',
      name: 'home',
      component: () => import('@/views/home.vue')
    }
  ]
})

export default router
