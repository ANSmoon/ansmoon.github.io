package com.ssafit.movie.service;

import java.util.List;

import com.ssafit.movie.dto.Review;

public interface ReviewService {

	List<Review> getListByMovie(int movieId);

	Review getReviewById(int movieId, int id);

	int registReview(Review review);

	int modifyReview(Review review);

	int deleteReview(int movieId, int reviewId, String userId);


}
