/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniroma1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Movies")
public class Movies {
    private List<Movie> movies;

    public Movies(List<Movie> movies) {
        this.movies = movies;
    }
    public Movies() {
        this.movies = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movies=" + movies.toString() +
                '}';
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    
    public void addMovie(Movie m){
        this.movies.add(m);
    }
}
