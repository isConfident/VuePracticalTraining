<template>
  <div class="goodDetail" id="transitionName">
    <v-header title="商品详情" :headerLeftStatus="headerLeftStatus" />
    <div class="goodDetailList">
      <ul style="background: white;">
        <li>
          <div class="goodDetaiSwipe">
            <mt-swipe :auto="4000">
              <mt-swipe-item
                v-for="(v, index) in goodDetails.swiper"
                :key="index"
              >
                <img :src="v.swipe" alt="图片" />
              </mt-swipe-item>
            </mt-swipe>
          </div>
          <div class="goodDetailMain">
            <div class="gooDetailNumber">
              商品编号：{{ goodDetails.content }}
            </div>
            <div class="goodDetailName">{{ goodDetails.name }}</div>
            <div style="text-align: justify;font-size: 0.348rem;">
              <span style="margin-left:-.2rem;color:#FF4B3D;"
                >【{{ goodDetails.bright }}】</span
              >
              {{ goodDetails.title }}
            </div>
            <div class="goodDetailColor">{{ goodDetails.color }}</div>
            <div class="goodDetailPaid" v-if="flag">
              ￥{{ goodDetails.price }}
            </div>
            <div class="goodDetailPaid" v-else>
              <span class="delline">￥{{ goodDetails.price }}</span
              >￥{{ goodDetails.price / 2 }}
            </div>
          </div>
          <div class="goodDetailValue">
            <div class="_Value">购买数量：</div>
            <div class="_cartNumber" style="margin-left: 2rem;">
              <a
                href="javascript:;"
                class="goodDetailReduce"
                @click="reduceOrderValue(goodDetails)"
                >-</a
              >
              <input
                type="text"
                v-model="goodDetails.value"
                readonly="readonly"
              />
              <a
                href="javascript:;"
                class="goodDetailAdd"
                @click="addOrderValue(goodDetails)"
                >+</a
              >
            </div>
          </div>
          <div class="category" @click="show = !show">
            <div class="category-con">
              <i class="iconfont icon-icon--"></i>
              <p>支持花呗分期</p>
            </div>
            <div class="category-con">
              <i class="iconfont icon-icon--"></i>
              <p>支持以旧换新</p>
            </div>

            <div class="category-rigth">
              <i class="iconfont icon-youjiantou"></i>
            </div>
          </div>
          <transition name="fade">
            <div class="boxbox" v-show="show">
              <div class="layer" v-show="show" @click="show = !show">
                <div class="layer-box">
                  <div class="layer-box-left"></div>
                  <div class="layer-box-in">
                    <h3>服务说明</h3>
                  </div>
                  <div class="layer-box-rigt" @click.stop="show = !show">
                    <i class="iconfont icon-cancel-1-copy"></i>
                  </div>
                </div>
                <div class="layer-box-2">
                  <div class="layer-box-2-1">
                    <div class="layer-box-title">
                      <i class="iconfont icon-icon--"></i>
                      <h3>支持花呗分期</h3>
                    </div>
                    <p>商品支持花呗分期</p>
                  </div>
                  <div class="layer-box-2-1 top">
                    <div class="layer-box-title">
                      <i class="iconfont icon-icon--"></i>
                      <h3>可以使用换新鼓励金</h3>
                    </div>
                    <p>
                      换新鼓励金通过参加以旧换新回收旧手机以后获得，旧手机享受额外补贴。
                      <router-link to="/change">现在换机 </router-link>
                    </p>
                  </div>
                </div>
                <div class="layer-box-button">
                  <div>关闭</div>
                </div>
              </div>
            </div>
          </transition>
          <div class="goodDetailBox">
            <mt-navbar v-model="selected">
              <mt-tab-item id="tab-container1">图文详情</mt-tab-item>
              <mt-tab-item id="tab-container2">参数</mt-tab-item>
            </mt-navbar>
            <mt-tab-container v-model="selected" swipeable>
              <mt-tab-container-item id="tab-container1">
                <div class="goodDetailImg">
                  <p v-for="(ov, index) in goodDetails.images" :key="index">
                    <img v-bind:src="ov.one" alt="详情图片" @touchmove.stop />
                  </p>
                </div>
              </mt-tab-container-item>
              <mt-tab-container-item id="tab-container2">
                <el-table
                  :data="goodDetails.homePeiZhi"
                  style="width: 100%"
                  align="center"
                >
                  <el-table-column
                    prop="peiZhiName"
                    label="参数"
                    width="180"
                    align="center"
                  ></el-table-column>
                  <el-table-column
                    prop="peiZhiInformation"
                    label="参数值"
                    align="center"
                  ></el-table-column>
                </el-table>
              </mt-tab-container-item>
            </mt-tab-container>
          </div>
          <van-goods-action>
            <van-goods-action-icon icon="chat-o" text="客服" />
            <van-goods-action-icon
              icon="cart-o"
              text="购物车"
              :badge="cartLength"
              @click="jumpCart"
            />
            <van-goods-action-icon
              icon="star-o"
              text="收藏"
              color="red"
              @click="addSingleCollect(goodDetails)"
            />
            <van-goods-action-button
              type="warning"
              text="加入购物车"
              @click="addCart(goodDetails)"
            />
            <van-goods-action-button
              type="danger"
              text="立即购买"
              @click="jumpPay(goodDetails)"
            />
          </van-goods-action>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { mapMutations } from "vuex";
