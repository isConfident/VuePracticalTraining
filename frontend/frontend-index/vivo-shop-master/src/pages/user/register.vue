<template>
  <div class="register">
    <div class="register-1">
      <img
        src="https://accountstatic.vivo.com.cn/accountstatic.vivo.com.cn/static/img/logo.3c33210.png.webp"
        alt
      />
      <p>账号注册</p>
    </div>
    <div class="register-2">
      <label for>
        <span>账号</span>
        <input
          type="text"
          v-model="user.name"
          placeholder="请输入账号/用户名"
        />
      </label>

      <label for>
        <span>密码</span>
        <input
          type="password"
          v-model="user.password"
          placeholder="请输入密码"
        />
      </label>
    </div>
    <div class="col-12 p-2">
      <button class="btn btn-primary w-100" @click="regusterUser">
        注册
      </button>
    </div>
    <div class="BackLogin">
      <router-link to="/login">已有账号，返回登录</router-link>
    </div>
  </div>
</template>

<script>
import { Toast } from "mint-ui";
import requests from "@/api/testBackendInterface";
import axios from "axios";
export default {
  data() {
    return {
      user: {
        name: "",
        password: ""
      }
    };
  },
  methods: {
    regusterUser() {
      if (this.user.name == "") {
        Toast({
          message: "用户名不能为空",
          duration: 950
        });
        return false;
      }

      if (this.user.password == "") {
        Toast({
          message: "密码不能为空",
          duration: 950
        });
        return false;
      }

      requests({
        url: "/user/register",
        method: "POST",
        data: {
          userName: this.user.name,
          userPassword: this.user.password
        }
      }).then(({ data }) => {
        if (data.data > 0) {
          Toast({
            message: data.msg,
            duration: 950
          });

          setTimeout(() => {
            window.location.reload();
          }, 1000);
          this.$router.push("/login");
        } else {
          Toast({
            message: data.msg,
            duration: 950
          });
        }
      });
    }
  }
};
</script>

<style>
.register {
  width: 100%;
  height: 100%;
  position: fixed;
  background: white;
  left: 0;
  top: 0;
}
.register-1 {
  margin-top: 2rem;
}
.register-1 img {
  width: 3rem;
  display: block;
  margin: 0.6rem auto;
}
.register-1 p {
  color: black;
  text-align: center;
  font-size: 0.5rem;
}

.register-2 {
  margin-top: 0.6rem;
  margin-bottom: 0.6rem;
}

.register-2 label {
  width: 90%;
  margin: auto;
  height: 1.5rem;
  border-bottom: 0.03rem solid #f2f2f2;
  display: flex;
}

.register-2 label span {
  width: 20%;
  font-size: 0.5rem;
  line-height: 1.5rem;
  display: block;
  float: left;
}

.register-2 label input {
  width: 80%;
  font-size: 0.4rem;
  padding-left: 0.3rem;
}

.register-3 {
  display: flex;
}
.BackLogin {
  width: 9rem;
  height: 1.1rem;
  margin: 0 auto;
  margin-bottom: 0.3rem;
  text-align: center;
  line-height: 1.1rem;
  font-size: 0.25rem;
  color: #fff;
  border-radius: 0.6rem;
}

.btn {
  font-size: 20px;
  border-radius: 50px;
  background-color: #46a1fa;
  background-image: linear-gradient(90deg, #418eff, #4566ff);
}
</style>
