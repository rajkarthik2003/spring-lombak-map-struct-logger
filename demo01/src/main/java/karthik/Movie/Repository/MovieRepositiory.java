package karthik.Movie.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import karthik.Movie.Entity.Movie;

public interface MovieRepositiory extends JpaRepository<Movie,Long> {
}
