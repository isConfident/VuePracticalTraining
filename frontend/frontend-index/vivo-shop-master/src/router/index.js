import Vue from "vue";
import Router from "vue-router";
import index from "@/pages/index/index";
import detail from "@/pages/detail/index";
import news from "@/pages/news/index";
import newsDetail from "@/pages/news/detail";
import cart from "@/pages/user/cart/index";
import address from "@/pages/user/address/index";
import add_address from "@/pages/user/address/add";
import edit_address from "@/pages/user/address/update";
import success from "@/pages/pay/success";
import parts from "@/pages/shops/parts";
import phone from "@/pages/shops/phone";
import collection from "@/pages/user/collections/index";
import order from "@/pages/user/order/index";
import orderDetail from "@/pages/user/order/detail";
import pay from "@/pages/pay/pay";
import select_address from "@/pages/pay/address";
import login from "@/pages/user/login";
import register from "@/pages/user/register";
import main from "@/pages/user/main";
import alterUser from "@/pages/user/alterUser";
import halfPrice from "@/pages/shops/halfPrice";
import forgetPassword from "@/pages/user/forgetPassword";
Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/forgetPassword",
      component: () => import("@/pages/user/forgetPassword")
    },
    {
      path: "/",
      name: "index",
      component: index
    },
    {
      path: "/index",
      name: "index",
      component: index
    },
    {
      path: "/detail",
      name: "detail",
      component: detail,
      props: true
    },
    {
      path: "/news",
      name: "news",
      component: news
    },
    {
      path: "/newsDetail",
      name: "newsDetail",
      component: newsDetail
    },
    {
      path: "/cart",
      name: "cart",
      component: cart,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/address",
      name: "address",
      component: address,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/add_address",
      name: "add_address",
      component: add_address
    },
    {
      path: "edit_address",
      name: "edit_address",
      component: edit_address
    },
    {
      path: "/success",
      name: "success",
      component: success
    },
    {
      path: "/login",
      name: "login",
      component: login
    },
    {
      path: "/register",
      name: "register",
      component: register
    },
    {
      path: "/main",
      name: "main",
      component: main,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/collection",
      name: "collection",
      component: collection
    },
    {
      path: "/order",
      name: "order",
      component: order,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/orderDetail",
      name: "orderDetail",
      component: orderDetail,
      meta: {
        requireAuth: true
      }
    },
    {
      path: "/parts",
      name: "parts",
      component: parts
    },
    {
      path: "/halfPrice",
      name: "halfPrice",
      component: halfPrice
    },
    {
      path: "/phone",
      name: "phone",
      component: phone
    },
    {
      path: "/pay",
      name: "pay",
      component: pay,
      meta: {
        requireAuth: true
      },
      props: true
    },
    {
      path: "/select_address",
      name: "select_address",
      component: select_address
    },
    {
      path: "/alterUser",
      name: "alterUser",
      component: alterUser
    }
  ]
});
