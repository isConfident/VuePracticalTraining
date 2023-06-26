<template>
  <div class="ShopActivity">
    <v-header title="全场半价" :headerLeftStatus="headerLeftStatus" />
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
          v-for="(data, nameId) in list.data"
          :key="nameId"
          @click="toDetail(data)"
        >
          <img :src="data.img_url" alt="图片" />
          <h2>{{ data.name }}</h2>
          <p>{{ data.content }}</p>
          <div>￥{{ toFixed(data.price) }}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import header from "@/components/header/index";
import requests from "../../api/testBackendInterface";
</script>
<style scoped lang="less">

</style>
