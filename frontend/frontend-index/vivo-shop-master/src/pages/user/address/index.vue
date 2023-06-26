<template>
  <div class="address">
    <v-header title="收货地址信息" :headerLeftStatus="headerLeftStatus" />
    <div class="Address-box">
      <div class="address-one">
        <p class="left">配送地址</p>
        <p class="right" @click="jumpAddress">+添加地址</p>
      </div>
      <div class="pay-address" v-for="(list, index) in address" :key="index">
        <p class="address-box">
          <span class="name">收货人：{{ list.name }}</span>

          <span class="phone">{{ list.tel }}</span>
        </p>
        <p class="address-details">
          收货地址：{{ list.province }}{{ list.city }}{{ list.county
          }}{{ list.addressDetail }}
        </p>
        <div class="address-operation">
          <p class="address-operation-box">
            <el-button
              id="elButton"
              v-if="list.isDefault == false"
              @click="setDefault(list)"
              type="danger"
              plain
            >
              设为默认
            </el-button>
            <b v-else type="primary" plain id="defaultAddress">默认地址</b>
            <i class="iconfont icon-bianji" @click.stop="editAddress(list)"></i>
            <i
              class="iconfont icon-lajitong"
              @click.stop="delAddress(list)"
            ></i>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations, createLogger } from "vuex";
import header from "@/components/header/index";
import requests from "@/api/testBackendInterface";
export default {
  data() {
    return {
      address: [],
      headerLeftStatus: true,
      user: JSON.parse(localStorage.getItem("user"))
    };
  },
  methods: {
    // ...mapMutations({
    //   delAddress: "DEL_ADDRESS",
    //   setDetault: "SET_DEFAULT"
    // }),
    delAddress(list) {
      requests({
        url: "/address/delAddress",
        method: "POST",
        data: {
          user_id: list.user_id,
          id: list.id
        }
      }).then(({ data }) => {
        if (data.data > 0) {
          this.$message({
            showClose: true,
            message: data.msg,
            type: "success",
            duration: 1000
          });
          setTimeout(() => {
            window.location.reload();
          }, 1100);
        } else {
          this.$message({
            showClose: true,
            message: data.msg,
            type: "error",
            duration: 1000
          });
        }
      });
    },
    setDefault(list) {
      requests({
        url: "/address/alterAddress",
        method: "POST",
        data: {
          id: list.id,
          addressDetail: list.addressDetail,
          areaCode: list.areaCode,
          city: list.city,
          country: list.country,
          county: list.county,
          isDefault: !list.isDefault,
          name: list.name,
          postalCode: list.postalCode,
          province: list.province,
          tel: list.tel,
          user_id: this.user.id
        }
      }).then(({ data }) => {
        if (data.data > 0) {
          this.$message({
            showClose: true,
            message: data.msg,
            type: "success",
            duration: 1000
          });
          setTimeout(() => {
            window.location.reload();
          }, 1100);
        } else {
          this.$message({
            showClose: true,
            message: data.msg,
            type: "error",
            duration: 1000
          });
        }
      });
    },
    jumpAddress() {
      this.$router.push({
        path: "add_address"
      });
    },
    editAddress(list) {
      this.$router.push({
        name: "edit_address",
        params: { list }
      });
    }
  },
  mounted() {
    requests({
      url: "/address/queryAddress",
      method: "POST",
      data: { id: JSON.stringify(this.user.id) }
    }).then(({ data }) => {
      this.address = data;
    });
  },
  computed: {
    // ...mapState({
    //   address: state => state.address
    // })
  },
  components: {
    "v-header": header
  }
};
</script>

<style lang="less" scoped>
.address {
  .main-xs {
    width: 100%;
    height: 100%;
    position: fixed;
    left: 0;
    top: 0;
    z-index: 99999;
    background: #f4f4f4;
  }
  .Address-box {
    padding-top: 1.45rem;
    .address-one {
      width: 100%;
      height: 1.6rem;
      line-height: 1.6rem;
      background: #ffffff;
      margin-bottom: 0.2rem;
      border-top: 1px solid #eaeaea;
      .left {
        float: left;
        margin-left: 0.6rem;
        font-size: 0.37rem;
      }
      .right {
        float: right;
        margin-right: 0.6rem;
        font-size: 0.37rem;
        color: #00acff;
      }
    }
    .pay-address {
      width: 100%;
      height: 3.5rem;
      background: #ffffff;
      background-size: 1.6rem;
      margin-top: 0.3rem;
      display: block;
      .address-box {
        width: 87%;
        margin: auto;
        font-size: 0.4rem;
        padding-top: 0.3rem;
        padding-bottom: 0.3rem;
        .phone {
          float: right;
        }
      }
      .address-details {
        width: 87%;
        height: 1rem;
        margin: auto;
        color: #666;
        font-size: 0.38rem;
      }
      .address-operation {
        width: 100%;
        height: 1rem;
        line-height: 1rem;
        margin-top: 0.3rem;
        .address-operation-box {
          width: 100%;
          border-top: 1px solid #eaeaea;
          i {
            float: right;
            font-size: 0.5rem;
            margin-right: 1.2rem;
            color: #a3a3a3;
          }
          #elButton {
            float: right;
            margin-right: 10px;
          }
          #defaultAddress {
            float: right;
            margin-right: 10px;
            font-size: 0.5rem;
          }
        }
      }
    }
  }
}
</style>
