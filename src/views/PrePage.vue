<template>
    <div>
      <!-- Background Image Section -->
      <div class="background-image">
        <!-- Welcome Section -->
        <div class="container mt-5">
          <div class="row">
            <div class="col-md-6 welcome-section">
              <h1 class="welcome-title">Welcome to TaskManager</h1>
              <p class="lead">Your ultimate solution for managing daily tasks efficiently and effectively. Add, edit, update, and delete tasks with ease.</p>
              <ul class="list-group">
                <li class="list-group-item"><i class="fas fa-tasks"></i> Organize your day-to-day tasks</li>
                <li class="list-group-item"><i class="fas fa-flag-checkered"></i> Set priorities and deadlines</li>
                <li class="list-group-item"><i class="fas fa-chart-line"></i> Track your progress</li>
                <li class="list-group-item"><i class="fas fa-users"></i> Collaborate with others</li>
              </ul>
            </div>
            <div class="col-md-6">
              <component :is="currentComponent" @switch-component="switchComponent" />
            </div>
          </div>
        </div>
      </div>
  
      <!-- About Us Section -->
      <section class="about-us mt-5">
        <div class="container">
          <h2>About Us</h2>
          <p class="about-text">TaskManager is committed to providing the best tools for managing your tasks and improving productivity. Our platform is designed with the user in mind, ensuring an intuitive and efficient experience. Our mission is to help you stay organized, meet deadlines, and collaborate effectively.</p>
        </div>
      </section>
  
      <hr class="my-5">
  
      <!-- Key Features Section -->
      <div class="features">
        <div class="container">
          <h2>Key Features</h2>
          <div class="row">
            <div class="col-md-4">
              <div class="card feature-card">
                <div class="card-body">
                  <h5 class="card-title">User-Friendly Interface</h5>
                  <p class="card-text">Enjoy a seamless and intuitive experience with our easy-to-navigate interface.</p>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card feature-card">
                <div class="card-body">
                  <h5 class="card-title">Real-Time Updates</h5>
                  <p class="card-text">Stay updated with real-time notifications and task tracking.</p>
                </div>
              </div>
            </div>
            <div class="col-md-4">
              <div class="card feature-card">
                <div class="card-body">
                  <h5 class="card-title">Collaborative Tools</h5>
                  <p class="card-text">Work together with your team and manage tasks collaboratively.</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import Login from '../components/Login.vue';
  import Signup from '../components/Signup.vue';
  
  export default {
    components: {
      Login,
      Signup,
    },
    data() {
      return {
        currentComponent: 'Login',
      };
    },
    methods: {
      switchComponent(component) {
        this.currentComponent = component;
      },
    },
  };
  </script>
  
  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap');
  @import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css');
  
  .background-image {
    background: url('../assets/background.jpg') no-repeat center center;
    background-size: cover;
    padding: 60px 0;
  }
  
  .container {
    font-family: 'Roboto', sans-serif;
    color: #333;
  }
  
  .welcome-section {
    text-align: left;
    animation: fadeIn 1s ease-in-out;
  /* White background with transparency */
    padding: 20px;
    border-radius: 8px;
  }
  
  .welcome-title {
    color: #dd5e10;
    font-size: 3.2em;
    font-weight: bold;
  }
  
  .lead {
    font-size: 1.5em;
    margin-bottom: 20px;
    color: #070707;
  }
  
  .list-group {
    padding-left: 0;
    width: 100%;
    border-radius: 10px;
  }
  
  .list-group-item[data-v-925cd939] {
      border: none;
      width: 350px;
      /* padding: 20px 30px; */
      color: #fff;
      font-size: 1.2em;
      display: flex;
      align-items: center;
      background-color: #25727d;
      margin-bottom: 10px;
      border-radius: 10px;
      transition: transform 0.3s ease, box-shadow 0.3s ease;
  }
  
  .list-group-item i {
    margin-right: 10px;
    color: #ff6f61;
  }
  
  .list-group-item:hover {
    transform: translateY(-5px);
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
  
  .about-us {
    background-color: #f8f9fa;
    padding: 50px 20px;
    text-align: center;
  }
  
  .about-us h2 {
    color: #2c3e50;
    font-size: 2.5em;
    margin-bottom: 20px;
    font-weight: bold;
  }
  
  .about-text {
    color: #666;
    font-size: 1.2em;
    line-height: 1.8;
    max-width: 800px;
    margin: 0 auto;
  }
  
  .features {
    margin-top: 50px;
  }
  
  .feature-card {
    border: none;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
    transition: transform 0.3s ease, box-shadow 0.3s ease;
  }
  
  .feature-card:hover {
    transform: translateY(-10px);
    box-shadow: 0 16px 32px rgba(0, 0, 0, 0.2);
  }
  
  .card-title {
    color: #2c3e50;
    font-size: 1.5em;
    font-weight: bold;
  }
  
  .card-text {
    font-size: 1.1em;
    color: #666;
  }
  
  /* Animations */
  @keyframes fadeIn {
    from {
      opacity: 0;
    }
    to {
      opacity: 1;
    }
  }
  
  @media (max-width: 768px) {
    .intro-content h1 {
      font-size: 2em;
    }
  
    .intro-content p {
      font-size: 1em;
    }
  }
  </style>
  