<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" />
    <LoginIndex />
  </div>
</template>

<script>
import LoginIndex from "./components/Login.vue";
export default {
  name: "App",
  components: {
    LoginIndex,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
