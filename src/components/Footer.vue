<template>
    <footer class="footer">
      <div class="footer-content">
        <div class="footer-links">
          <a href="#" class="footer-link">Home</a>
          <a href="#" class="footer-link">About</a>
          <a href="#" class="footer-link">Services</a>
          <a href="#" class="footer-link">Contact</a>
        </div>
        <div class="footer-social">
          <a href="#" class="social-link"><i class="fab fa-facebook-f"></i></a>
          <a href="#" class="social-link"><i class="fab fa-twitter"></i></a>
          <a href="#" class="social-link"><i class="fab fa-instagram"></i></a>
          <a href="#" class="social-link"><i class="fab fa-linkedin-in"></i></a>
        </div>
        <div class="footer-info">
          <p>&copy; 2024 Your Company. All rights reserved.</p>
        </div>
      </div>
    </footer>
  </template>
  
  <script>
  export default {
    name: 'Footer',
  };
  </script>
  
  <style scoped>
  .footer {
    background-color: #282c34;
    color: #ffffff;
    padding: 20px 0;
    text-align: center;
    font-family: 'Arial', sans-serif;
    box-shadow: 0 -2px 10px rgba(0, 0, 0, 0.1);
  }
  
  .footer-content {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  
  .footer-links {
    margin-bottom: 10px;
  }
  
  .footer-link {
    color: #ffffff;
    margin: 0 15px;
    text-decoration: none;
    transition: color 0.3s ease;
  }
  
  .footer-link:hover {
    color: #61dafb;
  }
  
  .footer-social {
    margin-bottom: 10px;
  }
  
  .social-link {
    color: #ffffff;
    margin: 0 10px;
    font-size: 20px;
    transition: color 0.3s ease;
  }
  
  .social-link:hover {
    color: #61dafb;
  }
  
  .footer-info {
    font-size: 14px;
  }
  </style>
  