<template>
  <body>
    <div class="header">
      INFO ABOUT CLICKED CAR &nbsp; <i class="fa-solid fa-info"></i>
    </div>

    <div class="container_all_cars">
      <div class="item">
        <div class="title">
          {{ selectedCar.title }}
          <br/>
          {{selectedCar.specification}}
        </div>

<!--        <img class="img" :src="require(`../plugins/images/${selectedCar.picture}`)" alt=""/>-->

        <table class="customTable">
          <thead>
          <tr>
            <th>{{ selectedCar.brandName + " " + selectedCar.modelName }}</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td>{{ "Car Body: " + selectedCar.carBody }}</td>
          </tr>
          <tr>
            <td>{{ "Vintage: " + selectedCar.vintage }}</td>
          </tr>
          <tr>
            <td>{{ "Country: " + selectedCar.country }}</td>
          </tr>
          <tr>
            <td>{{ "Mileage: " + selectedCar.mileage + " miles"}}</td>
          </tr>
          <tr>
            <td>{{ "Color: " + selectedCar.color }}</td>
          </tr>
          <tr>
            <td>{{ selectedCar.power + " HP" }}</td>
          </tr>
          <tr>
            <td>{{ "Day: " + selectedCar.day + "$"}}</td>
          </tr>
          <tr>
            <td>{{ "Weekend: " + selectedCar.weekend + "$"}}</td>
          </tr>
          <tr>
            <td>{{ "Week: " + selectedCar.week + "$"}}</td>
          </tr>
          <tr>
            <td>{{ "Month: " + selectedCar.month + "$"}}</td>
          </tr>
          </tbody>
        </table>

        <br/>

        <div class="option">
          <button class="button" id="firstbtn" @click="checkAvailable(selectedCar)">
            Check Availability
          </button>

          <button class="button" id="secondbtn" @click="rentCar(selectedCar)">
            Rent this car
          </button>
        </div>

        <div v-if="message && (selectedCar)"
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
  name: "Car",
  data() {
    return {
      selectedCar: [],
      successful: false,
      loading: false,
      message: "",
    };
  },
  mounted() {
    this.selectedCar = JSON.parse(localStorage.getItem('selectedCar'));
    console.log("Wybrane auto: ", this.selectedCar.modelName)
  },
  methods: {
    checkAvailable(selectedCar) {
      if(selectedCar.status === false) {
        console.log(selectedCar)
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
    }
  },
}
</script>

<style scoped>
table.customTable {
  width: 100%;
  border-collapse: collapse;
  border-width: 3px;
  border-color: black;
  border-style: solid;
  color: #000000;
}

table.customTable td, table.customTable th {
  border-width: 3px;
  border-style: solid;
  padding: 5px;
}

table.customTable thead {
  background-color: #e01111;
}

.title {
  font-size: 25px;
}
</style>