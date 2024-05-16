<template>
<<<<<<< HEAD
  <div>
    <h2>Movie View</h2>
    <hr />
    <div class="thumbnails">
      <div v-for="movie in store.movieList" :key="movie.id" class="thumbnail">
        <RouterLink :to="`/movie/${movie.id}`">
          <!-- 영상 재생 iframe -->
          <iframe width="600" height="300"
=======
  <div class="page-container dark-mode">
    <div class="thumbnails">
      <div v-for="movie in store.movieList" :key="movie.id" class="thumbnail">
        <RouterLink :to="`/movie/${movie.id}`" class="link">
          <!-- 영상 재생 iframe -->
          <iframe width="450" height="250"
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
            :src="movie.link"
            title="Video Player"
            class="video-player"
            frameborder="0"
            allowfullscreen
          ></iframe>
          <p class="title">{{ truncateTitle(movie.title) }}</p>
<<<<<<< HEAD
=======
          <div class="channelName">{{ movie.channelName }}</div>
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
        </RouterLink>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useMovieStore } from "@/stores/movie";
import { onMounted } from "vue";

const store = useMovieStore();
onMounted(() => {
  store.getMovieList();
});

function truncateTitle(title) {
  // 일정 길이 이상인 경우 ...으로 표시
<<<<<<< HEAD
  const maxLength = 20;
=======
  const maxLength = 30;
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
  if (title.length > maxLength) {
    return title.substring(0, maxLength) + "...";
  }
  return title;
}
</script>

<style scoped>
<<<<<<< HEAD

</style>
=======
/* 다크모드 설정 */
.dark-mode {
  background-color: #000000;
  color: #ffffff;
}

/* 페이지 컨테이너 스타일 */
.page-container {
  display: flex;
  justify-content: center; /* 페이지를 가운데에 위치시킵니다. */
  padding-left: 13.5%;
  padding-right: 10%;
  padding-top: 5%;
  padding-bottom: 10%;
}

/* 썸네일 컨테이너 스타일 */
.thumbnails {
  display: flex;
  flex-wrap: wrap;
  gap: 30px;
  justify-content: left; /* 맨 왼쪽부터 정렬 */
}

/* 각 썸네일 스타일 */
.thumbnail {
  width: 450px;
  border: 1px solid #333; /* 테두리 색상 변경 */
  border-radius: 5px;
  overflow: hidden;
}

/* 영상 플레이어 스타일 */
.video-player {
  width: 100%;
  height: 250px;
}

/* 영상 타이틀 스타일 */
.title {
  font-size: 16px;
  font-weight: bold;
  margin: 10px;
}

/* 채널명 스타일 */
.channelName {
  font-size: 14px;
  color: #ccc; /* 회색 톤의 색상 */
  margin: 5px 10px;
}

/* 링크 스타일 */
.link {
  color: #ffffff; /* 링크 색상을 흰색으로 설정 */
  text-decoration: none; /* 밑줄 제거 */
}

.link:hover {
  color: aquamarine; /* 클릭 시 색상을 빨간색으로 변경 */
}
</style>
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
