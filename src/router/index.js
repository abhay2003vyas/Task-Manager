import { createRouter, createWebHistory } from 'vue-router';
import PrePage from '../views/PrePage.vue'; // Ensure this path is correct
import Login from '../components/Login.vue';
import Signup from '../components/Signup.vue';
import HomePage from '../views/HomePage.vue'; // Ensure this path is correct

const routes = [
  { path: '/', component: PrePage },
  { path: '/login', component: Login },
  { path: '/home', component: HomePage },
  { path: '/signup', component: Signup },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
