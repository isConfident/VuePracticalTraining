<template>
  <div>
    <v-header title="修改个人信息" :headerLeftStatus="headerLeftStatus" />
    <div class="container pt-1">
      <div class="card" style="width: 100%;">
        <img src="./resources/1.jpg" class="card-img-top" alt="" />
        <div class="card-body">
          <span class="card-title">基本信息</span>
          <div class="row">
            <div class="col">
              <div class="form-group">
                <label for="username"
                  ><span style="font-size:10px">用户名:</span></label
                >
                <input
                  type="text"
                  name="username"
                  id="username"
                  class="form-controll border"
                  v-model="user.userName"
                />
              </div>
            </div>
          </div>
          <el-button type="primary" @click="alterUserInfo()">保存</el-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import header from "@/components/header/index";
import requests from "@/api/testBackendInterface";
export default {
  name: "alterUser",
  data() {
    return {
      user: JSON.parse(localStorage.getItem("user")),
      headerLeftStatus: true
    };
  },
  methods: {
    alterUserInfo() {
      requests({
        url: "/user/alterUser",
        method: "POST",
        data: this.user
      }).then(({ data }) => {
        if (data > 0) {
          this.$message({
            showClose: true,
            message: "保存成功",
            type: "success",
            duration: 1000
          });
          localStorage.setItem("user", JSON.stringify(this.user));
        } else {
          this.$message({
            showClose: true,
            message: "该用户名已被其他人使用了",
            type: "error",
            duration: 1000
          });
        }
      });
    }
  },
  components: {
    "v-header": header
  }
};
</script>

<style></style>
