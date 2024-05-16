package com.ssafit.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.movie.dto.Review;
import com.ssafit.movie.service.ReviewService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/ssafit")
public class ReviewController {
	private ReviewService reviewService;
	
	@Autowired
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@GetMapping("/reviews/{movieId}")
	public ResponseEntity<List<Review>> reviewList(@PathVariable("movieId") int movieId){
		List<Review> list = reviewService.getListByMovie(movieId);
//		System.out.println(list);
		if(list.isEmpty()) {
			return new ResponseEntity<List<Review>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Review>> (list, HttpStatus.OK);
	}
	
	@GetMapping("/reviews/{movieId}/{id}")
	public ResponseEntity<?> detailReview(@PathVariable("movieId") int movieId, @PathVariable("id") int id){
		Review review = reviewService.getReviewById(movieId, id);
		
		return new ResponseEntity<Review>(review, HttpStatus.OK);
	}
	
	@PostMapping("/reviews/{movieId}")
	public ResponseEntity<?> registReview(@PathVariable("movieId") int movieId, @RequestBody Review review){
		review.setMovieId(movieId);
		reviewService.registReview(review);
		return new ResponseEntity<>(review, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/reviews/{movieId}/{userId}")
	public ResponseEntity<?> modifyReview(HttpSession session, @PathVariable("movieId") int movieId, @PathVariable("userId") String userId, @RequestBody Review review){
//		User nowId = (User) session.getAttribute("loginUser");
		review.setUserId(userId);
		review.setMovieId(movieId);
		
//		if(nowId.getId() == userId) {
			reviewService.modifyReview(review);
			return new ResponseEntity<>(review, HttpStatus.ACCEPTED);
//		}
		
//		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}
	
	@DeleteMapping("reviews/{movieId}/{reviewId}/{userId}")
	public ResponseEntity<?> deleteReview(@PathVariable("movieId") int movieId, @PathVariable("reviewId") int reviewId, @PathVariable("userId") String userId){
//		User nowId = (User) session.getAttribute("loginUser");
		
//		if(nowId.getId() == userId) {
			reviewService.deleteReview(movieId, reviewId, userId);
			return new ResponseEntity<>(HttpStatus.OK);
//		}
	}
	
}
