<template>
<v-container fluid fill-height>
        <v-layout align-center justify-center>
          <v-flex xs8 sm6 md4>
            <v-card class="elevation-12">
              <v-toolbar dark color="secondary">
                <v-toolbar-title>Cálculo de frete</v-toolbar-title>
              </v-toolbar>
              <v-card-text>
                <v-form>
                  <v-text-field prepend-icon="explore" label="Rodovia pavimentada (Km)" type="number"></v-text-field>
                  <v-text-field prepend-icon="explore_off" label="Rodovia não-pavimentada (Km)" type="number"></v-text-field>
                  <v-select prepend-icon="local_shipping" :items="vehicles" label="Veículo"></v-select>
                  <v-text-field prepend-icon="get_app" label="Carga (Ton)" type="number"></v-text-field>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-text-field prepend-icon="attach_money" label="Custo" type="number" disabled></v-text-field>
              </v-card-actions>
            </v-card>
          </v-flex>
        </v-layout>
      </v-container>
</template>

<script lang="ts">
import Vue from 'vue'
import axios from 'axios'

export default Vue.extend({
  data() {
    return {
      vehicles: ['Caminhão caçamba', 'Caminhão baú', 'Carreta'],
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
