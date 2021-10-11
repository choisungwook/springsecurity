<template>
  <v-form>
    <v-container>
      <v-row>
        <h1>회원가입 페이지입니다</h1>
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
        <v-btn @click="signup"> 회원가입 </v-btn>
      </v-row>
    </v-container>
  </v-form>
</template>

<script>
import * as signupAPI from "@/api/signup";

export default {
  data: () => ({
    username: "",
    password: "",
  }),
  methods: {
    signup() {
      signupAPI
        .signup(this.username, this.password)
        .then((data) => {
          console.log("success");
          console.log(data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>
