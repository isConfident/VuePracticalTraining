import Vue from 'vue';
import Vuex from 'vuex'
Vue.use(Vuex);


const state = {
  counter:Date.now() + 1000 * 2 ,
}

const mutations = {
  /*倒计时变为零*/
  SET_COUNTER(state){
    console.log(state)
  },
}

const actions = {
  set_counter(context){
    this.Activity = false;
    console.log(context)
    context.commit("SET_COUNTER")
  },
}


export default new Vuex.Store({
  state,
  mutations,
  actions
})
