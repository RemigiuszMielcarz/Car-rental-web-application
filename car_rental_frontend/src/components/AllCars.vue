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
            name="carbody"/>
          <ErrorMessage name="carbody" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="text"
              name="brandname"/>
          <ErrorMessage name="brandname" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="text"
              name="modelname"/>
          <ErrorMessage name="modelname" class="errorMessage"/>
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
              type="text"
              name="power_min"/>
          <ErrorMessage name="power_min" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="text"
              name="power_max"/>
          <ErrorMessage name="power_max" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="text"
              name="mileage_min"/>
          <ErrorMessage name="mileage_min" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="text"
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
              type="text"
              name="vintage_min"/>
          <ErrorMessage name="vintage_min" class="errorMessage"/>
        </td>

        <td>
          <Field
              class="formField"
              type="text"
              name="vintage_max"/>
          <ErrorMessage name="vintage_max" class="errorMessage"/>
        </td>
      </tr>
    </table>

    <div style="margin-top: 10px">
      <button>
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
      carbody: yup
          .string(),
      brandname: yup
          .string(),
      modelname: yup
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
    handleForm() {
      console.log("wykonuje")
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
.container_all_cars {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  grid-column-gap: 60px;
  grid-row-gap: 25px;
  justify-items: stretch;
  align-items: stretch;
}

.formDiv{
  display: flex;
  text-align: center;
  justify-content: center;
  flex-direction: column;
  align-content: space-around;
  margin: auto;
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
  /*font-family: "Maiandra GD";*/
  background: none;
  /*font-size: 20px;*/
  /*width: 580px !important;*/
  /*margin:auto;*/
  border: none;
  /*border-bottom: black solid 2px;*/
  /*padding: 20px;*/
}
Field :hover{

}
.formField :hover{

  border-bottom: black solid;
}

.formFieldText{
  width: 600px;
  font-size: 20px;
  margin:auto;
  background: none;
  border: none;
  resize: none;
  height: 100px;
  border-bottom: black solid 2px;
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