package com.ssafit.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafit.movie.dao.MovieDao;
import com.ssafit.movie.dto.Movie;

@Service
public class MovieServiceImpl implements MovieService {

	private final MovieDao movieDao;
	
	@Autowired
	public MovieServiceImpl(MovieDao movieDao) {
		this.movieDao = movieDao;
	}
	
	@Override
	public List<Movie> getMovieList() {
		return movieDao.selectAll();
	}

	@Override
	public List<Movie> sortList() {
		return movieDao.sortedAll();
	}

	@Override
	public Movie searchMovie(int id) {
		movieDao.updateViewCnt(id);
		return movieDao.searchMovie(id);
	}

	@Override
	public List<Movie> categoryList(String category) {
		return movieDao.sectionAll(category);
	}

	@Override
	public List<Movie> highViewList() {
		return movieDao.selectionBest();
	}
}