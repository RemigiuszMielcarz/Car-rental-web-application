<template>
  <body>
    <div class="header">
      WELL DESIGNED CARS &nbsp; <i class="fa-solid fa-paintbrush"></i>
    </div>

    <div class="container_all_cars">
      <div class="item"  v-for="(CAR) in designCars" :key="CAR">
        {{ CAR.brandName + " " + CAR.modelName }}

        <br/>

        <img class="img" :src="require(`../plugins/images/${CAR.picture}`)"/>

        <br/>

        <button @click="checkAvailable" style="margin-bottom: 30px">
          Check Availability
        </button>
      </div>
    </div>
  </body>
</template>

<script>
import axios from "axios";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Design",
  data() {
    return {
      allCars: [],
      successful: false,
      loading: false,
      message: "",
      designCars: []
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
          if (this.allCars[i].type === 'design') {
            this.designCars[temp] = this.allCars[i];
            temp++;
          }
        }
      }.bind(this))
    },
    checkAvailable(ALLCARS) {
      console.log("Sprawdzam", ALLCARS)
      return ALLCARS
    },
  },
}
</script>

<style scoped>

</style>