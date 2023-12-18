<template>
    <div class="container">
        <div class="row row-cols-1 row-cols-md-3 g-4">
            <div class="col " v-for="image in images" :key="image.id" @click="$emit('openImage', image.id)">
                <div class="card singlecard" style="background-color: rgb(183, 185, 188); width: 280px;">
                    <img :src="image.foto" class="card-img-top" alt="image" style="height: 200px;">
                    <div class="card-body d-flex align-items-center" style="height: 100px;">
                        <h5 class="card-title">
                            {{ image.name }}
                        </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</template>

<script setup>
//IMPORT
import { defineProps} from 'vue';

const emits = defineEmits(["openImage"]);

//PROPS
const props = defineProps( {
    images: {
        type: Array,
        required: true
    }
});
</script>

<style scoped>

*{
	margin: 0 auto;
	box-sizing: border-box;
	padding: 0;
	
}

.container{
	width: 900px;
	margin: 2rem auto;
	margin: auto;
	
}
 .card-container{
	 width: 100%;
	 display: flex;
	
 }

.singlecard{
	
	 width: calc(100% / 3) - 1rem;
	 margin: 2rem;
}

</style>
