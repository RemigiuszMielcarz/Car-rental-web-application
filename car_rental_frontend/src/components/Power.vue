<template>
  <body>
    <div class="header">
      CARS SORTED BY HORSEPOWER &nbsp; <i class="fa-solid fa-fire"></i>
    </div>

    <div class="container_all_cars">
      <div class="item"  v-for="(CAR) in allCars" :key="CAR">
        <br/>
        {{ CAR.brandName + " " + CAR.modelName }}
        <br/>

        <img class="img"
             @click="$router.push('../rent_car');
             rememberCar(CAR)"
             :src="require(`../plugins/images/${CAR.picture}`)"/>
        <div class="power">
          {{ CAR.power }} HORSEPOWER!
        </div>

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
  name: "Power",
  data() {
    return {
      allCars: [],
      selectedCar: [],
      rememberedCar: [],
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
.container_all_cars {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-column-gap: 60px;
  grid-row-gap: 25px;
  justify-items: stretch;
  align-items: stretch;
}
</style>