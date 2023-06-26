<template>
  <div class="pay">
    <v-header title="商品详情" :headerLeftStatus="headerLeftStatus" />
    <div class="pay-address">
      <div v-if="!address" class="saveAddress" @click="saveAddress()">
        <p>添加收货地址</p>
        <i class="iconfont icon-youjiantou"></i>
        <div class="address-else">
          <el-button type="primary" plain @click="chooseElseAddress()"
            >选择其他收货地址</el-button
          >
        </div>
      </div>
      <div v-else>
        <p class="address-box">
          <span class="name">收货人：{{ address.name }}</span>
          <span class="phone">{{ address.tel }}</span>
        </p>
        <p class="address-details">
          收货地址：{{ address.province }}{{ address.city }}{{ address.county
          }}{{ address.addressDetail }}
        </p>
        <div class="address-else">
          <el-button type="primary" plain @click="chooseElseAddress()"
            >选择其他收货地址</el-button
          >
        </div>
      </div>
    </div>
    <div class="pay-shop" v-for="(list, index) in pay" :key="index">
      <div class="pay-shop-list">
        <p class="pay-shop-1">商品清单</p>
        <div
          v-for="(cart, index) in carts"
          :key="index"
          style="height: 3.5rem;"
        >
          <p class="pay-shop-2">
            <img :src="cart.img_url" />
          </p>
          <p class="pay-shop-2-box">
            <span class="name"
              >{{ cart.name }}
              <p>× {{ cart.value }}</p></span
            >
            <span class="price">¥{{ cart.price }}</span>
          </p>
        </div>
      </div>
      <div class="pay-shop-invoice">
        <p class="pay-invoice-1">发票信息</p>
        <div class="pay-invoice-2">
          <div class="pay-invoice-2-2">
            <div>
              <p>*请输入发票抬头:</p>
              <input
                type="text"
                id="input"
                v-model="invoice"
                placeholder="请输入发票信息"
              />
            </div>
          </div>
        </div>
      </div>
      <div class="pay-shop-fs">
        <div class="pay-fs-1">支付方式</div>
        <div class="pay-fs-2">
          <div class="pay-fs-2-1">
            <div
              v-for="(list, index) in paymentType"
              :class="paymentTypeIndex == index ? 'active' : ''"
              @click="selectPaymentType(index)"
              :key="index"
            >
              {{ list }}
            </div>
          </div>
          <div class="pay-fs-2-2">
            <div v-show="paymentTypeIndex === 0" class="pay-fs-2-2-1">
              支持支付宝支付、微信支付、银行卡支付、财付通等
            </div>
            <div v-show="paymentTypeIndex === 1" class="pay-fs-2-2-2">
              花呗分期是花呗联合天猫淘宝推出的，面向互联网的赊购服务，通过支付宝轻松还款，0首付
            </div>
            <div v-show="paymentTypeIndex === 2" class="pay-fs-2-2-3">
              货到再付款，支持现金交易
            </div>
          </div>
        </div>
      </div>
      <div class="pay-shop-liuyan">
        <p class="pay-liuyan-1">订单留言</p>
        <div class="pay-liuyan-2">
          <textarea
            rows="5"
            v-model="content"
            placeholder="限300字（若有特殊需求，请联系商城在线客服)"
            maxlength="300"
          ></textarea>
          <p>商品总金额：¥{{ orderTotal }}</p>
          <p>运费：0.00</p>
          <p>优惠：¥0.00</p>
          <p>赠送积分：{{ list.price }}</p>
        </div>
      </div>
      <!-- <van-submit-bar
        :price="list.price * $route.query.value * 100"
        button-text="提交订单"
        @submit="saveOrder(list, index)"
      /> -->
      <div class="pay-shop-footer">
        <p class="price">
          订单总金额：<span>¥{{ orderTotal }}</span>
        </p>
        <a class="order" @click="saveOrder(list)">提交订单</a>
      </div>
    </div>
  </div>
