<template>
  <div class="home">
    <div class="header">
      <i class="iconfont icon-VIVO"></i>
    </div>
    <div class="official"></div>
    <div class="swiper">
      <mt-swipe :auto="4000">
        <mt-swipe-item v-for="data in swiperData" :key="data.id">
          <img :src="data.newsImg" />
        </mt-swipe-item>
      </mt-swipe>
    </div>
    <div class="icon" >
      <el-statistic v-if="Activity" :value="counter" time-indices title="商品降价" @finish="stopCounter()">
        <template slot="suffix"> 抢购即将开始 </template>
      </el-statistic>
      <el-button style="width:100%;height:100%" type="warning" v-show="Activity === false" @click="toActivityPage()">马上去！</el-button>
    </div>

    <div class="icon">
      <ul class="icon-ul">
        <li class="icon-li" v-for="(list, index) in routers" :key="index">
          <router-link :to="{ path: list.src }">
            <img :src="list.img" alt="vivo" @click="isTo(list.src)" />
          </router-link>
        </li>
      </ul>
    </div>
    <div class="main">
      <div class="main-box" v-for="(list, index) in shopListData" :key="index">
        <h2>{{ list.title }}</h2>
        <ul>
          <li v-for="(v, i) in list.data" :key="i" @click="jumpDetail(v)">
            <div class="list">
              <div class="image">
                <img :src="v.img_url" alt="图片" />
              </div>
              <p class="name">{{ v.name }}</p>
              <p class="nametwo">{{ v.content }}</p>
              <p class="price">￥ {{ toFixed(v.price) }}</p>
            </div>
          </li>
        </ul>
      </div>
    </div>
    <v-footer></v-footer>
  </div>
</template>
<script>
import { getHomeData, getNewsData } from "@/api/testData";
import requests from "@/api/testBackendInterface";
import footer from "@/components/footer/index";
import {mapActions} from "vuex";
export default {
  name: "index",
  data() {
    return {
      Activity: true,
      counter:this.$store.state.counter,
      routers: [
        {
          img: "/static/img/xuangou.jpg",
          src: "/phone"
        },
        {
          img: "/static/img/peijian.jpg",
          src: "/parts"
        },
        {
          img: "/static/img/pingbao.jpg",
          src: "/"
        },
        {
          img: "/static/img/dingzhi.jpg",
          src: "/"
        }
      ],
      shopListData: [],
      swiperData: [],
      noShow: false
    };
  },
  methods: {
    ...mapActions(["set_counter"]),
    /*计时器*/
    stopCounter(){
      this.Activity = false;
      this.set_counter(0)
    },
    toActivityPage(){
      this.$router.push({
        name: "halfPrice"
      });
    },
    jumpDetail(list) {
      localStorage.setItem("simpleGoodDetail", JSON.stringify(list));
      this.$router.push({
        name: "detail",
        params: {
          list: JSON.stringify(list)
        }
      });
    },
    isTo(src) {
      if (src === "/") {
        this.$message({
          showClose: true,
          message: "该功能暂未开放",
          type: "error",
          duration: 1000
        });
      }
    },
    toFixed(value) {
      return JSON.parse(value).toFixed(2);
    },
    homeShopListData() {
      getNewsData().then(({ data }) => {
        this.swiperData = data;
      });
      getHomeData().then(({ data }) => {
        // this.shopListData = res.data;
        this.shopListData = data;
      });
    }
  },
  mounted() {
    this.homeShopListData();
  },
  components: {
    "v-footer": footer
  }
};
</script>

<style lang="less" scoped>
.home {
  width: 100%;
  height: auto;
  .header {
    position: fixed;
    width: 100%;
    top: 0;
    z-index: 1;
    height: 1.45rem;
    line-height: 1.45rem;
    font-size: 0.35rem;
    background: black;
    i {
      font-size: 0.55rem;
      color: white;
      text-align: center;
      display: block;
    }
  }
  .official {
    width: 100%;
    height: 0.8rem;
    background: white;
    margin-top: 1.45rem;
    background: url("/static/img/official.png") no-repeat;
    background-size: 100% 100%;
  }
  .swiper {
    margin-top: 1px;
    height: 6.9rem;
    img {
      width: 100%;
      height: 6.9rem;
    }
  }
  .icon {
    width: 100%;
    height: 2rem;
    background: white;
    border-bottom: 1px solid #f4f4f4;
    .icon-ul {
      width: 100%;
      height: 100%;
      .icon-li {
        width: 25%;
        height: 100%;
        float: left;
        margin: auto;
        a {
          width: 100%;
          height: 100%;
          display: flex;
          justify-content: center;
          align-items: center;
          img {
            display: block;
            width: 70%;
          }
        }
      }
    }
  }
  .main {
    margin-bottom: 1.6rem;
    h2 {
      display: block;
      height: 1.6rem;
      background: #f7f7f7;
      font-size: 0.49rem;
      line-height: 1.6rem;
      color: #333;
      text-align: center;
    }
    h2::before,
    h2::after {
      position: relative;
      margin: 0 0.12rem;
      display: inline-block;
      content: " ";
      height: 1px;
      width: 0.4rem;
      background-color: #9c9c9c;
      top: -0.16rem;
    }
    ul {
      width: 100%;
      height: auto;
      overflow: hidden;
    }
    li {
      list-style: none;
      .list {
        width: 50%;
        height: auto;
        background: white;
        float: left;
        border-right: 1px solid #f4f4f4;
        border-top: 1px solid #f4f4f4;
        padding-bottom: 0.25rem;
        .price {
          margin: auto;
          text-align: center;
          font-size: 0.38rem;
          color: #f81200;
          font-weight: 500;
          padding-top: 0.8rem;
          padding-bottom: 0.2rem;
        }
        .name {
          width: 80%;
          height: 0.64rem;
          line-height: 0.5rem;
          overflow: hidden;
          white-space: nowrap;
          text-overflow: ellipsis;
          margin: auto;
          font-size: 0.38rem;
          font-weight: 800;
          text-align: center;
        }
        .nametwo {
          width: 90%;
          height: 0.99rem;
          font-size: 0.29rem;
          text-align: center;
          overflow: hidden;
          margin: auto;
          display: -webkit-box;
          -webkit-box-orient: vertical;
          -webkit-line-clamp: 2;
        }
        .image {
          width: 100%;
          background: white;
          padding-top: 0.2rem;
          padding-bottom: 0.3rem;
          img {
            width: 2.48rem;
            height: 2.6rem;
            display: block;
            margin: auto;
            margin-top: 0.4rem;
            margin-bottom: 0.2rem;
          }
        }
      }
    }
  }
}
</style>
