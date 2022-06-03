<template>
  <body>
    <div class="header">
      ELECTRIC CARS &nbsp; <i class="fa-solid fa-charging-station"></i>
    </div>

    <div class="container_all_cars">
      <div class="item"  v-for="(CAR) in electricCars" :key="CAR">
        <br/>
        {{ CAR.brandName + " " + CAR.modelName }}
        <br/>

        <img class="img"
             @click="$router.push('../rent_car');
             rememberCar(CAR)"
             :src="require(`../plugins/images/${CAR.picture}`)"/>

        <br/>

        <div class="option">
          <button class="button" id="firstbtn" @click="checkAvailable(CAR)">
            Check Availability
          </button>

          <button class="button" id="secondbtn" @click="rentCar(CAR)">
            Rent this car
          </button>
        </div>

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
  name: "Electric",
  data() {
    return {
      allCars: [],
      selectedCar: [],
      successful: false,
      loading: false,
      message: "",
      electricCars: []
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
          if (this.allCars[i].type === 'electric') {
            this.electricCars[temp] = this.allCars[i];
            temp++;
          }
        }
      }.bind(this))
    },
    checkAvailable(selectedCar) {
      if(selectedCar.status === false) {
        this.selectedCar = selectedCar;
        return this.message = 'Unavailable';
      }
      else {
        document.getElementById("firstbtn").style.display = "none";
        document.getElementById("secondbtn").style.display = "block";
        this.selectedCar = selectedCar;
        return this.message = 'Available';
      }
    },
    rentCar(selectedCar) {
      if(selectedCar.status === true) {
        axios.patch("http://localhost:8080/api/items/rent/"+selectedCar.modelName,{});
        this.selectedCar=selectedCar
        this.$router.push('/')
      }
    },
    rememberCar(selectedCar) {
      localStorage.setItem('selectedCar', JSON.stringify(selectedCar));
    }
  },
}
</script>

<style scoped>

</style>