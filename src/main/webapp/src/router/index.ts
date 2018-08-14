import Transport from '@/components/Transport.vue'
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      component: Transport,
      name: 'transport',
      path: '/',
    },
  ],
})
