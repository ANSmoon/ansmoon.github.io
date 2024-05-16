package com.ssafit.movie.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafit.movie.dto.Movie;
import com.ssafit.movie.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/ssafit")
@Tag(name = "MovieRestController", description = "영상 목록화(author : ANSMOON)")
public class MovieController {
	private final MovieService movieService;
	
	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	// 영상 전체 정보 조회
	@GetMapping("/movie")
	@Operation(summary = "모든 영상 정보 반환", description = "모든 영상 정보를 반환합니다.")
	public ResponseEntity<?> list(){
		List<Movie> list = movieService.getMovieList();
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
	}
	
	// 특정 영상 정보 조회
	@GetMapping("/movie/{id}")
	@Operation(summary = "Id가 일치하는 영상 정보 반환", description = "특정 영상의 정보를 반환합니다.")
	public ResponseEntity<Movie> search(@PathVariable("id") int id){
		System.out.println(id);
		Movie movie = movieService.searchMovie(id);
		System.out.println(movie);
		return new ResponseEntity<Movie>(movie, HttpStatus.OK);
	}

	// 영상 조회순 정보 조회
	@GetMapping("/movie/sort")
	@Operation(summary = "영상들 조회수 순으로 나열", description = "모든 영상들을 조회수 순으로 나타냅니다.")
	public ResponseEntity<?> viewCntDecrease(){
		List<Movie> list = movieService.sortList();
			if(list == null || list.size() == 0) {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
	}
	
	// 영상 운동 부위별 정보 조회
	@GetMapping("/movie/category/{category}")
	@Operation(summary = "영상들을 운동 부위별로 분류", description = "특정 부위에 해당하는 운동 영상들을 출력합니다.")
	public ResponseEntity<?> section(@PathVariable("category") String category){
		List<Movie> list = movieService.categoryList(category);
		if(list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Movie>>(list, HttpStatus.OK);
	}
	
	// 영상 최고 조회수 정보 조회
	@GetMapping("/movie/highView")
	@Operation(summary = "최고 조회수 영상 정보 반환", description = "가장 높은 조회수의 영상을 출력합니다.")
	public ResponseEntity<?> highView(){
		List<Movie> list = movieService.highViewList();
		return new ResponseEntity<List<Movie>>(list,HttpStatus.OK);
	}
}