package com.movielist.MovieList.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.movielist.MovieList.entity.MovieList;

public interface MovieRepository extends JpaRepository<MovieList, Integer>{
	
	@Query("SELECT DISTINCT category FROM MovieList")
	List<MovieList> findAllCat();
	
	
	List<MovieList> findByTitle(String keyword);
	List<MovieList> findById(int keyword);
	List<MovieList> findByIdContaining(int keyword);
	List<MovieList> findByCategoryContaining(String keyword);
	List<MovieList> findByCategory(String keyword);
	List<MovieList> findByTitleContaining(String keyword);
}
