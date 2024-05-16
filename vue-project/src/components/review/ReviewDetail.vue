<template>
<<<<<<< HEAD
  <div>
    <h2>Review Detail Page</h2>
=======
  <div class="review-detail">
    <div class="detail-info">
      <div class="title">{{ store.review.title }}</div>
      <div class="user">{{ store.review.userId }}</div>
      <div class="content">{{ store.review.content }}</div>
      <div class="date">{{ store.review.regDate }}</div>
    </div>
    <div class="buttons">
      <button @click="modifyReview" class="modify-btn">수정</button>
      <button @click="deleteReview" class="delete-btn">삭제</button>
    </div>
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
  </div>
</template>

<script setup>
<<<<<<< HEAD

</script>

<style scoped>

</style>
=======
import { useRoute, useRouter } from "vue-router";
import { useReviewStore } from "@/stores/review";
import { onMounted } from "vue";

const route = useRoute();
const router = useRouter();
const store = useReviewStore();

onMounted(() => {
  store.getReviewDetail(route.params.movieId, route.params.reviewId);
});

const modifyReview = function () {
  router.push(
    `/movie/${route.params.movieId}/review/${route.params.reviewId}/update`
  );
};

const deleteReview = function () {
  store.deleteReview(route.params.movieId, route.params.reviewId, store.review.userId);
};
</script>

<style scoped>
.review-detail {
  max-width: 600px;
  margin: auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.detail-info {
  margin-bottom: 20px;
}

.title {
  font-size: 20px;
  font-weight: bold;
  margin-bottom: 10px;
}

.user {
  font-size: 14px;
  color: #777;
  margin-bottom: 5px;
}

.content {
  margin-bottom: 10px;
}

.date {
  font-size: 12px;
  color: #999;
}

.buttons {
  display: flex;
  justify-content: flex-end;
}

.modify-btn,
.delete-btn {
  padding: 8px 16px;
  margin-left: 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.modify-btn {
  background-color: #3498db;
  color: #fff;
}

.delete-btn {
  background-color: #e74c3c;
  color: #fff;
}

.modify-btn:hover,
.delete-btn:hover {
  opacity: 0.8;
}
</style>
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
