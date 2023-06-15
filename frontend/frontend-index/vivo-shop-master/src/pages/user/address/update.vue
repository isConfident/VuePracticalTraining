<template>
  <div class="page">
    <v-header title="修改收货地址信息" :headerLeftStatus="headerLeftStatus" />
    <van-address-edit
      :area-list="addressDataList"
      show-search-result
      :area-columns-placeholder="['请选择', '请选择', '请选择']"
      v-model="addressData"
      @save="saveAddress"
    />
  </div>
</template>
<script>
import { mapState, mapMutations } from "vuex";
import { addressDataList } from "@/assets/address";
import header from "@/components/header/index";
export default {
  name: "edit_address",
  data() {
    return {
      addressDataList,
      searchResult: [],
      addressData: {},
      headerLeftStatus: true
    };
  },
  methods: {
    ...mapMutations({
      saveAddressMutation: "EDIT_ADDRESS"
    }),
    saveAddress() {
      this.saveAddressMutation(this.addressData);
      this.$router.push("/address");
    }
  },
  mounted() {
    let index = this.$route.params.index;
    this.addressData = { ...this.address[index] };
  },
  computed: {
    ...mapState({
      'address': state => state.address
    })
    },

  components: {
    "v-header": header
  }
};
</script>
<style lang="less" scoped>
.page {
  .van-address-edit {
    padding-top: 1.6rem;
  }
  .address {
    padding-top: 1.45rem;
    .address-box {
      width: 100%;
      height: 1.5rem;
      line-height: 1.5rem;
      background: #fff;
      display: flex;
      label {
        width: 30%;
        height: 100%;
        padding-left: 0.58rem;
        font-size: 0.4rem;
        display: block;
        float: left;
      }
      input {
        width: 70%;
        height: 100%;
        font-size: 0.4rem;
      }
      .mint-switch {
        display: flex;
        align-items: center;
      }
    }
  }
  .footer {
    position: fixed;
    bottom: 0;
    width: 100%;
    height: 1.3rem;
    border-top: 1px solid #e0e0e0;
    background: #ffffff;
    a {
      float: none;
      display: block;
      margin: 0.18rem auto;
      text-align: center;
      width: 95%;
      height: 0.9rem;
      line-height: 0.9rem;
      border-radius: 20px;
      font-size: 0.28rem;
      color: #fff;
      background-color: #00acff;
    }
  }
  /deep/
  .van-field__error-message {
    color: #00acff;
  }
  /deep/
  .van-address-edit {
    width: 100%;
    padding: 0;
    padding-top: 1.7rem;
    .van-address-edit__fields {
      border-radius: 0px;
    }
    .van-address-edit__buttons {
      position: fixed;
      bottom: 0;
      width: 100%;
      height: auto;
      border-top: 1px solid #e0e0e0;
      background: #ffffff;
      padding: 0px;
      .van-button--danger {
        background: #00acff;
        border: aliceblue;
        width: 95%;
        margin: auto;
        margin-top: 0.2rem;
        margin-bottom: 0.2rem;
        height: 1rem;
      }
    }
  }
}
</style>

