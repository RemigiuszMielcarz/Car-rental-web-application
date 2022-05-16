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
  </body>
</template>

<script>

export default {
  name: "AllCars"
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
</style>