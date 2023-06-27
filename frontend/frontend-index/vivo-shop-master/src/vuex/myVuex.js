import Vue from "vue";
import Vuex from "vuex";
Vue.use(Vuex);

const state = {
  counter: Date.now() + 1000 * 3,
  halfPrice: false
};

const mutations = {
  /*倒计时变为零*/
  SET_COUNTER(state) {
    state.counter = 0;
  },
  SET_HALFPRICE(state) {
    state.halfPrice = !state.halfPrice;
  }
};

const actions = {
  set_counter({ commit }) {
    commit("SET_COUNTER");
  },
  set_halfPrice({ commit }) {
    commit("SET_HALFPRICE");
  }
};

export default new Vuex.Store({
  state,
  mutations,
  actions
});
