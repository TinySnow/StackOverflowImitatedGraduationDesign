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
