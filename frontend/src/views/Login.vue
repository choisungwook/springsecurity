<template>
  <v-form>
    <v-container>
      <v-row>
        <h1>로그인 페이지입니다</h1>
      </v-row>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field
            v-model="username"
            :counter="10"
            label="username"
            required
          ></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field
            v-model="password"
            :type="'password'"
            :counter="10"
            label="password"
            required
          ></v-text-field>
        </v-col>
      </v-row>
      <v-row>
        <v-btn  @click="login"> 로그인 </v-btn>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
import * as loginAPI from "@/api/login";

export default {
  data: () => ({
    username: "",
    password: "",
  }),
  methods: {
    login() {
      const params = new URLSearchParams();
      params.append("email", this.username);
      params.append("password", this.password);
      loginAPI
        .login(params)
        .then((response) => {
          this.$store.dispatch("login/Login");
          console.log("login success");
          // JSESSIONID
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
