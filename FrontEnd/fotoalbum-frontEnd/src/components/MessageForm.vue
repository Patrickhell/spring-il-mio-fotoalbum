<template>
    <div style="width: 600px;">
        <div v-if="messageSent" >
            <div class="alert alert-success d-flex align-items-center alert-dismissible fade show" role="alert">
                <svg class="flex-shrink-0 w-4 h-4" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 20 20" style="width: 20px; height: 20px; border-radius: 50%;">
                    <path d="M10 .5a9.5 9.5 0 1 0 9.5 9.5A9.51 9.51 0 0 0 10 .5ZM9.5 4a1.5 1.5 0 1 1 0 3 1.5 1.5 0 0 1 0-3ZM12 15H8a1 1 0 0 1 0-2h1v-3H8a1 1 0 0 1 0-2h2a1 1 0 0 1 1 1v4h1a1 1 0 0 1 0 2Z"/>
                </svg>                
                <div class="mx-1">
                    Messaggio inviato con Successo!
                </div>
            </div>
        </div>
        <form @submit.prevent="submit" @reset.prevent="clearMessageForm" >
            <div class="mb-3">
               <label for="name" class="form-label">Nome</label>
               <input type="text" class="form-control" id="name" v-model="newmessage.name">
            </div>
            <div class="mb-3">
               <label for="email" class="form-label">E-mail</label>
               <input type="text" class="form-control" id="email" v-model="newmessage.email">
            </div>
            <div class="form-floating mb-3">
               <textarea class="form-control"  id="content" v-model="newmessage.content"></textarea>
               <label for="text">Lascia un messaggio</label>
            </div>
       
            <button type="submit" class="btn btn-primary mb-3">
                Invia
            </button>
            <button type="button" class="btn btn-primary mx-3 mb-3" @click="$emit('back')">
                Indietro
            </button>
        </form>
        
    </div>
</template>

<script setup>
import {defineEmits, ref, onMounted, defineProps } from 'vue';
import axios from 'axios';

const props = defineProps({
    id: {
        type: Object,
        required:true
    }
});

const messageSent = ref(false);
const newmessage = ref({
    profileId: props.id,
     name: "",
     email: "",
     content: ""
 });
 console.log(props.id);

const emits = defineEmits(["back", "created"]);


const submit = async () => {
    try {
    const data = await axios.post("http://localhost:8080/api/contact", newmessage.value);
        console.log("data" , data);
        emits("created");
        clearMessageForm();
        messageSent.value = true;
        setTimeout(() => {
          messageSent.value = false;
        }, 5000);
        newmessage.value = {
            profileId: props.id,
            name: "",
            email: "",
            content: ""
        }; 
    } catch (error) {
        console.error("Errore durante l'invio del messaggio :", error);
    }
}

const clearMessageForm = () => {
    newmessage.value =  {
        profileId: '',
        name: "",
        email: "",
        content: ""
    }; 
};




</script>
<style>
</style>