<template>
  <div class="collection">
    <v-header title="我的收藏" :headerLeftStatus="headerLeftStatus" />
    <div class="item" v-if="collections.length > 0">
      <div class="list" v-for="(list, index) in collections" :key="index">
        <div class="list-title">
          <p class="inventory">库存充足</p>
          <p class="noCollection" @click="delCollection(list)">取消收藏</p>
        </div>
        <div class="list-shop">
          <div class="list-shop-box">
            <div class="list-box-left">
              <img :src="list.img_url" @click="toDetail(list)" />
              <p>
                <span class="title">{{ list.name }}</span>
                <span class="price">¥{{ toFixed(list.price) }}</span>
              </p>
            </div>
            <div class="list-box-right">
              <p @click="jumpPay(list)">立即购买</p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="item" v-else>
      <h3>您还没有收藏商品哦~</h3>
    </div>
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import header from "@/components/header/index";
import requests from "@/api/testBackendInterface";
export default {
  data() {
    return {
      headerLeftStatus: true,
      collections: [],
      user: JSON.parse(localStorage.getItem("user"))
    };
  },
  mounted() {
    requests({
      url: "/collect/queryAllCollect",
      method: "POST",
      data: {
        user_id: this.user.id
      }
    }).then(({ data }) => {
      this.collections = data;
    });
  },
  methods: {
    // ...mapMutations({
    //   delCollection: "cart/DEL_COLLECTION"
    // }),
    toDetail(list) {
      requests({
        url: "/commodity/singleQuery?id=" + list.shopping_id,
        method: "GET"
      }).then(({ data }) => {
        localStorage.setItem("simpleGoodDetail", JSON.stringify(data));
        this.$router.push({
          name: "detail"
        });
      });
    },
    delCollection(list) {
      requests({
        url: "/collect/delSingleCollect",
        method: "POST",
        data: {
          user_id: list.user_id,
          shopping_id: list.shopping_id
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
    jumpPay(list) {
      let arr = [];
      arr.push(list);
      localStorage.setItem("goodDetails", JSON.stringify(arr));
      this.$router.push({
        path: "/pay"
      });
    },
    toFixed(value) {
      return JSON.parse(value).toFixed(2);
    }
  },
  // computed: {
  //     ...mapState({
  //         collections: state => state.cart.collections
  //     })
  // },
  components: {
    "v-header": header
  }
};
</script>

<style lang="less" scoped>
.collection {
  width: 100%;
  height: auto;
  .item {
    width: 100%;
    height: 100%;
    position: relative;
    top: 1.5rem;
    .list {
      width: 100%;
      height: 4.7rem;
      background: #ffffff;
      display: flex;
      flex-direction: column;
      margin-bottom: 0.05rem;
      .list-title {
        width: 100%;
        height: 1.3rem;
        border-bottom: 1px solid #f4f4f4;
        font-size: 0.35rem;
        display: flex;
        justify-content: space-between;
        align-items: center;
        .inventory {
          color: #55b451;
          padding-left: 0.5rem;
          font-weight: 500;
        }
        .noCollection {
          padding-right: 0.5rem;
          color: #626262;
          font-weight: 500;
        }
      }
      .list-shop {
        width: 100%;
        height: 3.4rem;
        .list-shop-box {
          width: 95%;
          height: 100%;
          margin: auto;
          display: flex;
          .list-box-left {
            width: 68%;
            height: 100%;
            position: relative;
            display: flex;
            img {
              width: 2.9rem;
              height: 2.7rem;
              margin-top: 0.2rem;
            }
            p {
              width: 50%;
              height: 100%;
              font-size: 0.45rem;
              display: flex;
              flex-direction: column;
              text-indent: 0.3rem;
              .title {
                width: 4rem;
                color: #514e56;
                font-weight: 500;
                margin-top: 0.3rem;
                margin-bottom: 0.2rem;
              }
              .price {
                color: #ff0202;
                font-weight: 500;
              }
            }
          }
          .list-box-right {
            width: 32%;
            height: 100%;
            display: flex;
            align-items: flex-end;
            position: relative;
            p {
              width: 3rem;
              height: 0.95rem;
              line-height: 0.95rem;
              background: #ff0202;
              border-radius: 0.5rem;
              color: #fff;
              font-size: 0.2rem;
              text-align: center;
              position: absolute;
              bottom: 0.5rem;
              font-size: 0.35rem;
            }
          }
        }
      }
    }
  }
}
</style>
