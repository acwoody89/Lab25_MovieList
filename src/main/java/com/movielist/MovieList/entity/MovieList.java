package com.movielist.MovieList.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieList {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String category;
	
	public MovieList() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "MovieList [id=" + id + ", title=" + title + ", category=" + category + "]";
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
