<template>
  <div>
    <v-header title="忘记密码" :headerLeftStatus="headerLeftStatus" />
    <div class="container pt-4">
      <div class="row">
        <van-field
          v-model="user.userName"
          type="text"
          label="用户名"
          placeholder="请输入用户名"
          @blur="isUsername()"
          :error-message="errorMessageUsername"
          ref="userName"
        />
        <van-field
          v-model="user.userPassword"
          type="password"
          label="新密码"
          placeholder="请输入新密码"
          ref="newPassword"
        />
        <van-field
          v-model="confirmPassword"
          type="password"
          label="确认密码"
          placeholder="请确认密码"
          :error-message="errorMessagePassword"
        />
      </div>
    </div>
    <div class="row pt-1">
      <van-button type="primary" block @click="alterPassword">保存</van-button>
    </div>
  </div>
</template>

<script>
import header from "@/components/header/index";
import requests from "@/api/testBackendInterface";
import { Toast, MessageBox } from "mint-ui";
import classifyLeftVue from "../classify/compnent/classify-left.vue";
export default {
  name: "forgetPassword",
  data() {
    return {
      errorMessageUsername: "",
      errorMessagePassword: "",
      headerLeftStatus: true,
      confirmPassword: "",
      user: {
        userName: "",
        userPassword: ""
      }
    };
  },
  components: {
    "v-header": header
  },
  methods: {
    isUsername() {
      requests({
        url: "/user/isUsername",
        method: "POST",
        data: this.user
      }).then(({ data }) => {
        if (!data.data) {
          this.errorMessageUsername = data.msg;
          MessageBox({
            title: "用户名不存在",
            message: "是否前去注册？",
            showCancelButton: false
          }).then(res => {
            if (res == "confirm") {
              this.$router.push("/register");
            }
            if (res == "cancel") {
              this.$router.push("/login");
            }
          });
        } else {
          this.$nextTick(function() {
            this.$refs.newPassword.focus();
          });
        }
      });
    },
    alterPassword() {
      if (this.user.userName == "") {
        Toast("请输入用户名");
        return;
      }
      if (this.user.userPassword == "" || this.confirmPassword == "") {
        Toast("请输入密码");
        return;
      }
      if (this.user.userPassword === this.confirmPassword) {
        requests({
          url: "/user/alterPassword",
          method: "POST",
          data: this.user
        }).then(({ data }) => {
          if (data.data > 0) {
            Toast({
              message: data.msg,
              duration: 900
            });
            setTimeout(() => {
              this.$router.push({ name: "login" });
            }, 1000);
          } else {
            Toast({
              message: data.msg,
              duration: 900
            });
          }
        });
      } else {
        Toast("两次输入不一致");
      }
    }
  }
};
</script>

<style>
.font {
  font-size: 20px;
}
</style>
