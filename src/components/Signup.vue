<template>
    <div class="signup-container">
      <h1>Signup</h1>
      <form @submit.prevent="signupUser">
        <input v-model="username" type="text" placeholder="Username" required />
        <input v-model="email" type="email" placeholder="Email" required />
        <input v-model="password" type="password" placeholder="Password" required />
        <button type="submit" class="signup-button">Sign Up</button>
      </form>
      <div v-if="errorMessage" class="error">{{ errorMessage }}</div>
    </div>
  </template>
  
  <script>
  import Swal from 'sweetalert2';
  import { useRouter } from 'vue-router';
  
  export default {
    data() {
      return {
        username: "",
        email: "",
        password: "",
        errorMessage: "",
      };
    },
    setup() {
      const router = useRouter();
      return { router };
    },
    methods: {
      async signupUser() {
        try {
          const response = await fetch("http://localhost:8080/api/task/signup", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ username: this.username, email: this.email, password: this.password }),
            credentials: "include",
          });
  
          if (!response.ok) {
            const errorData = await response.text();
            throw new Error(errorData);
          }
  
          Swal.fire({
            title: '🎉 Signup Successful!',
            html: 'Welcome to the community! <br> Redirecting to the login page...',
            icon: 'success',
            showConfirmButton: false,
            timer: 3000,
            timerProgressBar: true,
            willClose: () => {
              this.$emit('switch-component', 'Login');
            },
            customClass: {
              popup: 'swal2-custom-popup'
            }
          });
  
        } catch (error) {
          this.errorMessage = error.message;
          Swal.fire({
            title: 'Error!',
            text: this.errorMessage,
            icon: 'error',
            confirmButtonText: 'Retry',
            customClass: {
              popup: 'swal2-custom-popup'
            }
          });
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .signup-container {
    max-width: 400px;
    margin: 50px auto;
    padding: 30px;
    border: 1px solid #ccc;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    background: linear-gradient(135deg, #feb048 0%, #0d3c67 100%);
    font-family: 'Helvetica Neue', sans-serif;
    text-align: center;
    animation: fadeIn 1s ease-in-out;
  }
  
  .signup-container h1 {
    color: #333;
    font-size: 2.5em;
    margin-bottom: 20px;
    animation: dropIn 1s ease-out;
  }
  
  .signup-container input {
    width: 90%;
    padding: 12px;
    margin: 10px 0;
    border: 2px solid #ddd;
    border-radius: 8px;
    box-sizing: border-box;
    transition: border-color 0.3s ease, box-shadow 0.3s ease;
  }
  
  .signup-container input:focus {
    border-color: #ff6f61;
    outline: none;
    box-shadow: 0 0 8px rgba(255, 111, 97, 0.4);
  }
  
  .signup-button {
    width: 30%;
    padding: 12px;
    background-color: #ff6f61;
    color: white;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease, transform 0.3s ease;
  }
  
  .signup-button:hover {
    background-color: #e65550;
    transform: translateY(-2px);
  }
  
  .success {
    color: green;
    margin-top: 10px;
    animation: fadeIn 0.5s ease-in-out;
  }
  
  .error {
    color: red;
    margin-top: 10px;
    animation: shake 0.5s;
  }
  
  .swal2-custom-popup {
    font-size: 1.2em;
    background-color: #fff5e6 !important;
    border-radius: 12px !important;
    color: #555;
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
  
  @keyframes dropIn {
    from {
      transform: translateY(-50px);
      opacity: 0;
    }
    to {
      transform: translateY(0);
      opacity: 1;
    }
  }
  
  @keyframes shake {
    0%, 100% {
      transform: translateX(0);
    }
    25% {
      transform: translateX(-5px);
    }
    50% {
      transform: translateX(5px);
    }
    75% {
      transform: translateX(-5px);
    }
  }
  </style>
  