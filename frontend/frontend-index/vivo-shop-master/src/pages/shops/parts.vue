<template>
  <div class="parts">
    <v-header title="手机配件" :headerLeftStatus="headerLeftStatus" />
    <div class="partsMain">
      <div class="upper">
        <span
          v-for="(data, index) in data"
          :class="selectShopIndex == index ? 'active' : ''"
          @click="selectIndex(data)"
          :key="index"
          class="list"
          >{{ data.name }}
        </span>
      </div>
      <div class="lower">
        <div
          class="lower_list"
          v-for="(list, name) in list.data"
          :key="name"
          @click="toDetail(list)"
        >
          <img :src="list.img_url" alt="图片" />
          <h2>{{ list.name }}</h2>
          <p>{{ list.content }}</p>
          <div>￥{{ toFixed(list.price) }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import header from "@/components/header/index";
import { getData } from "@/api/data";
import requests from "../../api/testBackendInterface";
export default {
  data() {
    return {
      data: [],
      list: [],
      selectShopIndex: 0,
      headerLeftStatus: true
    };
  },
  mounted() {
    requests({
      url: 'accessories/query',
      method: 'get'
    }).then(({data})=>{
      this.data = data;
      this.list = this.data[0];
      console.log(this.data)
    })
  },
  methods: {
    selectIndex(data) {
      this.list = data;
      this.selectShopIndex = data.id - 1;
    },
    toDetail(data) {
      localStorage.setItem("simpleGoodDetail", JSON.stringify(data));
      this.$router.push({
        name: "detail",
        params: {
          list: JSON.stringify(data)
        }
      });
    },
    toFixed(value) {
      return JSON.parse(value).toFixed(2);
    }
  },

  components: {
    "v-header": header
  }
};
</script>

<style lang="less" scoped>
.active {
  color: #25b5fe;
  border-bottom: 2px solid #25b5fe;
}

.upper {
  width: 100%;
  height: 1.2rem;
  line-height: 1.2rem;
  position: fixed;
  background: #ffffff;
  z-index: 1;
}

.lower {
  position: relative;
  top: 1.2rem;
  border-bottom: 1px solid #f4f4f4;
}

.list {
  float: left;
  text-align: center;
  width: 25%;
  font-size: 0.37rem;
}

.box {
  width: 100%;
  height: 1rem;
  background: #ecf0f1;
}

.parts {
  position: absolute;
  background: #ffffff;
  width: 100%;
  height: 100%;
  top: 0;
  bottom: 0;
  z-index: 999;
}

.partsHeader {
  width: 100%;
  z-index: 1;
  height: 1.3rem;
  line-height: 1.3rem;
  font-size: 12px;
  background: white;
  position: fixed;
  -webkit-box-shadow: 0 0 10px #cecece;
  box-shadow: 0 0 10px #cecece;
  text-align: center;
  font-size: 0.41rem;
}

.partsHeader i {
  display: block;
  float: left;
  height: 50px;
  padding-left: 0.3rem;
  font-size: 0.71rem;
  color: black;
}

.partsMain {
  margin-top: 1.32rem;
}

.lower_list {
  height: 6.3rem;
  background: white;
  float: left;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  width: 50%;
  border-right: 1px solid #f4f4f4;
  border-bottom: 1px solid #f4f4f4;
  float: left;
  margin-top: 0.1rem;
  list-style: none;

  img {
    height: 3.6rem;
    width: 4rem;
    display: block;
    margin: auto;
    padding: 0.5rem;
  }

  h2 {
    width: 90%;
    white-space: nowrap;
    text-overflow: ellipsis;
    font-size: 0.4rem;
    margin: auto;
    text-align: center;
    overflow: hidden;
  }

  p {
    width: 3.8rem;
    margin: 0 auto;
    padding: 0;
    height: 1.1rem;
    font-size: 0.22rem;
    line-height: 1.4;
    color: #000;
    word-break: break-all;
    padding-top: 0.2rem;
    text-align: center;
    overflow: hidden;
  }

  div {
    text-align: center;
    color: red;
    line-height: 1rem;
    font-size: 0.4rem;
  }
}
</style>
