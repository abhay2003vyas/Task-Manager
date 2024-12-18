// src/main.js

import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import Toast from 'vue-toastification';
import 'vue-toastification/dist/index.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

const app = createApp(App);

// VueToastification options to center the popup
const toastOptions = {
  position: "top-center", // Center align the popup (options: 'top-center', 'bottom-center')
  timeout: 3000, // Optional: duration in milliseconds
  closeOnClick: true, // Optional: Close when clicked
  pauseOnHover: true, // Optional: Pause the timer on hover
};

app.use(router);
app.use(Toast, toastOptions);

app.mount('#app');
