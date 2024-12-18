<template>
  <div id="app">

    <!-- Animated Description Section -->
    <section class="intro-section">
      <div class="intro-content">
        <h1>Welcome to Task Manager</h1>
        <p>
          This is a platform where you can manage your daily tasks efficiently. Add, update, and delete tasks with ease.
          Stay organized and boost your productivity!
        </p>
      </div>
    </section>

    <!-- Task Form and Task List Section -->
    <main>
      <TaskForm 
        :isEditing="isEditing" 
        :editingTask="editingTask" 
        @task-updated="handleTaskUpdated" 
        @edit-canceled="cancelEdit"
      />
      <TaskList 
        :tasks="tasks" 
        @edit-task="editTask" 
        @task-deleted="handleTaskDeleted"
      />
    </main>
  </div>
</template>

<script>
import TaskForm from "../components/TaskForm.vue";
import TaskList from "../components/TaskList.vue";
import axios from "axios";
import { useToast } from "vue-toastification";

export default {
  name: "App",
  components: {
    TaskForm,
    TaskList,
  },
  data() {
    return {
      tasks: [],
      editingTask: null,
      isEditing: false,
      toast: useToast(),
    };
  },
  methods: {
    async fetchTasks() {
      try {
        const response = await axios.get("http://localhost:8080/api/tasks");
        this.tasks = response.data;
      } catch (error) {
        this.toast.error("Error fetching tasks");
        console.error(error);
      }
    },
    editTask(task) {
      this.editingTask = task;
      this.isEditing = true;
    },
    cancelEdit() {
      this.editingTask = null;
      this.isEditing = false;
    },
    handleTaskUpdated() {
      this.toast.success("Task updated successfully!");
      setTimeout(() => window.location.reload(), 1000);
    },
    handleTaskDeleted() {
      this.toast.success("Task deleted successfully!");
      setTimeout(() => window.location.reload(), 1000);
    },
  },
  mounted() {
    this.fetchTasks();
  },
};
</script>




<style scoped>
/* Global styles */
#app {
  font-family: 'Arial', sans-serif;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

main {
  padding: 20px;
}

/* Navbar Styling */
.navbar {
  background-color: #4CAF50;
  padding: 10px 20px;
  color: white;
  font-size: 20px;
  text-align: center;
}

/* Animation for Description Section */
.intro-section {

  padding: 50px 20px;
  text-align: center;
  opacity: 0;
  animation: fadeIn 2s forwards;
}

.intro-content h1 {
  font-size: 2.5em;
  color: #333;
  margin-bottom: 20px;
}

.intro-content p {
  font-size: 1.2em;
  color: #666;
  max-width: 800px;
  margin: 0 auto;
  line-height: 1.6;
}

/* Fade In Animation */
@keyframes fadeIn {
  to {
    opacity: 1;
  }
}

/* Responsive styling for smaller screens */
@media (max-width: 768px) {
  .intro-content h1 {
    font-size: 2em;
  }

  .intro-content p {
    font-size: 1em;
  }
}
</style>
