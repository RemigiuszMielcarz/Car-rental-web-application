<template>
  <body>
  <div class="header">
    CARS SORTED BY HORSEPOWER &nbsp; <i class="fa-solid fa-fire"></i>
  </div>
  <div class="container_all_cars">
    <div class="item"  v-for="(CAR) in allCars" :key="CAR">
      {{ CAR.brandName + " " + CAR.modelName }}
      <br/>
      <img class="img" :src="require(`../plugins/images/${CAR.picture}`)"/>
      <div class="power">
        {{ CAR.power }} HORSEPOWER!
      </div>
    </div>
  </div>
  </body>
</template>

<script>
import axios from "axios";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Power",
  data() {
    return {
      allCars: [],
      sortedByPower: [],
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
        this.allCars = response.data;

        let temp = 0;

        for (let i = 0; i < this.allCars.length; i++) {
          for (let j = 0; j < this.allCars.length; j++) {
            if(this.allCars[j].power < this.allCars[i].power)
            {
              temp = this.allCars[i];
              this.allCars[i] = this.allCars[j];
              this.allCars[j] = temp;
            }
          }
        }
      }.bind(this))
    },
  },
}
</script>

<style scoped>
.header {
  display: flex !important;
  background-color: black;
  color: red;
  align-items: center;
  text-align: center;
  justify-content: center;
  min-height: 50px;
  margin-bottom: 20px;
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
  width: 300px;
  height: 300px;
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
.power {
  text-align: center;
}
</style>