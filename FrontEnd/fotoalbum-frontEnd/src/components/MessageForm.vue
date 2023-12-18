<template>
    <div class=" text-center" style="width: 600px;">
        <form @submit.prevent="submit" >
            <div class="mb-3">
               <label for="email" class="form-label">E-mail</label>
               <input type="text" class="form-control" id="email" v-model="newmessage.email">
            </div>
            <div class="form-floating mb-3">
               <textarea class="form-control"  id="content" v-model="newmessage.content"></textarea>
               <label for="text">Lascia un messaggio</label>
            </div>
       
            <button type="submit" class="btn btn-primary">
                Invia
            </button>
            <button type="button" class="btn btn-primary mx-3" @click="$emit('back')">
                Indietro
            </button>
        </form>
    </div>
    
</template>

<script setup>
import {defineEmits, ref} from 'vue';
import axios from 'axios';


const newmessage = ref({
     email: "",
     content: ""
 });

const emits = defineEmits(["back", "created"]);


const submit = async () => {
    
    const data = await axios.post("http://localhost:8080/api/contact", newmessage.value);
        console.log("data" , data);
        emits("created");
        return;
}

</script>
<style>
</style>