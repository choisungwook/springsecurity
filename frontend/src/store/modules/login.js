const state = {
  isLogin: false,
};

const getters = {
  isLogin: (state) => state.isLogin,
};

const mutations = {
  setLoginStatus: (state, status) => {
    state.isLogin = status;
  },
};

const actions = {
  Login({ commit }) {
    commit("setLoginStatus", true);
  },
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};