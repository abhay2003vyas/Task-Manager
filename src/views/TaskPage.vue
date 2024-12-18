<template>
  <div>
    <TaskForm
      :isEditing="isEditing"
      :editingTask="editingTask"
      @task-updated="fetchTasks"
      @edit-canceled="cancelEdit"
    />
    <TaskList
      :tasks="tasks"
      @task-updated="fetchTasks"
      @edit-task="startEdit"
    />
  </div>
</template>

<script>
import axios from 'axios';
import TaskForm from '../components/TaskForm.vue';
import TaskList from '../components/TaskList.vue';

export default {
  components: { TaskForm, TaskList },
  data() {
    return {
      tasks: [],
      isEditing: false,
      editingTask: null,
    };
  },
  methods: {
    async fetchTasks() {
      const response = await axios.get("http://localhost:8080/api/tasks");
      this.tasks = response.data;
    },
    startEdit(task) {
      this.isEditing = true;
      this.editingTask = task;
    },
    cancelEdit() {
      this.isEditing = false;
      this.editingTask = null;
    },
  },
  created() {
    this.fetchTasks();
  },
};
</script>


<style scoped>
/* Add any custom styles for TaskPage */
.container {
  margin-top: 2rem;
}

h2 {
  text-align: center;
  color: #007bff;
}
</style>

