<template>
<<<<<<< HEAD
  <div id = "container">
    <RouterLink :to="{name:'movie'}">SSAFIT</RouterLink>
    <div>
      <RouterLink :to="{name:'user'}">로그인</RouterLink> |
      <RouterLink :to="{name:'user'}">회원가입</RouterLink>
=======
  <div id="header">
    <div class="container">
      <div class="logo-container">
        <RouterLink :to="{ name: 'movie' }" class="logo">SSAFIT</RouterLink>
      </div>
      <div class="auth-links">
        <RouterLink :to="{ name: 'user' }" class="link">로그인</RouterLink>
        <div class="divider-group">
          <div class="divider"></div> <!-- 작은 선 추가 -->
        </div>
        <RouterLink :to="{ name: 'user' }" class="link">회원가입</RouterLink>
      </div>
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
    </div>
  </div>
</template>

<script setup>
<<<<<<< HEAD

</script>

<style scoped>
#container{
    text-align: center;
}

</style>
=======
</script>

<style scoped>
#header {
  background-color: #f8f9fa; /* 헤더 배경색 설정 */
}

.container {
  max-width: 1200px; /* 최대 너비 설정 */
  margin: 0 auto; /* 페이지 가운데 정렬 */
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 20px;
}

.logo-container {
  flex: 1; /* 로고 컨테이너가 남은 공간을 차지하도록 설정합니다. */
}

.logo {
  font-size: 24px;
  font-weight: bold;
  color: #333;
  text-decoration: none;
}

.auth-links {
  display: flex;
  align-items: center; /* 로그인 및 회원가입 링크를 세로로 정렬합니다. */
}

.link {
  font-size: 18px;
  color: #555;
  text-decoration: none;
  margin-left: 20px;
}

.link:hover {
  text-decoration: underline;
}

/* 작은 선 스타일 */
.divider-group {
  display: flex;
}

.divider {
  border-left: 1px solid #ccc;
  height: 20px; /* 작은 선의 높이 설정 */
  margin-left: 20px; /* 로그인과 로그아웃 링크 사이의 간격 설정 */
}
</style>
>>>>>>> 2078337045da9b10a8f2f364d482708bbb0f86ec
