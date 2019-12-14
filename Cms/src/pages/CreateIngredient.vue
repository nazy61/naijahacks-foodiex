<template>
  <div class=" text-center">
    <q-tabs
      v-model="tab"
      class="bg-grey-3 text-grey-7"
      active-color="primary"
      indicator-color="primary"
      align="justify"
    >
      <q-tab name="create-ingredient" label="Create Ingredients" />
      <q-tab name="ingredients" label="ingredients" />
    </q-tabs>

    <q-tab-panels v-model="tab" animated>
      <q-tab-panel name="create-ingredient">
        <h4>Create Ingredient</h4>
        <p class="text-center q-pa-md text-grey">
          Adds an ingredient node to be binded in the creation of a food in
          firebase, each ingredient should start with a new line instead of a
          comma
        </p>
        <q-form class="q-gutter-md">
          <div>
            <q-input
              v-model.trim="names"
              type="textarea"
              filled
              label="Ingredient Name"
            />
            <br />
            <q-btn
              @click="createIngredient"
              label="create ingredient"
              icon="add"
              rounded
              type="submit"
              color="primary"
            />
          </div>
        </q-form>
      </q-tab-panel>

      <q-tab-panel name="ingredients">
        <h4>Ingredients</h4>
        <q-markup-table flat>
          <thead>
            <tr>
              <th class="text-left">Id</th>
              <th class="text-right">Name</th>
              <th class="text-right">Action</th>
              <!-- <th class="text-right">Action</th> -->
            </tr>
          </thead>
          <tbody>
            <tr v-for="(ingr, i) in ingredients" :key="i">
              <td class="text-left">{{ i }}</td>
              <td class="text-right">{{ ingr.name }}</td>
              <td class="text-right">
                <q-btn
                  flat
                  round
                  color="red"
                  icon="mdi-close"
                  @click="deleteIngredient(i)"
                />
              </td>
            </tr>
          </tbody>
        </q-markup-table>
      </q-tab-panel>
    </q-tab-panels>
  </div>
</template>

<script>
export default {
  data() {
    return {
      names: [],
      tab: "create-ingredient"
    };
  },
  computed: {
    ingredients() {
      return this.$store.state.ingredients;
    }
  },
  mounted() {
    this.$store.commit("GET_ALL_INGREDIENTS");
  },
  methods: {
    deleteIngredient(ingredientId) {
      this.$store.dispatch("deleteIngredient", ingredientId);
    },
    createIngredient() {
      let names = new Set([...this.names.split("\n")]);
      names.forEach(name => {
        name = name.replace(/^\w/, c => c.toUpperCase());
        this.$store.dispatch("createIngredient", name);
      });
    }
  }
};
</script>
