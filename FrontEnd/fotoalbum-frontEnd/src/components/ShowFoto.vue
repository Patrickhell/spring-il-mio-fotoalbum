<template>
    <div class="d-flex justify-content-between mt-5">
	  <div class="d-flex align-items-center mb-5">
        <img :src="userProfile.imageProfile" class="card-img-top" alt="..." style="width: 
			 60px; height: 60px; border-radius: 50%;">
          <div class="dropdown mx-4">
            <button class="btn btn-info dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
               Il mio profilo
            </button>
            <ul >
              <li ><p >id: {{userProfile.id}}</p></li>
              <li ><p >Nome: {{userProfile.name}}</p></li>
              <li><p> E-mail: {{userProfile.email}}</p></li>
              <li><p>Cellulare: {{userProfile.phoneNumber}}</p></li>
            </ul>
          </div>
	  </div>
	</div>
    <div class="container d-flex" v-if="userProfile">
        <div v-for="image in userProfile.images">
            <div class="card m-auto g-1 mx-2" style="width: 15rem;">
                <button type="button" class="btn-close close-button" data-bs-dismiss="alert" aria-label="Close" @click="$emit('closeImage')"></button>
                <img :src="image.foto" class="card-img-top" alt="..." style="height: 150px;">
                <div class="card-body" style=" background-color: rgb(190, 198, 205); height: 200px;" >
                    <h5 class="card-title n"> Nome: {{image.name}}</h5>
                    <p class="card-text"><span class="fw-semibold"> Descrizione: </span> {{image.description}}</p>
                </div>
            </div>
        </div>
    </div>

    <message-form
      @created="createdMessage"
      :id="userProfile.id"
      
    />
    <button  @click="creatingMessage = true" class="mx-2 btn btn-outline-success">
        Contattaci
    </button>
    
</template>

<script setup>
//IMPORT
import { onMounted, ref} from 'vue';
import axios from 'axios';
import MessageForm from './MessageForm.vue';

const creatingMessage= ref(false);


//PROPS
const props = defineProps({
    userProfile: {
        type: Object,
        required:true
    }
});


//DEFINE CONSTANT
const userProfile = ref(props.userProfile);


//EMITS

const emits = defineEmits(["closeImage"]);

//FUNCTIONS
const showFoto = async(id) => {
    const data = await axios.get(`http://localhost:8080/api/profiles/${id}`)
    userProfile.value = data;
};

const createdMessage = () => {
  creatingMessage.value = false;
}

onMounted(showFoto);
</script>

<style scoped>
.close-button, .name-linked{
  cursor: pointer;
}
.container{
	width: 900px;
    margin: 4rem auto
	
}
</style>