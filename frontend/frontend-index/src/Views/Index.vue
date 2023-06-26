<template lang="html">
    <!-- 在首页父组件发送http请求,后将数据通过props传递给子组件,可减少请求次数,减少服务器压力 -->
    <div class="index">
        <v-header/>
        <v-swiper :swiperData="datas.swiper"/>
        <v-service/>
        <v-section1 :list="datas.section1.list" :banner='datas.section1.banner'/>
        <v-section2 :list="datas.section2.list" :banner='datas.section2.banner'/>
        <v-section3/>
        <v-section4 :list="datas.section4.list" :banner='datas.section4.banner'/>
        <v-baseline/>
        <v-footer/>
    </div>
</template>
<script>
import Header from '@/components/index/header.vue'
import Swiper from '@/components/index/Sweiper.vue'
import Service from '@/components/index/ProvideService.vue'
import Section1 from '@/components/index/BlockItems.vue'
import Section2 from '@/components/index/SlideItems.vue'
import Section3 from '@/components/index/LimitedItems.vue'
import Section4 from '@/components/index/WordsItems.vue'
import Baseline from '@/common/BaseLine.vue'
import Footer from '@/common/Footer.vue'
export default {
    components: {
        'v-header': Header,
        'v-swiper': Swiper,
        'v-service': Service,
        'v-section1': Section1,
        'v-section2': Section2,
        'v-section3': Section3,
        'v-section4': Section4,
        'v-baseline': Baseline,
        'v-footer': Footer
    },
    data() {
        return {
            datas: {
                section1: {},
                section2: {},
                section3: {},
                section4: {},
                swiper: []
            },
            loading: true
        }
    },
}

</script>
<style scoped lang="less">

</style>