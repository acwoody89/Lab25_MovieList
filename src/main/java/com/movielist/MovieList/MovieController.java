package com.movielist.MovieList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.movielist.MovieList.dao.MovieRepository;
import com.movielist.MovieList.entity.MovieList;

@RestController
public class MovieController {
	@Autowired
	MovieRepository movieRepo;
	
	@GetMapping("/")
	public List<MovieList> listAll() {
		
		return movieRepo.findAll();
	}
	
	@GetMapping("/category/{category}")
	public List<MovieList> distinctCategory(@PathVariable ("category") String c) {
		
		return movieRepo.findByCategory(c);
	}
	
	@GetMapping("/randommovie/")
	public List<MovieList> randomMovie() {
		List<MovieList> list = movieRepo.findAll();
		Random r = new Random();
		int num = r.nextInt(list.size());
		if(num==0) {
			num++;
		}
		return movieRepo.findById(num);
	}
	
	@GetMapping("/randommoviecat/{category}")
	public MovieList randomMovieAndCategory(@PathVariable ("category") String c) {
		List<MovieList> list = movieRepo.findByCategory(c);
		
		int num = (int)(Math.random() * list.size());
		return list.get(num);
	}
	
	@GetMapping("/randomquantMovie/{num}")
	public List<MovieList> randomQuantMovie(@PathVariable ("num") int n) {
		List<MovieList> list = movieRepo.findAll();
		List<MovieList> list2 = new ArrayList<MovieList>();
		for (int i = 0; i < n; i++) {
			int num = (int)(Math.random() * list.size());
			list2.addAll(movieRepo.findById(num));
		}
		int num = (int)(Math.random() * list.size());
		
		return list2;
	}
	
	@GetMapping("/getcategory")
	public List<MovieList> getCategory() {
		List<MovieList> list = movieRepo.findAllCat();
		
		return list;
	}
	
	@GetMapping("/getmovie/{title}")
	public List<MovieList> getMovie(@PathVariable("title") String t) {
		List<MovieList> list = movieRepo.findByTitle(t);
		
		return list;
	}
	
	@GetMapping("/getmoviekey/{title}")
	public List<MovieList> getMovieKey(@PathVariable("title") String t) {
		List<MovieList> list = movieRepo.findByTitleContaining(t);
		
		return list;
	}
}
