CREATE DATABASE IF NOT EXISTS ssafit DEFAULT CHARACTER SET utf8mb4;

USE ssafit;

CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    link VARCHAR(255) NOT NULL,
    channel_name VARCHAR(255) NOT NULL,
    view_cnt INT DEFAULT 0,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS users (
    id VARCHAR(20) NOT NULL,
    password VARCHAR(50) NOT NULL,
    nickname VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS reviews (
	id INT AUTO_INCREMENT,
    user_id VARCHAR(20) NOT NULL,
    movie_id INT NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT,
    view_cnt INT DEFAULT 0,
    reg_date TIMESTAMP DEFAULT now(),
    PRIMARY KEY(id),
    FOREIGN KEY (user_id) REFERENCES `users` (id),
    FOREIGN KEY (movie_id) REFERENCES `movies` (id)
);

INSERT INTO movies (title, link, channel_name, category)
SELECT * FROM (
    SELECT '전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]', 'https://www.youtube.com/embed/gMaB-fG4u4g', 'ThankyouBUBU', '전신'
) AS tmp
WHERE NOT EXISTS (
    SELECT id FROM movies WHERE link = 'https://www.youtube.com/embed/gMaB-fG4u4g'
) LIMIT 1;

INSERT INTO movies (title, link, channel_name, category)
SELECT * FROM (
    SELECT '하루 15분! 전신 칼로리 불태우는 다이어트 운동', 'https://www.youtube.com/embed/swRNeYw1JkY', 'ThankyouBUBU', '전신'
) AS tmp
WHERE NOT EXISTS (
    SELECT id FROM movies WHERE link = 'https://www.youtube.com/embed/swRNeYw1JkY'
) LIMIT 1;

INSERT INTO movies (title, link, channel_name, category)
SELECT * FROM (
    SELECT '상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]', 'https://www.youtube.com/embed/54tTYO-vU2E', 'ThankyouBUBU', '상체'
) AS tmp
WHERE NOT EXISTS (
    SELECT id FROM movies WHERE link = 'https://www.youtube.com/embed/54tTYO-vU2E'
) LIMIT 1;

INSERT INTO movies (title, link, channel_name, category)
SELECT * FROM (
    SELECT '상체비만 다이어트 최고의 운동 [상체 핵매운맛]', 'https://www.youtube.com/embed/QqqZH3j_vH0', 'ThankyouBUBU', '상체'
) AS tmp
WHERE NOT EXISTS (
    SELECT id FROM movies WHERE link = 'https://www.youtube.com/embed/QqqZH3j_vH0'
) LIMIT 1;

INSERT INTO movies (title, link, channel_name, category)
SELECT * FROM (
    SELECT '하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]', 'https://www.youtube.com/embed/tzN6ypk6Sps', '김강민', '하체'
) AS tmp
WHERE NOT EXISTS (
    SELECT id FROM movies WHERE link = 'https://www.youtube.com/embed/tzN6ypk6Sps'
) LIMIT 1;

INSERT INTO movies (title, link, channel_name, category)
SELECT * FROM (
    SELECT '저는 하체 식주의자 입니다', 'https://www.youtube.com/embed/u5OgcZdNbMo', 'GYM종국', '하체'
) AS tmp
WHERE NOT EXISTS (
    SELECT id FROM movies WHERE link = 'https://www.youtube.com/embed/u5OgcZdNbMo'
) LIMIT 1;

INSERT INTO movies (title, link, channel_name, category)
SELECT * FROM (
    SELECT '11자복근 복부 최고의 운동 [복근 핵매운맛]', 'https://www.youtube.com/embed/PjGcOP-TQPE', 'ThankyouBUBU', '복부'
) AS tmp
WHERE NOT EXISTS (
    SELECT id FROM movies WHERE link = 'https://www.youtube.com/embed/PjGcOP-TQPE'
) LIMIT 1;

INSERT INTO movies (title, link, channel_name, category)
SELECT * FROM (
    SELECT '(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)', 'https://www.youtube.com/embed/7TLk7pscICk', 'SomiFit', '복부'
) AS tmp
WHERE NOT EXISTS (
    SELECT id FROM movies WHERE link = 'https://www.youtube.com/embed/7TLk7pscICk'
) LIMIT 1;

-- User 삽입
INSERT INTO users (id, password, nickname, email)
SELECT * FROM (
    SELECT "ssafy", "password123", "싸피", "ssafy@example.com"
) AS tmp
WHERE NOT EXISTS (
    SELECT * FROM users WHERE id = "ssafy"
);

INSERT INTO users (id, password, nickname, email)
SELECT * FROM (
    SELECT "김태한", "1226", "KTH", "KTH@ssafy.com"
) AS tmp
WHERE NOT EXISTS (
    SELECT * FROM users WHERE id = "김태한"
);

-- 리뷰 삽입
INSERT INTO reviews (user_id, movie_id, title, content)
SELECT * FROM (
    SELECT "ssafy", "1", "좋은 영상인거지요", "양띵균쌤이지롱"
) AS tmp
WHERE NOT EXISTS (
    SELECT * FROM reviews 
    WHERE user_id = "ssafy"
);

INSERT INTO reviews (user_id, movie_id, title, content)
SELECT * FROM (
    SELECT "김태한", "2", "좋은 영상인거지라", "문범수는 고수인 것인가"
) AS tmp
WHERE NOT EXISTS (
    SELECT * FROM reviews 
    WHERE user_id = "김태한"
);

-- 영화 테이블 확인
SELECT * FROM movies;
SELECT * FROM users;
SELECT * FROM reviews;