<template>
  <body>

    <h1>What are you looking for?</h1>

    <div class="container">
      <div class="item" @click="$router.push('./power')">
        <h2>POWER</h2>
        <img class="img" src="../plugins/images/speedometr.png">
        <br />
      </div>

      <div class="item" @click="$router.push('./electric')">
        <h2>ELECTRIC</h2>
        <img class="img" src="../plugins/images/electrical.png">
        <br />
      </div>

      <div class="item" @click="$router.push('./legendary')">
        <h2>LEGENDARY</h2>
        <img class="img" src="../plugins/images/legend.png">
        <br />
      </div>

      <div class="item" @click="$router.push('./luxury')">
        <h2>LUXURY</h2>
        <img class="img" src="../plugins/images/luxury.png">
        <br />
      </div>

      <div class="item" @click="$router.push('./design')">
        <h2>DESIGN</h2>
        <img class="img" src="../plugins/images/designed.png">
        <br />
      </div>

      <div class="item" @click="$router.push('./dynamic')">
        <h2>DYNAMIC</h2>
        <img class="img" src="../plugins/images/dynamic.png">
        <br />
      </div>
    </div>
  </body>

</template>

<script>

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Home",

}
</script>

<style scoped>
body {
  margin-left: 25px;
}
.container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-column-gap: 60px;
  grid-row-gap: 25px;
  justify-items: stretch;
  align-items: stretch;
}
.img {
  width: 200px;
  height: 200px;
}
.item {
  border-style: groove;
  border-radius: 10px;
}
.item:hover {
  background-color: #8F8F8FFF;
  cursor: pointer;
  transition: all 0.6s ease-in-out;
}
</style>