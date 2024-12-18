<template>
  <div id="app">
    <Navbar />
    <!-- <HomePage/> -->
    <router-view />
    <Footer/>
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue'
// import HomePage from './views/HomePage.vue';
// import PrePage from './views/PrePage.vue';
import Footer from './components/Footer.vue';
export default {
  name: 'App',
  components: {
    Navbar,
    // HomePage,
    // PrePage,
    Footer,
  },
};
</script>

<style>
body {
  margin: 0;
  font-family: 'Arial', sans-serif;
  background-color: #f4f4f9;
}

#app {
  text-align: center;
  color: #2c3e50;
}
</style>
