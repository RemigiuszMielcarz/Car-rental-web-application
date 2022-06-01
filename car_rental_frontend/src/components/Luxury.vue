<template>
  <body>
    <div class="header">
      LUXURY CARS &nbsp; <i class="fa-solid fa-gem"></i>
    </div>

    <div class="container_all_cars">
      <div class="item"  v-for="(CAR) in luxuryCars" :key="CAR">
        {{ CAR.brandName + " " + CAR.modelName }}
        <br/>
        <img class="img" :src="require(`../plugins/images/${CAR.picture}`)"/>
      </div>
    </div>
  </body>
</template>

<script>
import axios from "axios";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Luxury",
  data() {
    return {
      allCars: [],
      successful: false,
      loading: false,
      message: "",
      luxuryCars: []
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
          if (this.allCars[i].type === 'luxury') {
            this.luxuryCars[temp] = this.allCars[i];
            temp++;
          }
        }
      }.bind(this))
    },
  },
}
</script>

<style scoped>

</style>