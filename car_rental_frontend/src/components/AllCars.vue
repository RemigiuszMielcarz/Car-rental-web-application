<template>
  <body>
  <h1>All cars</h1>

  <div class="container">
    <div>
      Carbody
    </div>

    <div>
      Brand
    </div>

    <div>
      Model
    </div>

    <div>
      Country
    </div>

    <div>
      Power
    </div>

    <div>
      Mileage
    </div>

    <div>
      Color
    </div>

    <div>
      Vintage
    </div>

    <div>
      Loan period
    </div>

    <div>
      Price
    </div>
  </div>

  <br/>

  <div class="container_all_cars">
    <div class="item"  v-for="(ALLCARS) in allCars " :key="ALLCARS">
      {{ ALLCARS.brandName + " " + ALLCARS.modelName}}
      <img class="img" :src="'../plugins/images/items/' + ALLCARS.picture">

    </div>
  </div>

  </body>
</template>

<script>
import axios from "axios";
export default {
  name: "AllCars",
  data() {
    return {
      allCars: [],
      successful: false,
      loading: false,
      message: "",
    };
  },
  mounted() {
    this.fetchItems();
  },
  methods: {
    fetchItems() {
      axios.get("http://localhost:8080/api/items").then(function (response) {
        this.allCars = response.data
      }.bind(this))
    }
  }
}
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr 1fr;
  grid-template-rows: 50px 50%;
  grid-column-gap: 20px;
  grid-row-gap: 20px;
  justify-items: stretch;
  align-items: stretch;
  border-style: groove;
  border-radius: 10px;
}

body {
  margin-left: 25px;
}
.container_all_cars {
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
  text-align: center;
  justify-content: center;
  border-style: groove;
  border-radius: 10px;
}
.item:hover {
  background-color: #8F8F8FFF;
  cursor: pointer;
  transition: all 0.6s ease-in-out;
}
</style>