<template>
  <v-app>
    <v-toolbar app dark color="primary">
      <v-toolbar-title v-text="title"></v-toolbar-title>
      <v-spacer></v-spacer>
    </v-toolbar>
    <v-content>
      <router-view></router-view>
    </v-content>
  </v-app>
</template>

<script lang="ts">
import Vue from 'vue'
import { mapActions } from 'vuex'

export default Vue.extend({
  data() {
    return {
      title: 'Sienge | Transporte'
    }
  },
  methods: {
  },
  name: 'App',
})
</script>
