package com.ssafit.movie.service;

import java.util.List;

import com.ssafit.movie.dto.Movie;

public interface MovieService{
	// 모든 영상 정보 반환 method
	public List<Movie> getMovieList();

	// 모든 영상 조회수 순으로 반환 method
	public List<Movie> sortList();

	// 특정 영상 반환 method
	public Movie searchMovie(int id);

	// 특정 부위별로 영상 반환 method
	public List<Movie> categoryList(String category);

	// 최고 조회수 영상 반환 method
	public List<Movie> highViewList();
}