<template>
  <div class="register">
    <div class="register-1">
      <img
        src="https://accountstatic.vivo.com.cn/accountstatic.vivo.com.cn/static/img/logo.3c33210.png.webp"
        alt
      />
      <p>账号登陆</p>
    </div>
    <div class="register-2">
      <label for>
        <span>账号</span>
        <input
          type="text"
          v-model="user.userName"
          placeholder="请输入账号/用户名"
        />
      </label>

      <label for>
        <span>密码</span>
        <input
          type="password"
          v-model="user.userPassword"
          placeholder="请输入密码"
        />
      </label>
    </div>
    <div class="row">
      <div class="col-6 p-2">
        <button
          @click="login"
          class="btn btn-primary w-100"
          style="height:inherit"
        >
          登录
        </button>
      </div>
      <div class="col-6 p-2">
        <button
          @click="jumpRegister"
          class="btn btn-primary w-100"
          style="height:inherit"
        >
          注册
        </button>
      </div>
    </div>
    <div class="ethnologist">
      <a href="javascript:void(0)" @click="toForgetPassword()">忘记密码</a>
    </div>
    <div class="ethnologist">
      <router-link to="/index">暂不登陆</router-link>
    </div>
  </div>
</template>

<script>
import { Toast } from "mint-ui";
import requests from "@/api/testBackendInterface";
export default {
  data() {
    return {
      user: {
        userName: "",
        userPassword: ""
      },
      result: {}
    };
  },
  mounted() {},
  methods: {
    toForgetPassword() {
      this.$router.push({
        path: "/forgetPassword"
      });
    },
    login() {
      requests({
        url: "/user/login",
        method: "POST",
        data: JSON.stringify(this.user)
      }).then(({ data }) => {
        if (data.data) {
          this.$message({
            showClose: true,
            message: data.msg,
            type: "success",
            duration: 1000
          });

          localStorage.setItem("user", JSON.stringify(data.data));
          this.$router.push({
            name: "main"
          });
        } else {
          this.$message({
            showClose: true,
            message: data.msg,
            type: "error",
            duration: 1000
          });
        }
      });

      // if (!JSON.parse(localStorage.getItem("user"))) {
      //   Toast({
      //     message: "用户不存在",
      //     duration: 950
      //   });
      //   return false;
      // }

      // if (this.user.name == "") {
      //   Toast({
      //     message: "请输入用户名",
      //     duration: 950
      //   });
      //   return false;
      // }

      // if (this.user.password == "") {
      //   Toast({
      //     message: "请输入密码",
      //     duration: 950
      //   });
      //   return false;
      // }

      // if (this.user.name != JSON.parse(localStorage.getItem("user")).name) {
      //   Toast({
      //     message: "用户名不正确",
      //     duration: 950
      //   });
      //   return false;
      // }

      // if (
      //   this.user.password != JSON.parse(localStorage.getItem("user")).password
      // ) {
      //   Toast({
      //     message: "密码不正确",
      //     duration: 950
      //   });
      //   return false;
      // }
      // Toast({
      //   message: "登陆成功",
      //   duration: 950
      // });
      // this.$router.push("/main");
    },

    jumpRegister() {
      this.$router.push("/register");
    }
  }
};
</script>

<style>
.ethnologist {
  margin-top: 0.6rem;
  margin-bottom: 0.6rem;
  text-align: center;
  font-size: 0.25rem;
}
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
  /* display: flex;
  flex-direction: column; */
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
.btn {
  font-size: 20px;
  border-radius: 50px;
  background-color: #46a1fa;
  background-image: linear-gradient(90deg, #418eff, #4566ff);
}
</style>
