<template>
  <div class="address">
<<<<<<< Updated upstream
    <v-header title="收货地址信息" :headerLeftStatus="headerLeftStatus"/>
=======
    <v-header title="收货地址" :headerLeftStatus="headerLeftStatus" />
>>>>>>> Stashed changes
    <div class="Address-box">
      <div class="address-one">
        <p class="left">配送地址</p>
        <p class="right" @click="jumpAddress">+添加地址</p>
      </div>
<<<<<<< Updated upstream
      <div class="pay-address"
           v-for="(list, index) in address"
           :key="index"
      >
=======
      <div class="pay-address" v-for="(list, index) in address" :key="index">
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
            <i
              class="iconfont icon-bianji"
              @click.stop="editAddress(index)"
            ></i>
=======
            <el-button
              id="elButton"
              v-if="!list.default"
              @click="setDetault(index)"
              type="danger"
              plain
            >
              设为默认
            </el-button>
            <b v-else type="primary" plain id="defaultAddress">默认地址</b>
            <i class="iconfont icon-bianji"></i>
>>>>>>> Stashed changes
            <i
              class="iconfont icon-lajitong"
              @click.stop="delAddress(index)"
            ></i>
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import header from "@/components/header/index";
export default {
  data() {
    return {
      headerLeftStatus: true
    };
  },
  methods: {
    ...mapMutations({
<<<<<<< Updated upstream
      delAddress: 'DEL_ADDRESS',
      setDetault: 'SET_DEFAULT',
=======
      delAddress: "DEL_ADDRESS",
      setDetault: "SET_DEFAULT"
>>>>>>> Stashed changes
    }),
    jumpAddress() {
      this.$router.push({
        path: "add_address"
      });
<<<<<<< Updated upstream
    },
    editAddress(index) {
      this.$router.push({
        name: "edit_address",
        params: { index }
      });
=======
>>>>>>> Stashed changes
    }
  },
  computed: {
    ...mapState({
      address: state => state.address
    })
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
