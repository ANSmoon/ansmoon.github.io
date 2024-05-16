<template>
  <div class="review-edit">
    <div>
      <fieldset>
        <legend>리뷰 수정</legend>
        <div class="form-group">
          <label for="title">제목 : </label>
          <input type="text" id="title" v-model="store.review.title" />
        </div>
        <div class="form-group">
          <label for="writer">작성자 : </label>
          <input type="text" id="writer" readonly v-model="store.review.userId" />
        </div>
        <div class="form-group">
          <label for="content">내용 : </label>
          <textarea id="content" cols="30" rows="10" v-model="store.review.content"></textarea>
        </div>
        <div class="button-group">
          <button @click="updateBoard" class="save-btn">저장</button>
        </div>
      </fieldset>
    </div>
  </div>
</template>

<script setup>
import { useRoute } from "vue-router";
import { useReviewStore } from "@/stores/review";
import { onMounted } from "vue";

const store = useReviewStore();
const route = useRoute();

const updateBoard = function () {
  store.updateReview(route.params.movieId, store.review.userId);
};

onMounted(() => {
  store.getReviewDetail(route.params.movieId, route.params.reviewId);
});
</script>

<style scoped>
.review-edit {
  max-width: 600px;
  margin: auto;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

fieldset {
  border: 1px solid #ddd;
  border-radius: 5px;
  padding: 20px;
}

legend {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 10px;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input[type="text"],
textarea {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 5px;
}

textarea {
  resize: vertical;
}

.button-group {
  text-align: right;
}

button.save-btn {
  padding: 8px 16px;
  background-color: #3498db;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button.save-btn:hover {
  opacity: 0.8;
}
</style>
