import { ref, computed } from "vue";
import { defineStore } from "pinia";
<<<<<<< HEAD

export const useReviewStore = defineStore("review", () => {
  

  return {

  };
=======
import axios from "axios";
import router from "@/router";

const REST_SSAFIT_API = `http://localhost:8080/ssafit/reviews`;
export const useReviewStore = defineStore("review", () => {
  const reviewList = ref([]);

  const getReviewListById = function (id) {
    axios.get(`${REST_SSAFIT_API}/${id}`).then((response) => {
      reviewList.value = response.data;
    });
  };

  const review = ref({});

  const getReviewDetail = function (movieId, reviewId) {
    axios.get(`${REST_SSAFIT_API}/${movieId}/${reviewId}`).then((response) => {
      review.value = response.data;
    }).then(() => {
      if(review.value == "") {
        router.push({ name: 'list'})
      }
    })
    
  };

  const updateReview = function (movieId, userId) {
    axios.put(`${REST_SSAFIT_API}/${movieId}/${userId}`, review.value)
    .then(() => {
      console.log(review.value)
      router.push({name: 'detail'})
    });
  };

  const deleteReview = function (movieId, reviewId, userId){
    axios.delete(`${REST_SSAFIT_API}/${movieId}/${reviewId}/${userId}`)
    .then(() => {
      router.push({name: 'list'})
    })    
  }

  const registReview = function (movieId, review) {
    axios.post(`${REST_SSAFIT_API}/${movieId}`, review)
    .then(() => {
      console.log(review.value)
      router.push({name: 'list'})
    })
  }

  return { getReviewListById, reviewList, getReviewDetail, review, updateReview, deleteReview, registReview };
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
});
