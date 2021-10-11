<template>
  <v-form>
    <v-container>
      <v-row>
        <h1>세션정보 페이지입니다</h1>
      </v-row>
      <v-row>
        <v-btn @click="info"> 세션정보 보기 </v-btn>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
import * as SessionAPI from "@/api/session";

export default {
  data: () => ({
    username: "",
    session: "",
  }),
  methods: {
    info() {
      const session = this.$store.getters["session/getSession"];
      SessionAPI
        .sessioninfo(session)
        .then((data) => {
          console.log(data.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
