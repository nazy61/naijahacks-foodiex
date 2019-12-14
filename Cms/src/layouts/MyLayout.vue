<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          @click="leftDrawerOpen = !leftDrawerOpen"
          icon="menu"
          aria-label="Menu"
        />

        <q-toolbar-title>
          Foodiex
        </q-toolbar-title>
      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
      content-class="bg-grey-2"
    >
      <q-list>
        <q-item-label header>Essential Links</q-item-label>
        <q-item clickable tag="a" to="/foods">
          <q-item-section avatar>
            <q-icon name="school" />
          </q-item-section>
          <q-item-section>
            <q-item-label>Foods</q-item-label>
            <q-item-label caption>list all foods in store</q-item-label>
          </q-item-section>
        </q-item>
        <q-item clickable tag="a" to="/create-food">
          <q-item-section avatar>
            <q-icon name="code" />
          </q-item-section>
          <q-item-section>
            <q-item-label>Create food</q-item-label>
            <q-item-label caption>Adds a food to store</q-item-label>
          </q-item-section>
        </q-item>
        <q-item clickable tag="a" to="/create-ingredient">
          <q-item-section avatar>
            <q-icon name="mdi-cog-counterclockwise" />
          </q-item-section>
          <q-item-section>
            <q-item-label>Ingredients</q-item-label>
            <q-item-label caption
              >Adds or reviews Ingredients to firebase</q-item-label
            >
          </q-item-section>
        </q-item>
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
export default {
  name: "MyLayout",

  data() {
    return {
      leftDrawerOpen: false
    };
  }
};
</script>
