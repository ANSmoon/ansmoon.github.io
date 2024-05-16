<template>
<<<<<<< HEAD
  <div>
    <h2>Review view page</h2>
  </div>
</template>

<script setup>

</script>

<style scoped>

=======
  <div class="wrap">
    <div class="video">
      <iframe
        width="560"
        height="315"
        :src="mvstore.movie.link"
        title="YouTube video player"
        frameborder="0"
        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
        referrerpolicy="strict-origin-when-cross-origin"
        allowfullscreen
      ></iframe>
    </div>
    <div class="review-table">
      <table>
        <thead>
          <tr>
            <th>번호</th>
            <th>작성자</th>
            <th>제목</th>
            <th>조회수</th>
            <th>등록날짜</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(review, index) in store.reviewList" :key="review.movie_id">
            <td>{{ index + 1 }}</td>
            <td>{{ review.userId }}</td>
            <td>
              <RouterLink :to="`/movie/${movieId}/review/${review.id}`">{{ review.title }}</RouterLink>
            </td>
            <td>{{ review.viewCnt }}</td>
            <td>{{ review.regDate }}</td>
          </tr>
        </tbody>
      </table>
    </div>
    <button @click="registReview" class="register-btn">등록</button>
  </div>
  <RouterView />
</template>

<script setup>
import { useMovieStore } from "@/stores/movie"
import { useReviewStore } from "@/stores/review";
import { onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";

const route = useRoute();
const router = useRouter();
const movieId = route.params.movieId
const store = useReviewStore();
const mvstore = useMovieStore();

onMounted(() => {
  mvstore.getMovie(movieId);  
  store.getReviewListById(movieId);
});

const registReview = function() {
  router.push({name: 'registReview'})
}
</script>

<style scoped>
.wrap {
  max-width: 60%; 
  margin: 50px auto 0; 
}

.video {
  position: relative;
  width: 100%;
  height: 0; 
  padding-bottom: 56.25%; 
}

.video iframe {
  position: absolute;
  top: 0; 
  left: 0;
  width: 100%; 
  height: 100%; 
} 

.review-table {
  margin-top: 20px;
}

.review-table table {
  width: 100%;
  border-collapse: collapse;
}

.review-table th, .review-table td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

.review-table th {
  background-color: #f2f2f2;
}

.register-btn {
  display: block;
  margin-top: 20px;
  padding: 10px 20px;
  background-color: #3498db;
  color: #ffffff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.register-btn:hover {
  background-color: #2980b9;
}

/* 다크 모드 스타일 */
.wrap.dark-mode {
  background-color: #000000;
  color: #ffffff;
}
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
</style>