<template>
  <div class="q-pa-md">
    <h5>Add a food item</h5>
    <q-form class="q-gutter-md">
      <q-input v-model="title" type="text" label="Food Title" filled />
      <q-select v-model="tribe" :options="options" label="Tribe" filled />
      <q-input v-model="benefits" type="textarea" label="Benefits" filled />

      <q-uploader
        @added="startUploading"
        flat
        bordered
        v-model="imageUrl"
        style="width: 100%"
      />

      <q-select
        v-model="ingredients"
        :options="ingredientOptions"
        label="Ingredients"
        emit-value
        map-options
        multiple
        filled
      />

      <q-input
        label="Preparation Time"
        filled
        v-model="preparationTime"
        mask="time"
        :rules="['time']"
      >
        <template v-slot:append>
          <q-icon name="access_time" class="cursor-pointer">
            <q-popup-proxy transition-show="scale" transition-hide="scale">
              <q-time v-model="preparationTime" />
            </q-popup-proxy>
          </q-icon>
        </template>
      </q-input>

      <q-toggle label="Is Favorite" v-model="isFavorite" color="primary" />
      <br />
      <br />
      <q-btn
        rounded
        icon="mdi-plus"
        @click="addFoodItem"
        label="Add food item"
        type="submit"
        color="primary"
        filled
      />
    </q-form>
  </div>
</template>

<script>
import { db } from "../../.db";
export default {
  data() {
    return {
      foods: [],
      options: ["Igbo", "Yoroba", "Hausa"],
      // ...
      title: "",
      tribe: "",
      ingredients: [],
      benefits: "",
      imageUrl: "",
      preparationTime: "10:56",
      isFavorite: true
    };
  },

  computed: {
    ingredientOptions() {
      let ingredients = [];
      let ingre = this.$store.state.ingredients;
      for (let ing in ingre) {
        ingredients.push({
          value: ing,
          label: ingre[ing]["name"]
        });
      }
      return ingredients;
    }
  },
  methods: {
    startUploading(file) {
      file = file[0];
      this.imageUrl = file.__img.currentSrc;
    },
    addFoodItem() {
      var foodItem = {
        title: this.title,
        tribe: this.tribe,
        benefits: this.benefits,
        imageUrl: this.imageUrl,
        preparationTime: this.preparationTime,
        isFavorite: this.isFavorite,
        ingredients: this.ingredients
      };
      this.$store.dispatch("createFood", foodItem);
    }
  }
};
</script>
