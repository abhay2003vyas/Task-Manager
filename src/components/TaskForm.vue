<template>
  <div class="task-form-container">
    <h2>{{ isEditing ? 'Update Task' : 'Add Your Daily Tasks' }}</h2>
    <form @submit.prevent="submitTask" class="task-form">
      <div class="mb-3">
        <label for="taskTitle" class="form-label">Task Title</label>
        <input
          type="text"
          id="taskTitle"
          v-model="taskTitle"
          class="form-control"
          required
        />
      </div>
      <div class="mb-3">
        <label for="taskDescription" class="form-label">Description</label>
        <textarea
          id="taskDescription"
          v-model="taskDescription"
          class="form-control"
          required
        ></textarea>
      </div>
      <button type="submit" class="btn btn-primary w-100">
        {{ isEditing ? 'Update Task' : 'Add Task' }}
      </button>
      <button
        v-if="isEditing"
        @click="cancelEdit"
        type="button"
        class="btn btn-secondary w-100 mt-2"
      >
        Cancel
      </button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "TaskForm",
  props: {
    isEditing: Boolean,
    editingTask: Object, // Optional: for pre-filling when editing
  },
  data() {
    return {
      taskTitle: this.editingTask?.title || "",
      taskDescription: this.editingTask?.description || "",
    };
  },
  methods: {
    async submitTask() {
      const task = {
        title: this.taskTitle,
        description: this.taskDescription,
      };
      try {
        if (this.isEditing && this.editingTask) {
          // Update existing task
          await axios.put(`http://localhost:8080/api/tasks/${this.editingTask.id}`, task);
        } else {
          // Add new task
          await axios.post("http://localhost:8080/api/tasks", task);
        }
        this.$emit("task-updated");
        this.taskTitle = "";
        this.taskDescription = "";
      } catch (error) {
        console.error("Error submitting task:", error);
      }
    },
    cancelEdit() {
      this.$emit("edit-canceled");
    },
  },
};
</script>

<style scoped>
.task-form-container {
  background-color: #c9b5ff;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  width: 100%;
  max-width: 500px;
  margin: 2rem auto;
}

h2 {
  font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
  text-align: center;
  color: #ff0000;
}

.task-form .form-label {
  font-weight: bold;
}

.btn-primary {
  background-color: #007bff;
  border: none;
  padding: 10px;
  font-size: 1.1rem;
}

.btn-primary:hover {
  background-color: #0056b3;
}

.btn-secondary {
  background-color: #6c757d;
  border: none;
  padding: 10px;
  font-size: 1.1rem;
}

.btn-secondary:hover {
  background-color: #5a6268;
}

textarea {
  min-height: 100px;
}
</style>
