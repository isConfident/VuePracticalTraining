import Vue from "vue";
import App from "./App";
import router from "./router";
import store from "./vuex/myVuex";
import VueLazyLoad from "vue-lazyload";
import axios from "axios";
import Vant from "vant";
import "vant/lib/index.css";
Vue.use(Vant);
Vue.prototype.$axios = axios;

import "element-ui/lib/theme-chalk/index.css";

import ElementUI from "element-ui";
Vue.use(ElementUI);
Vue.use(VueLazyLoad, {
  loading: require("../static/img/qqq.png")
});

//引入UI组件
import MintUI from "mint-ui";
import "mint-ui/lib/style.css";
Vue.use(MintUI);

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (!localStorage.getItem("user")) {
      next({ path: "/login" });
    }
  }
  next();
});

/* eslint-disable no-new */
new Vue({
  el: "#app",
  router,
  store,
  template: "<App/>",
  components: { App }
});
