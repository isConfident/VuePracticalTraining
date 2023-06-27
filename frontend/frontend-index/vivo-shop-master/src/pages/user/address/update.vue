<template>
  <div class="page">
    <v-header title="修改收货地址信息" :headerLeftStatus="headerLeftStatus" />
    <van-address-edit
      :area-list="addressDataList"
      show-search-result
      :area-columns-placeholder="['请选择', '请选择', '请选择']"
      @save="saveAddress"
      :address-info="dataInfo"
    />
  </div>
</template>
<script>
import { addressDataList } from "@/assets/address";
import header from "@/components/header/index";
import requests from "@/api/testBackendInterface";
export default {
  name: "edit_address",
  data() {
    return {
      user: JSON.parse(localStorage.getItem("user")),
      dataInfo: {},
      addressDataList,
      searchResult: [],
      addressData: {},
      headerLeftStatus: true
    };
  },
  methods: {
    saveAddress(list) {
      console.log(list);
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
          isDefault: list.isDefault,
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
          this.$router.back();
        } else {
          this.$message({
            showClose: true,
            message: data.msg,
            type: "error",
            duration: 1000
          });
        }
      });
    }
  },
  mounted() {
    this.dataInfo = this.$route.params.list;
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
  /deep/ .van-field__error-message {
    color: #00acff;
  }
  /deep/ .van-address-edit {
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
