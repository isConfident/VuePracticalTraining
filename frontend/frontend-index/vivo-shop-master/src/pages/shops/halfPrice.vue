<template>
  <div class="ShopActivity">
    <v-header title="全场半价" :headerLeftStatus="headerLeftStatus" />
    <div class="Allgoods">
      <mt-navbar v-model="selected">
        <mt-tab-item id="tab-container1"
          ><span class="peijian">打折手机</span></mt-tab-item
        >
        <mt-tab-item id="tab-container2"
          ><span class="peijian" @click="requestParts"
            >打折配件</span
          ></mt-tab-item
        >
      </mt-navbar>
      <mt-tab-container v-model="selected" swipeable>
        <mt-tab-container-item id="tab-container1">
          <div
            class="lower_list"
            v-for="(data, nameId) in list.data"
            :key="nameId"
            @click="toDetail(data)"
          >
            <img :src="data.img_url" alt="图片" @touchmove.stop />
            <h2>{{ data.name }}</h2>
            <p>{{ data.content }}</p>
            <div>
              <span class="delline">￥{{ toFixed(data.price) }}</span
              >￥{{ data.price / 2 }}
            </div>
          </div>
        </mt-tab-container-item>
        <mt-tab-container-item id="tab-container2">
          <div
            class="lower_list"
            v-for="(partslist, name) in partslist.data"
            :key="name"
            @click="toDetail(partslist)"
          >
            <img :src="partslist.img_url" alt="图片" @touchmove.stop />
            <h2>{{ partslist.name }}</h2>
            <p>{{ partslist.content }}</p>

            <div>
              <span class="delline">￥{{ toFixed(partslist.price) }}</span
              >￥{{ toFixed(partslist.price / 2) }}
            </div>
          </div>
        </mt-tab-container-item>
      </mt-tab-container>
    </div>
  </div>
</template>

<script>
import header from "@/components/header";
import { getData } from "@/api/data";
import requests from "../../api/testBackendInterface";
export default {
  data() {
    return {
      headerLeftStatus: true,
      selected: "tab-container1",
      data: [],
      list: [],
      partsdata: [],
      partslist: []
    };
  },
  /**/
  props: ["id", "list_id"],
  mounted() {
    requests({
      url: "phone/query",
      method: "get"
    }).then(({ data }) => {
      this.data = data;
      this.list = this.data[0];
    });
  },
  methods: {
    selectIndex(data) {
      this.list = data;
      this.selectShopIndex = data.id - 1;
    },
    requestParts() {
      requests({
        url: "accessories/query",
        method: "get"
      }).then(({ data }) => {
        this.partsdata = data;
        this.partslist = this.partsdata[0];
      });
    },
    toFixed(value) {
      return JSON.parse(value).toFixed(2);
    },
    toDetail(data) {
      localStorage.setItem("simpleGoodDetail", JSON.stringify(data));

      this.$router.push({
        name: "detail"
      });
    }
  },

  components: {
    "v-header": header
  }
};
</script>

<style lang="less" scoped>
.peijian {
  width: 100% !important;
  height: 100% !important;
  display: block;
  text-align: center;
  line-height: 1.2rem;
  font-size: 0.4rem;
  color: #333333;
  border-bottom: 2px solid #ffffff;
}
.delline {
  font-size: 10px;
  text-decoration: line-through;
}
.Allgoods {
  position: relative;
  top: 1.2rem;
  border-bottom: 1px solid #f4f4f4;
}
.ShopActivity {
  position: absolute;
  background: #ffffff;
  width: 100%;
  height: 100%;
  top: 0;
  bottom: 0;
  z-index: 999;
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
  height: 3.6rem;
  background: white;
  float: left;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  width: 100%;
  border-right: 1px solid #f4f4f4;
  border-bottom: 1px solid #f4f4f4;
  float: left;
  margin-top: 0.1rem;
  list-style: none;
  cursor: pointer;
  img {
    height: 3.6rem;
    width: 4rem;
    display: block;
    margin: auto;
    padding: 0.5rem;
    float: left;
  }
  h2 {
    margin-top: .6rem;
    white-space: nowrap;
    text-overflow: ellipsis;
    font-size: 0.4rem;
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
