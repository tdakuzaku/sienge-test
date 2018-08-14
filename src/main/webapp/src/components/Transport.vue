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
                  <v-text-field v-model="data.pavedDistanceKm" prepend-icon="explore" label="Rodovia pavimentada (Km)" type="number"></v-text-field>
                  <v-text-field v-model="data.dirtDistanceKm" prepend-icon="explore_off" label="Rodovia não-pavimentada (Km)" type="number"></v-text-field>
                  <v-select v-model="data.vehicle.vehicleType" prepend-icon="local_shipping" item-text="label" item-value="id" :items="vehicles" label="Veículo"></v-select>
                  <v-text-field v-model="data.vehicle.payload" prepend-icon="get_app" label="Carga (Ton)" type="number"></v-text-field>
                  <div class="text-xs-center">
                    <v-btn color="success" @click="calculate">Calcular</v-btn>
                  </div>
                </v-form>
              </v-card-text>
              <v-card-actions>
                <v-text-field v-model="total" prepend-icon="attach_money" label="Custo" type="number" disabled></v-text-field>
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
      vehicles: [
        { id: 'truck_trunk', label: 'Caminhão caçamba' },
        { id: 'bucket_truck', label: 'Caminhão baú' },
        { id: 'cart', label: 'Carreta' }
      ],
      data: {
        vehicle: {
          vehicleType: 'cart',
          payload: 8
        },
        transport: {
	      },
        pavedDistanceKm: 100,
        dirtDistanceKm: 0,
      },
      total: null
    }
  },
  methods: {
    calculate: function () {
      axios.post('/transports/calculate/', this.data)
        .then((result) => {
          this.total = result.data
        })
        .catch((err) => {
          console.log(err)
        })
    }
  }
})
</script>
