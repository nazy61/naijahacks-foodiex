<template>
  <div>
    <q-card class="my-card">
      <q-parallax :src="food.imageUrl" :height="300" />
      <q-card-section>
        <div class="text-h6">{{ food.title }}</div>
      </q-card-section>
      <q-card-actions>
        <q-btn icon="close" color="red" @click="deleteItem" />
      </q-card-actions>
    </q-card>
  </div>
</template>

<script>
export default {
  mounted() {
    this.$store.dispatch("getFood", this.id);
  },
  computed: {
    food() {
      return this.$store.state.food;
    },
    id() {
      return this.$route.params.id;
    }
  },
  methods: {
    deleteItem() {
      this.$store.dispatch("deleteFood", this.id);
    }
  }
};
</script>