</template>
<script>
import { getData } from "@/api/data.js";
import { Toast } from "mint-ui";
import { mapState } from "vuex";
import requests from "@/api/testBackendInterface";
import header from "@/components/header/index";
export default {
  name: "pay",

  data() {
    return {
      user: JSON.parse(localStorage.getItem("user")),
      pay: [],
      address_phone: "15255460858",
      content: "",
      invoice: "",
      paymentType: ["在线支付", "花呗分期", "货到付款"],
      paymentTypeIndex: 0,
      headerLeftStatus: true,
      carts: [],
      goodDetail: JSON.parse(localStorage.getItem("goodDetails")),
      address: {}
    };
  },

  methods: {
    saveOrder(goodDetail) {
      let dataCount = [];
      if (!this.address) {
        this.$alert("检测到您还没有默认收获地址，是否前去设置？", "警告！", {
          confirmButtonText: "确定",
          callback: action => {
            this.$router.push("address");
          }
        });
        return false;
      }
      if (!this.invoice) {
        Toast("请输入发票抬头");
        return false;
      }

      var myDate = new Date();
      var Year = myDate.getFullYear();
      var Month = myDate.getMonth() + 1;
      var Day = myDate.getDate();
      goodDetail.forEach(list => {
        list["paymentType"] = this.paymentType[this.paymentTypeIndex];
        requests({
          url: "/order/addSimpleOrder",
          method: "POST",
          data: {
            paymentType: list.paymentType,
            img_url: list.img_url,
            name: list.name,
            content: list.content,
            bright: list.bright,
            title: list.title,
            price: list.price,
            value: list.value,
            user_id: this.user.id,
            shopping_id: list.id,
            invoice: this.invoice,
            address_id: this.address.id,
            order_date: Year + "-" + Month + "-" + Day,
            order_comment: this.content
          }
        }).then(({ data }) => {
          if (data.data > 0) {
            dataCount.push(true);
          } else {
            dataCount.push(false);
          }
        });
      });

      if (
        dataCount.every(data => {
          return data;
        })
      ) {
        this.$message({
          showClose: true,
          message: "提交成功",
          type: "success",
          duration: 1000
        });

        setTimeout(() => {
          if (this.$route.query.flag === "cart") {
            goodDetail.forEach(list => {
              requests({
                url: "/shoppingCarts/delShoppingCarts",
                method: "POST",
                data: {
                  user_id: list.user_id,
                  shopping_id: list.shopping_id
                }
              });
            });
          }
          this.$router.push({
            name: "success"
          });
        }, 1100);
      } else {
        this.$message({
          showClose: true,
          message: "提交失败",
          type: "error",
          duration: 1000
        });
      }

      // list["invoice"] = this.invoice;
      // list["content"] = this.content;
      // list["consignee"] = this.address.name;
      // list["phone"] = this.address.tel;
      // list["address"] =
      //   this.address.province + this.address.city + this.address.county;
      // list["homeValue"] = this.$route.params.value; //改变原来固定的数量 1
      // list["orderNumber"] =
      //   Year +
      //   "" +
      //   Month +
      //   "" +
      //   Day +
      //   "" +
      //   Math.random()
      //     .toFixed(15)
      //     .substr(2); //订单号
    },
    selectPaymentType(index) {
      this.paymentTypeIndex = index;
    },
    toFixed(value) {
      return value.toFixed(2);
    },
    orderDetail() {},
    saveAddress() {
      this.$router.push("/add_address");
    },
    chooseElseAddress() {
      this.$router.push("address");
    }
  },
  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (from.path == "/cart") {
      }
    });
  },
  props: ["goodDetails"],
  mounted() {
    this.pay.push(this.goodDetail);
    if (Array.isArray(this.goodDetail)) {
      // console.log("是Array");
      this.goodDetail.forEach(list => {
        this.carts.push(list);
      });
    } else {
      // console.log("不是Array");
      this.carts.push(this.goodDetail);
    }
    requests({
      url: "/address/queryDefault",
      method: "POST",
      data: {
        user_id: this.user.id,
        isDefault: true
      }
    }).then(({ data }) => {
      this.address = data.data;
    });
    // this.orderDetail();
    // getData().then(res => {
    // console.log(this.$route.query);
    // res.data.homeData[this.$route.query.shop_id - 1].data.forEach(list => {
    //   if (list.id == this.$route.query.id) {
    //     this.pay.push(list);
    //   }
    // });
    //   res.data.homeData.forEach(list => {
    //     if (list.id === 1) {
    //       return;
    //     }
    //     list.data.forEach(data => {
    //       if (data.name === this.$route.query.name) {
    //         this.pay.push(data);
    //       }
    //     });
    //   });
    // });
    // if (Array.isArray(this.pay) && this.pay.length == 0) {
    //   this.pay.push(this.carts);
    //   if (this.pay.length > 1) {
    //     this.pay.splice(0, 1);
    //   }
    // }
  },
  computed: {
    // address() {
    //   var address = [];
    //   this.$store.state.address.forEach(list => {
    //     if (list.default) {
    //       address = list;
    //     }
    //   });
    //   return address;
    // },
    orderTotal() {
      let total = 0;
      this.carts.forEach(item => {
        total += parseInt(item.price) * parseInt(item.value);
      });
      return total;
    }
  },
  components: {
    "v-header": header
  }
};
</script>

