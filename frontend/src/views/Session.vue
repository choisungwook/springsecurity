<template>
  <v-form>
    <v-container>
      <v-snackbar v-model="snackbar" :timeout="timeout" centered>
        {{ snackbar_text }}
        <template v-slot:action="{ attrs }">
          <v-btn color="blue" text v-bind="attrs" @click="snackbar = false">
            Close
          </v-btn>
        </template>
      </v-snackbar>
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
    snackbar: false,
    snackbar_text: "로그인이 필요합니다.",
    timeout: 2000,
  }),
  methods: {
    info() {
      const logined = this.$store.getters["login/isLogin"];
      if (logined === false) {
        this.snackbar = true;
      } else {
        const sessionid = this.$cookies.get("JSESSIONID");
        console.log("[세션요청] 세션id: " + sessionid);

        SessionAPI.sessioninfo()
          .then((data) => {
            console.log("인증 성공");
            console.log(data.data);
          })
          .catch((error) => {
            console.log(error);
          });
      }
    },
  },
};
</script>
