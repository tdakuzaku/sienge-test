import axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'
import { ActionTree, MutationTree } from 'vuex'

import { IRootState, IUser } from '../types'

Vue.use(Vuex)

const state: IRootState = {
  users: [],
  usersError: null,
  usersLoading: false,
  usersRequested: false,
}

const mutations: MutationTree<IRootState> = {
}

const actions: ActionTree<IRootState, any> = {
}

export default new Vuex.Store<IRootState>({
  actions,
  mutations,
  state,
})
