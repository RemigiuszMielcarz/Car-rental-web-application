<template>
  <body>
  <h1>All cars</h1>

  <Form @submit="handleForm" :validation-schema="schema">
    <table style="width: 100%;">
      <tr>
        <td>Car body</td>
        <td>Brand</td>
        <td>Model</td>
        <td>Country</td>
      </tr>

      <tr>
        <td>
          <Field
            class="formField"
            type="text"
            name="carBody"/>
          <ErrorMessage name="carBody" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="text"
              name="brandName"/>
          <ErrorMessage name="brandName" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="text"
              name="model"/>
          <ErrorMessage name="model" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="text"
              name="country"/>
          <ErrorMessage name="country" class="errorMessage"/>
        </td>
      </tr>
    </table>

    <table>
      <td>Power min</td>
      <td>Power max</td>
      <td>Mileage min</td>
      <td>Mileage max</td>

      <tr>
        <td>
          <Field
              class="formField"
              type="number"
              name="power_min"/>
          <ErrorMessage name="power_min" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="number"
              name="power_max"/>
          <ErrorMessage name="power_max" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="number"
              name="mileage_min"/>
          <ErrorMessage name="mileage_min" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="number"
              name="mileage_max"/>
          <ErrorMessage name="mileage_max" class="errorMessage"/>
        </td>
      </tr>
    </table>

    <table style="width: 100%; margin-left: auto; margin-right: auto">
      <td>Vintage min</td>
      <td>Vintage max</td>

      <tr>
        <td>
          <Field
              class="formField"
              type="number"
              name="vintage_min"/>
          <ErrorMessage name="vintage_min" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="number"
              name="vintage_max"/>
          <ErrorMessage name="vintage_max" class="errorMessage"/>
        </td>
      </tr>
    </table>

    <div style="margin-top: 10px">
      <button class="button" @click="this.loading = true">
        Filter cars
      </button>
    </div>
  </Form>

  <div v-if="successful">
    <div class="container_all_cars">
      <div class="item"  v-for="(ALLCARS) in allCars " :key="ALLCARS">
        {{ ALLCARS.brandName + " " + ALLCARS.modelName}}
        <br/>
        <img class="img" :src="require(`../plugins/images/${ALLCARS.picture}`)"/>
      </div>
    </div>
  </div>

  <div v-if="loading">
    <div class="container_all_cars">
      <div class="item" v-for="(ALLCARS) in sortedCars " :key="ALLCARS">
        <br/>
        {{ ALLCARS.brandName + " " + ALLCARS.modelName}}
        <br/>

        <img class="img" :src="require(`../plugins/images/${ALLCARS.picture}`)"/>

        <br/>

        <button class="button" @click="checkAvailable(ALLCARS)">
          Check Availability
        </button>

        <div v-if="message && (selectedCar === ALLCARS)"
             class="alert" :class="selectedCar.status ? 'alert-success' : 'alert-danger'">
          {{ message }}
        </div>
      </div>
    </div>
  </div>

  </body>
</template>

<script>
import axios from "axios";
import {Form, Field, ErrorMessage} from "vee-validate";
import * as yup from "yup";

export default {
  name: "AllCars",
  components: {
    Form,
    Field,
    ErrorMessage,
  },
  data: function () {
    const schema = yup.object().shape({
      carBody: yup
          .string(),
      brandName: yup
          .string(),
      model: yup
          .string(),
      country: yup
          .string(),
      vintage_min: yup
          .number()
          .moreThan(1900)
          .lessThan(2023),
      vintage_max: yup
          .number()
          .moreThan(1900)
          .lessThan(2023),
      mileage_min: yup
          .number()
          .positive(),
      mileage_max: yup
          .number()
          .positive(),
      power_min: yup
          .number()
          .positive(),
      power_max: yup
          .number()
          .positive(),
      color: yup
          .string(),
    });
    return {
      allCars: [],
      sortedCars: [],
      selectedCar: [],
      successful: false,
      loading: false,
      message: "",
      schema,
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
    },
    handleForm(advert) {
      console.log('advert: ', advert)
      advert.vintage_min = this.convertToNumber(advert.vintage_min);
      advert.vintage_max = this.convertToNumber(advert.vintage_max);
      advert.mileage_min = this.convertToNumber(advert.mileage_min);
      advert.mileage_max = this.convertToNumber(advert.mileage_max);
      advert.power_min = this.convertToNumber(advert.power_min);
      advert.power_max = this.convertToNumber(advert.power_max);
      advert.price_min = this.convertToNumber(advert.price_min);
      advert.price_max = this.convertToNumber(advert.price_max);
      advert.carBody = this.convertToString(advert.carBody);
      advert.brandName = this.convertToString(advert.brandName);
      advert.model = this.convertToString(advert.model);
      advert.country = this.convertToString(advert.country);
      advert.color = this.convertToString(advert.color);

      let URL = `http://localhost:8080/api/items` +
          `?brandName=${advert.brandName}&model=${advert.model}&carBody=${advert.carBody}` +
          `&color=${advert.color}&vintage_min=${advert.vintage_min}` +
          `&vintage_max=${advert.vintage_max}&mileage_min=${advert.mileage_min}&mileage_max=${advert.mileage_max}` +
          `&power_min=${advert.power_min}&power_max=${advert.power_max}&country=${advert.country}`;

          this.$emit('carURL', URL)

          console.log(URL)
          axios.get(URL).then(function (response) {
            this.sortedCars = response.data
          }.bind(this))
      },
    checkAvailable(selectedCar) {
      if(selectedCar.status === false)
        return this.message = 'Unavailable', this.selectedCar = selectedCar;
      else
        return this.message = 'Available', this.selectedCar = selectedCar;
    },
      convertToString(text) {
        if(text) {
          return text;
        }
        return '';
      },
      convertToNumber(number) {
        if(number) {
          return Number(number);
        }
        return '';
      },
    },
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
.container_all_cars {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-column-gap: 60px;
  grid-row-gap: 25px;
  justify-items: stretch;
  align-items: stretch;
}
form{
  display: flex;
  flex-direction: column;
}
select{
  width: 100px;
  margin:auto;
}
label{
  text-align: center;
  font-weight: bold;
  font-size: 20px;
}
.formField{
  background: none;
  border: none;
}
Field :hover{

}
.formField :hover{

  border-bottom: black solid;
}
.errorMessage{
  color: red;
  font-size: 10px;
  text-align: center;
  font-weight: bold;
}
.formDiv button{
  font-size: 40px;
  margin: 50px;
  padding: 5px 15px;
  background: none;
  border: none;
  border-radius: 15px;
  transition: all 0.3s ease-in-out;
}
.formDiv  button:hover{
  background: black;
  color: yellow;
  cursor: pointer;
}
table, th, td {
  border:1px solid black;
}
</style>