<template>
  <v-container fluid>
    Olar
  </v-container>
</template>

<script lang="ts">
import Vue from 'vue'
import axios from 'axios'

export default Vue.extend({
  data() {
    return {
      vehicle: {},
      pavedDistanceKm: 0,
      dirtDistanceKm: 0
    }
  },
  methods: {
    calculate: function () {
      let data = {
        vehicle: {
          vehicleType: "truck",
          costByKm: 1,
          payload: 5
        },
        pavedDistanceKm: 100,
        dirtDistanceKm: 200
      }
      axios.post('/transports/calculate', data)
        .then((result) => {
          console.log(result)
        })
        .catch((err) => {
          console.log(err)
        })
    }
  }
})
</script>
