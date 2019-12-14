import { firestorePlugin } from "vuefire";
export default async ({ app, router, Vue }) => {
  Vue.use(firestorePlugin);
};
