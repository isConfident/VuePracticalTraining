<template lang="html">
    <!-- gotoRouter:点击后路由跳转到与id名相同的route.name所对应的路径 -->
    <footer class="footer" @click.stop='gotoRouter'>
        <mt-tabbar v-model="selected" fixed>
            <mt-tab-item id="首页">
                <i slot="icon" class="icon-index"></i>
                首页
            </mt-tab-item>
            <mt-tab-item id="分类页">
                <i slot="icon" class="icon-category"></i>
                分类
            </mt-tab-item>
            <mt-tab-item id="购物车页">
                <i slot="icon" class="icon-car"></i>
                购物车
            </mt-tab-item>
            <mt-tab-item id="用户页">
                <i slot="icon" class="icon-user"></i>
                我的
            </mt-tab-item>
        </mt-tabbar>
    </footer>
</template>


<script>

</script>

<style lang="less" scoped>
@import '../assets/fz.less';
@import '../assets/index/style.css';

.mint-tab-item-label:hover {
    color:#333;

}
.footer {


    .mint-tabbar {
        background-color: #fff;
        background-image: none;
        box-shadow: 0 0 2.2vw 0 hsla(0, 6%, 50%, .13);
        -webkit-box-shadow: 0 0 2.2vw 0 hsla(0, 6%, 50%, .13);
        .is-selected {
            color: @cl;
            background-color: #fff;
            i {
                &::before {
                    color: @cl;
                }
            }
        }
        i {
            .fz(font-size, 42);
        }
    }
}
</style>
