const state = {
  session: "",
};

const getters = {
  getSession: (state) => state.session,
};

const mutations = {
  setSession: (state, session) => {
    state.session = session;
  },
};

const actions = {
  setSession({ commit }, session) {
    commit("setSession", session);
  },
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
