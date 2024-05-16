package com.ssafit.movie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafit.movie.dao.ReviewDao;
import com.ssafit.movie.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {
	private ReviewDao reviewDao;
	
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}
	
	@Override
	public List<Review> getListByMovie(int movieId) {
		
		return reviewDao.selectListByMovie(movieId);
	}

	@Override
	public Review getReviewById(int movieId, int id) {
		return reviewDao.selectReviewById(movieId, id);
	}

	@Override
	public int registReview(Review review) {
		return reviewDao.insertReview(review);
	}

	@Override
	public int modifyReview(Review review) {
		System.out.println(review.toString());
		return reviewDao.updateReview(review);
	}

	@Override
	public int deleteReview(int movieId, int reviewId, String userId) {
		return reviewDao.deleteReview(movieId, reviewId, userId);
	}


}
