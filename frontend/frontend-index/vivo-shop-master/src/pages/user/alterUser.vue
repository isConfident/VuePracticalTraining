<template>
  <div>
    <v-header title="修改个人信息" :headerLeftStatus="headerLeftStatus" />
    <div class="container pt-1">
      <div class="card" style="width: 100%;">
        <img src="./resources/1.jpg" class="card-img-top" alt="" />
        <div class="card-body">
          <span class="card-title">基本信息</span>
          <div class="row mt-1">
            <div class="col-12">
              <span class="font">用户名:</span>
              <input
                type="text"
                v-model="user.userName"
                class="form-controll border text-black-50"
                placeholder="请输入用户名"
              />
            </div>
          </div>
          <div class="row mt-1">
            <div class="col-12">
              <span class="font">出生日期:</span><br />
              <el-date-picker
                v-model="user.birthday"
                align="right"
                type="date"
                placeholder="选择日期"
                :picker-options="pickerOptions"
                value-format="yyyy-MM-dd"
              >
              </el-date-picker>
            </div>
          </div>
          <div class="row mt-1">
            <div class="col-12">
              <span class="font">真实年龄:</span>
              <input
                type="number"
                v-model="user.age"
                class="form-controll border text-black-50"
                placeholder="请输入年龄"
              />
            </div>
          </div>

          <div class="row justify-content-right mt-1">
            <div class="col-12">
              <el-button type="primary" @click="alterUserInfo()"
                >保存</el-button
              >
            </div>
          </div>
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
      headerLeftStatus: true,
      pickerOptions: {
        disabledDate(time) {
          return time.getTime() > Date.now();
        },
        shortcuts: [
          {
            text: "今天",
            onClick(picker) {
              picker.$emit("pick", new Date());
            }
          },
          {
            text: "昨天",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24);
              picker.$emit("pick", date);
            }
          },
          {
            text: "一周前",
            onClick(picker) {
              const date = new Date();
              date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
              picker.$emit("pick", date);
            }
          }
        ]
      }
    };
  },
  watch: {
    "user.birthday": function(newValue, oldValue) {
      this.user.age = new Date().getFullYear() - parseInt(newValue.slice(0, 4));
    }
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

<style>
.font {
  font-size: 16px;
  color: gray;
}
</style>