import { Toast, MessageBox } from "mint-ui";
import { getData } from "@/api/data";
import requests from "@/api/testBackendInterface";
import header from "@/components/header/index";
import axios from "axios";
export default {
  name: "detail",
  data() {
    return {
      flag: true,
      user: JSON.parse(localStorage.getItem("user")),
      IsCollection: false,
      goodDetails: JSON.parse(localStorage.getItem("simpleGoodDetail")),
      goods: [],
      show: false,
      headerLeftStatus: true,
      selected: "tab-container1",
      cartLength: 0,
      isHalfPrice: false
    };
  },
  mounted() {
    if (this.user == null) {
      this.$confirm("检测到您还未登录，是否去登录", "警告", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.$router.push({
            name: "login"
          });
        })
        .catch(() => {});
    } else {
      requests({
        url: "/shoppingCarts/queryCount",
        method: "POST",
        data: {
          user_id: this.user.id
        }
      }).then(({ data }) => {
        this.cartLength = data.data;
      });
    }

    // if (this.$route.query.path === "activity") {
    //   this.flag = false;
    // }
  },
  beforeRouteEnter(to, from, next) {
    next(vm => {
      if (from.name === "halfPrice") {
        vm.isHalfPrice = true;
        vm.flag = false;
      }
    });
  },
  beforeRouteLeave(to, from, next) {
    next(vm => {
      vm.isHalfPrice = false;
      vm.flag = true;
    });
  },
  methods: {
    addCart(goodDetails) {
      if (this.isHalfPrice) {
        this.$message({
          showClose: true,
          message: "抢购商品无法加入购物车！",
          type: "info",
          duration: 1000
        });
        return;
      }
      requests({
        url: "/shoppingCarts/addShoppingCarts",
        method: "POST",
        data: {
          img_url: goodDetails.img_url,
          name: goodDetails.name,
          content: goodDetails.content,
          bright: goodDetails.bright,
          title: goodDetails.title,
          price: goodDetails.price,
          value: goodDetails.value,
          user_id: this.user.id,
          shopping_id: goodDetails.id
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
    addSingleCollect(list) {
      requests({
        url: "/collect/addSingleCollect",
        method: "POST",
        data: {
          img_url: list.img_url,
          name: list.name,
          content: list.content,
          bright: list.bright,
          title: list.title,
          price: list.price,
          value: list.value,
          user_id: this.user.id,
          shopping_id: list.id
        }
      }).then(({ data }) => {
        if (data.data > 0) {
          this.$message({
            showClose: true,
            message: data.msg,
            type: "success",
            duration: 1000
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
    },
    addOrderValue(list) {
      list["value"]++;
    },
    reduceOrderValue(list, index) {
      list["value"] == 1 ? Toast("不能在减了") : list["value"]--;
    },
    jumpCart() {
      this.$router.push("/cart");
    },
    jumpPay(goodDetails) {
      if (!localStorage.getItem("user")) {
        MessageBox({
          title: "检测到你还未授权登陆",
          message: "是否前去登陆",
          showCancelButton: true
        }).then(res => {
          if (res == "confirm") {
            this.$router.push("/login");
          }
        });
        return false;
      }

      if (this.isHalfPrice) {
        goodDetails.price /= 2;
      }

      this.goods.push(goodDetails);

      localStorage.setItem("goodDetails", JSON.stringify(this.goods));
      this.$router.push({
        name: "pay",
        params: {
          goodDetails: JSON.stringify(goodDetails)
        }
      });
    },
  },
  components: {
    "v-header": header
  }
};
</script>

<style lang="less" scoped>
.content-center {
  text-align: center;
}
.delline {
  font-size: 10px;
  text-decoration: line-through;
}
.goodDetail {
  .peizhi {
    width: 90%;
    margin: auto;
    div {
      margin-bottom: 0.5rem;
      margin-top: 0.5rem;
    }
    h3 {
      height: 2rem;
      line-height: 2.3rem;
      font-size: 0.5rem;
      border-bottom: 1px solid #ccc;
    }
    span {
      font-size: 0.38rem;
      color: #888;
      margin-top: 0.3rem;
      display: block;
    }
    p {
      height: 0.55rem;
      color: #888;
    }
  }
  .cartlength {
    width: 15px;
    height: 15px;
    position: absolute;
    top: 1px;
    left: 30px;
    background: #f81301;
    border-radius: 50%;
    text-align: center;
    line-height: 15px;
    color: white;
  }
  .goodDetailList {
    margin-bottom: 1rem;
    padding-top: 1.45rem;
  }
  .goodDetailHeader {
    width: 100%;
    z-index: 1;
    height: 1.3rem;
    line-height: 1.3rem;
    font-size: 12px;
    background: white;
    position: fixed;
    box-shadow: 0 0 10px #cecece;
    text-align: center;
    font-size: 0.41rem;
  }
  .goodDetailHeader i {
    display: block;
    float: left;
    height: 50px;
    padding-left: 0.3rem;
    font-size: 0.71rem;
    color: black;
  }
  .el-table::before {
    z-index: -999;
  }
  .goodDetaiSwipe {
    height: 8rem;
    margin-top: 3px;
    background: white;
  }
  .goodDetaiSwipe img {
    width: 70%;
    height: 7rem;
    display: block;
    margin: auto;
  }
  .goodDetailMain {
    background: white;
    border-bottom: 1px solid #cecece;
    padding: 0.4rem;
    margin-top: -15px;
  }
  .goodDetailName {
    color: black;
    font-weight: 400;
    font-size: 0.5rem;
    line-height: 1rem;
  }
  .goodDetailPaid {
    color: #f81200;
    font-size: 0.7rem;
    margin-top: 0.1rem;
  }
  .category {
    width: 100%;
    height: 1.5rem;
    border-bottom: 10px solid #f4f4f4;
    .category-con {
      float: left;
      margin-left: 10px;
      line-height: 1.28rem;
      font-size: 0.34rem;
      display: flex;
      i {
        color: #0098df;
        font-size: 0.5rem;
      }
      p {
        color: #777;
        padding-left: 0.1rem;
      }
    }
    .category-rigth {
      float: right;
      margin-right: 10px;
      line-height: 1.28rem;
    }
  }
  .boxbox {
    width: 100%;
    height: 100%;
    position: fixed;
    background: rgba(0, 0, 0, 0.4);
    top: 0;
    bottom: 0;
    z-index: 1;
  }
  .layer {
    width: 100%;
    height: 8.3rem;
    background: white;
    position: fixed;
    bottom: 0;
    z-index: 2;
    .layer-box {
      width: 100%;
      height: 1.5rem;
      line-height: 1.5rem;
      .layer-box-left {
        width: 10%;
        height: 100%;
        float: left;
      }
      .layer-box-in {
        width: 80%;
        height: 100%;
        font-size: 0.4rem;
        float: left;
        text-align: center;
      }
      .layer-box-right {
        width: 10%;
        height: 100%;
        float: left;
        i {
          font-size: 0.4rem;
        }
      }
    }
    .layer-box-2 {
      width: 85%;
      margin: 20px auto;
      .layer-box-2-1 {
        width: 100%;
        .layer-box-title {
          display: flex;
          h3 {
            font-size: 0.4rem;
            padding-left: 0.1rem;
            display: inline-block;
          }
        }
        p {
          font-size: 0.35rem;
          height: 0.7rem;
          line-height: 0.7rem;
          color: #666;
          margin-top: 0.15rem;
          padding-left: 0.6rem;
          a {
            color: #00acff;
          }
        }
        i {
          float: left;
          color: #0098df;
          font-size: 0.5rem;
        }
      }
      .top {
        margin-top: 0.6rem;
      }
    }
    .layer-box-button {
      width: 100%;
      height: 1.5rem;
      border-top: 1px solid #eee;
      position: absolute;
      bottom: 0;
      div {
        width: 95%;
        height: 0.89rem;
        line-height: 0.89rem;
        display: block;
        text-align: center;
        margin: 0.25rem auto;
        background: #00acff;
        border-radius: 30px;
        color: white;
        font-size: 0.35rem;
      }
    }
  }
  .gooDetailNumber {
    display: none;
  }
  .goodDetailImg {
    margin-top: 4px;
    margin-bottom: 6px;
  }
  .goodDetailImg img {
    width: 100%;
    height: auto;
    display: block;
  }
  .goodDetailValue {
    height: 1.6rem;
    border-bottom: 1px solid #cecece;
    padding: 0.3rem 0rem 0rem 0.4rem;
  }
  .goodDetailAdd {
    width: 1rem;
    height: 0.8rem;
    // line-height: 0.8rem;
    display: block;
    background: white;
    float: left;
    border: 1px solid #b2b2b2;
    border-left: none;
    text-align: center;
    font-size: 0.5rem;
    color: black;
  }
  .goodDetailReduce {
    width: 1rem;
    height: 0.8rem;
    // line-height: 0.8rem;
    display: block;
    background: white;
    float: left;
    border: 1px solid #b2b2b2;
    border-right: none;
    text-align: center;
    font-size: 0.5rem;
    color: black;
  }
  ._cartNumber input {
    width: 1rem;
    height: 0.8rem;
    line-height: 0.8rem;
    font-size: 0.2rem;
    float: left;
    border: 1px solid #b2b2b2;
    text-align: center;
    color: black;
  }
  ._Value {
    float: left;
    margin-top: 0.2rem;
    font-size: 0.35rem;
  }
  .goodDetailColor {
    display: none;
  }
}
</style>
