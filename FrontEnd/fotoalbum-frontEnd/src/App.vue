<template>
  <div class="container">
    <div class="d-flex justify-content-center ">
      <form v-if="!creatingMessage && activeImage == null" @submit.prevent="getImageByTitle"  class="d-flex" role="search" style="width: 650px;">
        <input class="form-control me-2" type="text" query="name" aria-label="Search" v-model="titleToSearch">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      <button v-if="!creatingMessage && activeImage == null" @click="creatingMessage = true" class="mx-2 btn btn-outline-success">
        Contattaci
      </button>
      <a href="http://localhost:8080/loginORegistration" class="mx-2 btn btn-outline-success">
             Accedi 
      </a>
    </div>
    
    <message-form
      v-if="creatingMessage"
      @back = "creatingMessage = false"
      @created="createdMessage"
    />

    <div v-else> 
      <foto-index
      v-if="activeImage == null"
      :userProfiles="userProfiles"
      @openImage="showImage"
      />

      <show-foto
      v-else
       :userProfile="activeImage"
        @closeImage="closeImage"
      />

    </div>
  </div>
 
</template>

<script setup>
//IMPORT
import { onMounted, ref } from 'vue';
import axios from 'axios';

import FotoIndex from './components/FotoIndex.vue';
import ShowFoto from './components/ShowFoto.vue';
import MessageForm from './components/MessageForm.vue';
// DEFINE CONSTANT
 const userProfiles = ref(null);
 const activeImage = ref(null);
 const titleToSearch = ref('');
 const creatingMessage= ref(false);


// FUNCTIONS


const showImage = (id) => {
  userProfiles.value.forEach((userProfile) => {

    if(userProfile.id == id) {
      activeImage.value = userProfile;
    }
    
  });
}

const closeImage = (update) => {
  activeImage.value = null;
  if(update) updateImage();
}

const createdMessage = () => {
  creatingMessage.value = false;
  updateImage();
}

const updateImage = async () => {
  const data = await axios.get("http://localhost:8080/api/profiles");
  userProfiles.value = data.data;
};

const getImageByTitle = async() => {
  let params = "";
  if(titleToSearch .value != null) {
    params = "?query=" + titleToSearch.value;

    const data = await axios.get("http://localhost:8080/api/fotoalbum" + params);
    images.value = data.data;
  }
}


onMounted(updateImage);
</script>

<style >
.container{
width: 900px;
  margin: 1rem auto;
}



</style>
