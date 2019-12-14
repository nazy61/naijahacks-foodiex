// WARNING: THIS STORE IS HIGHLY NOT OPTIMIZED
//  .. MEMORY MAY FAIL!

import Vue from "vue";
import Vuex from "vuex";

import { Loading, Notify } from "quasar";

Vue.use(Vuex);

import { db, storageRef } from "../../.db";

function kebab(str) {
  var filename = str.replace(/ /gi, "-");
  return filename.toLowerCase();
}

export default function(/* { ssrContext } */) {
  const Store = new Vuex.Store({
    state: {
      food: {},
      foods: [],
      ingredients: []
    },
    mutations: {
      // gets and sets all ingredients
      GET_ALL_INGREDIENTS(state) {
        db.ref("ingredients").once("value", snapshot => {
          const ingredients = snapshot.val();
          state.ingredients = ingredients;
        });
      },
      SET_FOODS(state, foods) {
        db.ref(foods).once("value", snapshot => {
          const documents = snapshot.val();
          state.foods = documents;
        });
      },
      SET_A_FOOD(state, food) {
        state.food = food;
      },
      SET_FOOD(state, food) {
        state.foods.push(food);
      }
    },
    actions: {
      // ..
      deleteIngredient({ state }, ingredientId) {
        Loading.show();
        // state.ingredients.splice(state.ingredients[ingredientId], 0);
        db.ref("ingredients/" + ingredientId)
          .remove()
          .then(done => {
            Loading.hide();
            this.$router.push("/foods");
          });
      },
      // ..
      createIngredient({}, ingredientName) {
        db.ref("ingredients")
          .push({ name: ingredientName })
          .then(() => {
            Notify.create(`Created ${ingredientName}...`);
          });
      },
      // ..
      deleteFood({}, foodId) {
        let that = this;
        Loading.show();
        db.ref("foods/" + foodId)
          .remove()
          .then(done => {
            Loading.hide();
            that.$router.push("/foods");
          });
      },
      // ..
      getFood({ commit, state }, foodId) {
        Loading.show();
        try {
          db.ref("foods/" + foodId).once("value", snapshot => {
            const food = snapshot.val();
            // do something with food
            commit("SET_A_FOOD", food);
            Loading.hide();
          });
        } catch (e) {
          commit("SET_A_FOOD", state.foods[foodId]);
          Loading.hide();
        }
      },
      // ..
      createFood({ state }, payload) {
        Loading.show();
        var { imageUrl, title } = payload;
        storageRef
          .child(kebab(title))
          .putString(imageUrl, "data_url")
          .then(snapshot => snapshot.ref.getDownloadURL())
          .then(imageUrl => {
            db.ref("foods")
              .push(
                Object.assign(payload, {
                  imageUrl
                })
              )
              .then(() => {
                Loading.hide();
                this.$router.push({ path: "/foods" });
              });
          });
        // show the loader
      }
    }
  });

  return Store;
}
