import firebase from "firebase/app";
import "firebase/database";
import "firebase/storage";

var firebaseConfig = {
  apiKey: "AIzaSyCJf65P0gU8pCZw6cZ11GFNnAp-fkpzf3A",
  authDomain: "project-id.firebaseapp.com",
  databaseURL: "https://foodiex-dc12a.firebaseio.com",
  projectId: "foodiex-dc12a",
  storageBucket: "foodiex-dc12a.appspot.com",
  messagingSenderId: "sender-id",
  appId: "app-id",
  measurementId: "G-measurement-id"
  // ...
};

// Get a Firestore instance
export const db = firebase.initializeApp(firebaseConfig).database();

// Create a root storage reference
export const storageRef = firebase.storage().ref();
