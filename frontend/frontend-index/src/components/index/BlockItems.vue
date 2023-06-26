<template lang="html">
    <section class="section1">
        <h1 class="section1-title">
            section1
            <i class="icon-right"></i>
        </h1>
        <ul class="section1-list">
            <li v-for="k in list" :key="k.id">
                <router-link :to="{name:'详情页'}">
                    <img v-lazy="k.imgPath" alt="">
                </router-link>
            </li>
        </ul>
        <router-link :to="{ name: '详情页'}"  class="section1-banner">
            <img v-lazy="banner">
        </router-link>
    </section>
</template>

<style scoped>

</style>
<script setup>
</script>