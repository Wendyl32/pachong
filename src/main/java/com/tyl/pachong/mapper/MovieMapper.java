package com.tyl.pachong.mapper;

import com.tyl.pachong.model.Movie;

import java.util.List;


public interface MovieMapper {

    void insert(Movie movie);

    List<Movie> findAll();
}
