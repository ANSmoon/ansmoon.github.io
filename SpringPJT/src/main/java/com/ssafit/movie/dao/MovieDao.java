package com.ssafit.movie.dao;

import java.util.List;

import com.ssafit.movie.dto.Movie;

public interface MovieDao {
	// 모든 영화 정보 반환 SQL 문
	public List<Movie> selectAll();

	// 높은 조회수 순으로 정렬한 SQL문
	public List<Movie> sortedAll();
	
	// 영상 조회수를 갱신하는 SQL 문
	public void updateViewCnt(int id);

	// 특정 영상을 찾는 SQL 문
	public Movie searchMovie(int id);

	public List<Movie> sectionAll(String category);

	public List<Movie> selectionBest();
}