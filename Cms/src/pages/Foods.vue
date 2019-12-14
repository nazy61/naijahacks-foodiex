<template>
  <div>
    <div v-if="Object.keys(foods).length > 0">
      <q-list>
        <q-item
          :to="`/food/${i}`"
          clickable
          v-for="(food, i) in foods"
          :key="i"
        >
          <q-item-section top avatar>
            <q-img
              :src="food.imageUrl"
              spinner-color="primary"
              spinner-size="82px"
            />
          </q-item-section>
          <q-item-section>
            <q-item-label>{{ food.title }}</q-item-label>
            <q-item-label caption lines="2">{{ food.benefits }}. </q-item-label>
          </q-item-section>
          <q-item-section side top>
            <q-item-label caption>5 min ago</q-item-label>
            <q-icon name="star" color="yellow" />
          </q-item-section>
        </q-item>
      </q-list>
    </div>

    <div v-else class="text-center">
      <q-icon size="100px" color="primary" name="mdi-bed-empty" />
      <h5>Oops, no food for now</h5>
      <div>
        <q-btn
          rounded
          color="primary"
          icon="mdi-plus"
          label="add food"
          to="/create-food"
        />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      documents: []
    };
  },
  computed: {
    foods() {
      return this.$store.state.foods || false;
    }
  },
  mounted() {
    this.$store.commit("SET_FOODS", "foods");
  }
};
</script>
