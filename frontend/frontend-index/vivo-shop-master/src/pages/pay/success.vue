<template>
  <div>
    <v-header title="支付" :headerLeftStatus="headerLeftStatus" />
    <div class="success">
      <i class="iconfont icon-chenggong1"></i>
      <h2>购买成功</h2>
      <p>
        已收到您的货款,请留意
        <a href="javascript:void(0)" @click="toOrder()">订单信息</a>
        以及
        <a href="javascript:void(0)" @click="toOrder()">物流信息</a>
        另外祝您生活愉快 感谢您的支持与厚爱
      </p>
    </div>
    <div id="footer">
      <el-button type="success" plain @click="toIndex()">返回首页</el-button>
      <el-button type="primary" plain @click="agianShop()">再来一单</el-button>
    </div>
  </div>
</template>

<script>
import header from "@/components/header/index";
export default {
  data() {
    return {
      headerLeftStatus: true
    };
  },
  components: {
    "v-header": header
  },
  methods: {
    toIndex() {
      this.$router.push("index");
    },
    agianShop() {
      this.$router.back();
    },
    toOrder() {
      this.$router.push({
        name: "order"
      });
    }
  }
};
</script>

<style lang="less" scoped>
.success {
  width: 90%;
  margin: auto;
  text-align: center;

  h2 {
    font-size: 0.8rem;
    margin-top: 0.6rem;
    margin-bottom: 0.1rem;
  }

  i {
    display: block;
    padding-top: 30%;
    font-size: 2.8rem;
    color: #52b838;
  }

  p {
    width: 92%;
    font-size: 0.35rem;
    margin: 0.3rem auto;
    line-height: 0.57rem;

    a {
      color: #1574e3;
    }
  }
}
#footer {
  display: flex;
  justify-content: space-around;
}
</style>
