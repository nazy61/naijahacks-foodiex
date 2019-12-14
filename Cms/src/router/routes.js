const routes = [
  {
    path: "/",
    component: () => import("layouts/MyLayout.vue"),
    children: [
      { path: "", component: () => import("pages/Index.vue") },
      { path: "/create-food", component: () => import("pages/CreateFood.vue") },
      { path: "/foods", component: () => import("pages/Foods.vue") },
      { path: "/food/:id", component: () => import("pages/_Food.vue") },
      {
        path: "/create-ingredient",
        component: () => import("pages/CreateIngredient.vue")
      }
    ]
  }
];

// Always leave this as last one
if (process.env.MODE !== "ssr") {
  routes.push({
    path: "*",
    component: () => import("pages/Error404.vue")
  });
}

export default routes;
