<template>
  <div class="review-insert">
    <div>
      <fieldset>
        <legend>리뷰 등록</legend>
        <div class="form-group">
          <label for="title">제목 : </label>
          <input type="text" id="title" v-model="review.title" />
        </div>
        <div class="form-group">
          <label for="writer">작성자 : </label>
          <input type="text" id="writer" readonly v-model="review.userId" />
        </div>
        <div class="form-group">
          <label for="content">내용 : </label>
          <textarea id="content" cols="30" rows="10" v-model="review.content"></textarea>
        </div>
        <div class="button-group">
          <button @click="registReview" class="register-btn">등록</button>
          <button @click="cancel" class="cancel-btn">취소</button>
        </div>
      </fieldset>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRoute, useRouter } from "vue-router";
import { useReviewStore } from "@/stores/review";

const store = useReviewStore();
const route = useRoute();

const review = ref({
  userId: "ssafy",
  movieID: route.params.movieId,
  title: '',
  content: '',
})

const registReview = function () {
  store.registReview(route.params.movieId, review.value);
};

const cancel = function () {
  // 취소 동작 정의
};

</script>

<style scoped>
.review-insert {
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

button.register-btn {
  padding: 8px 16px;
  background-color: #3498db;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button.cancel-btn {
  padding: 8px 16px;
  background-color: #ddd;
  color: #333;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

button {
  margin-left: 10px;
}

button.register-btn:hover, button.cancel-btn:hover {
  opacity: 0.8;
}
</style>
