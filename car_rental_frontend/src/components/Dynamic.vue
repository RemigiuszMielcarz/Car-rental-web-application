<template>
  <body>
  <div class="header">
    DYNAMIC CARS &nbsp; <i class="fa-solid fa-angles-up"></i>
  </div>

  <div class="container_all_cars">
    <div class="item"  v-for="(CAR) in dynamicCars" :key="CAR">
      <br/>
      {{ CAR.brandName + " " + CAR.modelName }}
      <br/>

      <img class="img" :src="require(`../plugins/images/${CAR.picture}`)"/>

      <br/>

      <button class="button" @click="checkAvailable(CAR)">
        Check Availability
      </button>

      <div v-if="message && (selectedCar === CAR)"
           class="alert" :class="selectedCar.status ? 'alert-success' : 'alert-danger'">
        {{ message }}
      </div>
    </div>
  </div>
  </body>
</template>

<script>
import axios from "axios";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Dynamic",
  data() {
    return {
      allCars: [],
      selectedCar: [],
      successful: false,
      loading: false,
      message: "",
      dynamicCars: []
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
          if (this.allCars[i].type === 'dynamic') {
            this.dynamicCars[temp] = this.allCars[i];
            temp++;
          }
        }
      }.bind(this))
    },
    checkAvailable(selectedCar) {
      if(selectedCar.status === false)
        return this.message = 'Unavailable', this.selectedCar = selectedCar;
      else
        return this.message = 'Available', this.selectedCar = selectedCar;
    },
  },
}
</script>

<style scoped>

</style>