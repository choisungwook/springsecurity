<template>
  <v-app id="inspire">
    <v-app-bar app color="deep-purple accent-4" dark>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Spring Security Example</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn>
        <span>회원가입</span>
      </v-btn>
      <v-btn>
        <span>로그인</span>
      </v-btn>
    </v-app-bar>

    <v-navigation-drawer v-model="drawer" fixed temporary>
      <!--  -->
    </v-navigation-drawer>

    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script>
export default {
  data: () => ({ drawer: null }),
};
</script>
