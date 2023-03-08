// TODO：此处可能需要加一个 store 用于缓存排行榜的 lists 变量，否则请求太频繁

import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useCounterStore = defineStore("counter", () => {
  const count = ref(0);
  const doubleCount = computed(() => count.value * 2);
  function increment() {
    count.value++;
  }
  return { count, doubleCount, increment };
});

export const useLoginedStore = defineStore("logined", () => {
  const logined = ref(false);
  function login() {
    logined.value = true;
  }
  function loginout() {
    logined.value = false;
  }
  return { logined, login, loginout };
});

export const useTokenStore = defineStore("token", () => {
  const token = ref("");
  function login(jwt: string) {
    token.value = jwt;
  }
  function loginout() {
    token.value = "";
  }
  return { token, login, loginout };
});
