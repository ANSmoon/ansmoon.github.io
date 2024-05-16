package com.ssafit.movie.dao;

import java.util.List;

import com.ssafit.movie.dto.Review;

public interface ReviewDao {

	List<Review> selectListByMovie(int movieId);

	Review selectReviewById(int movieId, int id);

	int insertReview(Review review);

	int updateReview(Review review);

	int deleteReview(int movieId, int reviewId, String userId);


}