<style lang="less" scoped>
.active {
  border: 1px solid #444;
  color: red;
}
.block {
  float: left;
}
.pay-address {
  width: 100%;
  height: auto;
  background: url("https://shopstatic.vivo.com.cn/vivoshop/wap/dist/images/prod/bg-addr-box-line_d380baa.png")
    #fff left bottom repeat-x;
  background-size: 1.6rem;
  padding-top: 1.45rem;
  padding-bottom: 0.43rem;
  display: block;
  .saveAddress {
    width: 90%;
    margin: auto;
    display: flex;
    align-items: center;
    justify-content: space-between;
    p {
      font-size: 0.41rem;
      color: #666;
    }
    i {
      font-size: 0.4rem;
    }
  }
  .address-else {
    display: flex;
    justify-content: flex-end;
    margin-right: 10px;
  }
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
    margin: auto;
    color: #666;
    font-size: 0.38rem;
    padding-bottom: 0.2rem;
  }
}
.pay-shop {
  width: 100%;
  margin-bottom: 1.5rem;
  .pay-shop-invoice {
    width: 100%;
    height: 4.3rem;
    background: #fff;
    margin-bottom: 10px;
    margin-top: 10px;
    .pay-invoice-1 {
      width: 100%;
      height: 1.5rem;
      line-height: 1.5rem;
      border-bottom: 1px solid #eaeaea;
      font-size: 0.4rem;
      padding-left: 0.7rem;
    }
    .pay-invoice-2 {
      width: 100%;
      height: 4rem;
      .pay-invoice-2-1 {
        width: 100%;
        height: 30%;

        div {
          display: block;
          width: 2.88rem;
          height: 0.9rem;
          line-height: 0.9rem;
          border: 1px solid #d1d1d1;
          border-radius: 3px;
          margin: 0.1rem 0.3rem;
          float: left;
          text-align: center;
        }
      }

      .pay-invoice-2-2 {
        width: 92%;
        height: 70%;
        margin: auto;
        font-size: 0.35rem;

        p {
          margin-top: 10px;
          margin-bottom: 10px;
        }

        input {
          width: 100%;
          height: 1.18rem;
          border: 1px solid #d1d1d1;
          border-radius: 3px;
          padding-left: 0.2rem;
        }
      }
    }
  }
  .pay-shop-list {
    width: 100%;
    height: 100%;
    margin-top: 0.3rem;
    background: #fff;
    .pay-shop-1 {
      width: 100%;
      height: 1.5rem;
      line-height: 1.5rem;
      border-bottom: 1px solid #eaeaea;
      font-size: 0.4rem;
      padding-left: 0.7rem;
    }
    .pay-shop-2 {
      float: left;
      img {
        width: 2.5rem;
        margin: 0.2rem;
      }
    }
    .pay-shop-2-box {
      width: 70%;
      display: flex;
      flex-direction: column;
      .name {
        font-size: 0.4rem;
        margin-top: 0.3rem;
        height: 0.6rem;
        p {
          float: right;
          margin-right: 0.5rem;
        }
      }
      .price {
        color: red;
        font-size: 0.35rem;
        font-weight: 500;
        height: 0.6rem;
      }
    }
  }
  .pay-shop-liuyan {
    width: 100%;
    height: 6.5rem;
    background: #fff;
    margin-top: 0.3rem;
    margin-bottom: 0.3rem;

    .pay-liuyan-1 {
      width: 100%;
      height: 1.5rem;
      line-height: 1.5rem;
      border-bottom: 1px solid #eaeaea;
      font-size: 0.4rem;
      padding-left: 0.7rem;
    }

    .pay-liuyan-2 {
      width: 90%;
      margin: auto;

      textarea {
        width: 100%;
        height: 2rem;
        border: 1px solid #d1d1d1;
        border-radius: 3px;
        padding: 0.15rem 0.2rem;
        font-size: 0.35rem;
        margin: 0.3rem auto;
        display: block;
      }

      p {
        color: #888;
        height: 0.48rem;
        font-size: 0.34rem;
      }
    }
  }
  .pay-shop-fs {
    width: 100%;
    height: 5rem;
    background: #ffffff;

    .pay-fs-1 {
      width: 100%;
      height: 1.5rem;
      line-height: 1.5rem;
      border-bottom: 1px solid #eaeaea;
      font-size: 0.4rem;
      padding-left: 0.7rem;
    }

    .pay-fs-2 {
      width: 100%;
      height: 3.5rem;
      background: #ffffff;

      .pay-fs-2-1 {
        width: 100%;
        height: 40%;
        font-size: 0.35rem;
        // background yellow
        display: flex;
        justify-content: center;
        align-items: center;

        div {
          display: block;
          width: 2.88rem;
          height: 0.9rem;
          line-height: 0.9rem;
          border: 1px solid #d1d1d1;
          border-radius: 3px;
          margin: 0.1rem;
          float: left;
          text-align: center;
        }
      }

      .pay-fs-2-2 {
        width: 100%;
        height: 60%;
        font-size: 0.35rem;

        // background red
        div {
          width: 90%;
          height: auto;
          border-radius: 3px;
          border: 1px solid #d1d1d1;
          margin: auto;
          // padding: 0.3rem;
          padding-top: 0.3rem;
          padding-bottom: 0.3rem;
          padding-left: 0.3rem;
        }

        .pay-fs-2-2-2 {
          height: 1.56rem;
        }
      }
    }
  }
}
.pay-shop-footer {
  width: 100%;
  height: 1.5rem;
  border-top: 1px solid #eaeaea;
  background: white;
  position: fixed;
  bottom: 0;
  .price {
    float: left;
    line-height: 1.5rem;
    font-size: 0.43rem;
    color: #666;
    padding-left: 0.3rem;
    span {
      color: red;
    }
  }
  .order {
    width: 3.3rem;
    height: 0.9rem;
    line-height: 0.9rem;
    font-size: 0.35rem;
    margin-top: 0.3rem;
    margin-right: 0.3rem;
    border-radius: 30px;
    text-align: center;
    color: #fff;
    background: #f81200;
    float: right;
  }
}
</style>
