<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
      <router-link class="navbar-brand" to="/">Task Manager</router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ms-auto">
          <li class="nav-item">
            <router-link class="nav-link" :to="{ path: '/' }" exact>Home</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/about">About</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/contact">Contact</router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
</template>

<script>
export default {
  name: "NavBar",
};
</script>

<style scoped>
/* General Navbar Styling */
.navbar {
  background-color: #343a40; /* Dark background for the navbar */
  padding: 10px 20px;
}

.navbar-brand {
  font-weight: bold;
  font-size: 1.8rem; /* Larger brand name */
  color: #f8f9fa;
  transition: color 0.3s ease;
}

.navbar-brand:hover {
  color: #00bcd4; /* Highlight color when hovered */
}

/* Navbar links styling */
.navbar-nav .nav-link {
  font-size: 1.1rem;
  padding: 8px 12px;
  color: #f8f9fa;
  transition: all 0.3s ease;
  border-radius: 5px;
}

.navbar-nav .nav-link:hover {
  background-color: #00bcd4; /* Highlight background on hover */
  color: #343a40;
}

/* Navbar toggle button animation */
.navbar-toggler {
  border-color: #00bcd4; /* Custom color for toggle button border */
}

.navbar-toggler-icon {
  background-color: #00bcd4; /* Custom color for toggle icon */
  border-radius: 50%; /* Rounded toggle icon */
  padding: 5px;
  transition: background-color 0.3s ease;
}

.navbar-toggler-icon:hover {
  background-color: #f8f9fa; /* Change color when hovered */
}

/* Ensure the navbar is responsive */
@media (max-width: 768px) {
  .navbar-brand {
    font-size: 1.5rem; /* Adjust size for smaller screens */
  }

  .navbar-nav .nav-link {
    font-size: 1rem; /* Smaller font size on mobile */
  }
}
</style>
