<template>
    <h1 class="text-center">La mia Foto</h1>
    <div class="container d-flex" v-if="image">
       <div class="card m-auto" style="width: 20rem;">
            <button type="button" class="btn-close close-button" data-bs-dismiss="alert" aria-label="Close" @click="$emit('closeImage')"></button>
            <img :src="image.foto" class="card-img-top" alt="...">
            <div class="card-body" style=" background-color: rgb(190, 198, 205)">
                <h5 class="card-title name-linked"> Titolo: {{image.name}}</h5>
                <p class="card-text"><span class="fw-semibold">Descrizione: </span> {{image.description}}</p>
                <div>	
                    <span class="fw-semibold">Categorie: </span>	   
			        <span v-for="category in image.categories">
                        <span>
                         {{ category.name + " ," }}
                        </span>   		         
                    </span> 
	            </div>
           </div>
        </div>
    </div>
</template>

<script setup>
//IMPORT
import { onMounted, ref} from 'vue';
import axios from 'axios';

//PROPS
const props = defineProps({
    image: {
        type: Object,
        required:true
    }
});

//DEFINE CONSTANT
const image = ref(props.image);


//EMITS

const emits = defineEmits(["closeImage"]);

//FUNCTIONS
const showFoto = async(id) => {
    const data = await axios.get(`http://localhost:8080/api/fotoalbum/${id}`)
    image.value = data;
};
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