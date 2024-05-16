import { ref, computed } from "vue";
import { defineStore } from "pinia";
<<<<<<< HEAD
=======
import { useRouter } from "vue-router";
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
import axios from "axios";

const REST_MOVIE_API = 'http://localhost:8080/ssafit/movie'

export const useMovieStore = defineStore('movie', () => {
<<<<<<< HEAD
  const movieList = ref([])
  const selectedVideo = ref(null)
=======
  const router = useRouter();
  const movieList = ref([])
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec

  const getMovieList = function() {
    axios.get(REST_MOVIE_API)
    .then((response) => {
      movieList.value = response.data
    })
  }

<<<<<<< HEAD
  const clickVideo = function(video){
    selectedVideo.value = video
  }

  return {getMovieList, movieList, clickVideo, selectedVideo};
=======
  const movie = ref({})
  const getMovie = function(id) {
    axios.get(`${REST_MOVIE_API}/${id}`)
    .then((response) => {      
      movie.value = response.data
    })
    .then(() => {
      if(movie.value == ""){        
        router.push({ name: 'movie' })
      }
    })
  }
  

  return {getMovieList, movieList, getMovie, movie};
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
});