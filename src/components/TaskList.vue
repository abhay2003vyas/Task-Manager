<template>
  <div class="task-list">
    <h2>Task List</h2>
    <div v-if="tasks.length === 0" class="alert alert-info">
      No tasks available. Add a new task!
    </div>
    <ul v-else class="list-group">
      <li
        v-for="task in tasks"
        :key="task.id"
        class="list-group-item d-flex justify-content-between align-items-center"
      >
        <div>
          <h5>{{ task.title }}</h5>
          <p>{{ task.description }}</p>
        </div>
        <div>
          <button
            @click="$emit('edit-task', task)"
            class="btn btn-warning btn-sm me-2"
          >
            Edit
          </button>
          <button
            @click="deleteTask(task.id)"
            class="btn btn-danger btn-sm"
          >
            Delete
          </button>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from "axios";
import { useToast } from "vue-toastification";

export default {
  name: "TaskList",
  props: {
    tasks: Array,
  },
  methods: {
    async deleteTask(id) {
      const toast = useToast();
      try {
        await axios.delete(`http://localhost:8080/api/tasks/${id}`);
        this.$emit("task-deleted");
      } catch (error) {
        toast.error("Error deleting task");
        console.error(error);
      }
    },
  },
};
</script>


<style scoped>
.list-group-item{
  background-color: #f6f6fd;
}
.task-list {
  margin-top: 2rem;
}

h2 {
  background-color: #00e077;
  color: #004890;
  text-align: center;
}

.list-group-item {
  border-radius: 10px;
  margin-bottom: 1rem;
  text-align: left;
}

.btn-danger {
  background-color: #dc3545;
  border: none;
}

.btn-danger:hover {
  background-color: #c82333;
}

.btn-warning {
  background-color: #ffc107;
  border: none;
}

.btn-warning:hover {
  background-color: #e0a800;
}
</style>
