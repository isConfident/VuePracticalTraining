import {
  ADD_CARTS,
  DEL_CARTS,
  ADDCART_VALUE,
  REDUCECART_VAVLUE,
  SELECT_CARTS_LIST,
  ADD_COLLECTION,
  DEL_COLLECTION,
  SELECT_CARTS_LIST_ALL,
  SETTLEMENT
} from "../mutations-type";

import router from "../../router";
import { Toast, MessageBox } from "mint-ui";

const state = {
  carts: localStorage.getItem("carts")
    ? JSON.parse(localStorage.getItem("carts"))
    : [], // 购物车列表
  collections: localStorage.getItem("collections")
    ? JSON.parse(localStorage.getItem("collections"))
    : [], // 收藏列表
  selected: []
};

const mutations = {
  // 加入购物车
  [ADD_CARTS](state, data) {
    var cartsId = state.carts.find(list => {
      return data.id == list.id;
    });
    if (!localStorage.getItem("user")) {
      MessageBox({
        title: "检测到你还未授权登陆",
        message: "是否前去登陆",
        showCancelButton: true
      }).then(res => {
        if (res === "confirm") {
          router.push("/login");
        }
      });
      return false;
    }
    if (cartsId) {
      MessageBox({
        title: "提示",
        message: "是否继续添加" + data.name + "?",
        showCancelButton: true
      }).then(res => {
        if (res === "confirm") {
          state.carts.forEach(list => {
            if (list.id === data.id) {
              list.value++;
            }
          });
          localStorage.setItem("carts", JSON.stringify(state.carts));
          Toast({
            message: "添加成功",
            duration: 1500
          });
        }
      });
    } else {
      Toast({
        message: "加入购物车成功！",
        duration: 1500
      });
      data["select"] = false;
      state.carts.push(data);
      localStorage.setItem("carts", JSON.stringify(state.carts));
    }
  },

  // 选择购物车列表（全部）
  [SELECT_CARTS_LIST_ALL](state) {
    if (state.carts.length === 0) {
      Toast({
        message: "当前购物车是空的",
        duration: 1500
      });
      return false;
    }
    state.carts.forEach(list => {
      list.select = !list.select;
    });
  },

  /*新增*/
  /*结算勾选的商品*/

  // 移出购物车
  [DEL_CARTS](state, index) {
    MessageBox({
      title: "提示",
      message: "是否删除" + state.carts[index].name + "?",
      showCancelButton: true
    }).then(res => {
      if (res == "confirm") {
        state.carts.splice(index, 1);
        localStorage.setItem("carts", JSON.stringify(state.carts));
        Toast({
          message: "删除成功",
          duration: 1500
        });
      }
    });
  },

  //结算操作
  [SETTLEMENT](state) {
    if (state.carts.length == 0) {
      Toast({
        message: "当前购物车是空的",
        duration: 1500
      });
      return false;
    }
    var settlement = state.carts.filter(list => {
      return list.select === true;
    });
    if (settlement.length === 0) {
      Toast({
        message: "请选择要结算的商品",
        duration: 1500
      });
      return false;
    }
    router.push({
      path: "/pay",
      query: {
        carts: JSON.stringify(settlement)
      }
    });
  },

  // 商品数量操作（增加）
  [ADDCART_VALUE](state, index) {
    state.carts[index].value++;
    localStorage.setItem("carts", JSON.stringify(state.carts));
  },

  // 商品数量操作（减少）
  [REDUCECART_VAVLUE](state, index) {
    if (state.carts[index].value === 1) {
      MessageBox({
        title: "提示",
        message: "是否删除" + state.carts[index].name + "?",
        showCancelButton: true
      }).then(res => {
        if (res === "confirm") {
          state.carts.splice(index, 1);
          localStorage.setItem("carts", JSON.stringify(state.carts));
          Toast({
            message: "删除成功",
            duration: 1500
          });
        }
      });
    } else {
      state.carts[index].value--;
      localStorage.setItem("carts", JSON.stringify(state.carts));
    }
  },
  // 购物车单选
  [SELECT_CARTS_LIST](state, index) {
    state.carts[index].select = !state.carts[index].select;
    state.selected = state.carts.filter(list => {
      return list.select;
    });
  },

  // 商品收藏
  [ADD_COLLECTION](state, data) {
    var collectionsId = state.collections.find(list => {
      return data.id === list.id;
    });
    if (collectionsId) {
      state.collections.splice(collectionsId, 1);
      localStorage.setItem("collections", JSON.stringify(state.collections));
      Toast({
        message: "取消收藏成功！",
        duration: 1500
      });
      return false;
    }
    Toast({
      message: "收藏成功！",
      duration: 1500
    });
    data.select = false;
    state.collections.push(data);
    localStorage.setItem("collections", JSON.stringify(state.collections));
    document.getElementById("collection");
    if (!localStorage.getItem("user")) {
      MessageBox({
        title: "检测到你还未授权登陆",
        message: "是否前去登陆",
        showCancelButton: true
      }).then(res => {
        if (res === "confirm") {
          router.push("/login");
        }
      });
      return false;
    }
  },
  // 移出收藏夹
  [DEL_COLLECTION](state, index) {
    MessageBox({
      title: "提示",
      message: "是否取消" + state.collections[index].name + "的收藏?",
      showCancelButton: true
    }).then(res => {
      if (res === "confirm") {
        state.collections.splice(index, 1);
        localStorage.setItem("collections", JSON.stringify(state.collections));
        Toast({
          message: "取消成功",
          duration: 1500
        });
      }
    });
  }
};

export default {
  namespaced: true, // 开启命名
  state,
  mutations
};
