package karthik.Movie.Service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import karthik.Movie.Entity.Movie;
import karthik.Movie.Entity.MovieDTO;
import karthik.Movie.Entity.Mapper;
import karthik.Movie.Repository.MovieRepositiory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MovieService {

    @Autowired
   private  MovieRepositiory repo;
   private static final Logger LOG = LoggerFactory.getLogger(Movie.class);


    public MovieDTO createuser(MovieDTO movie) {
        Movie n1= Mapper.maptoMovie(movie);
        return Mapper.maptoMovieDTO(repo.save(n1));
    }

    public List<MovieDTO> getall() {

        LOG.info("Task execution started.");
        List<Movie> n1=repo.findAll();
        return n1.stream().map(Mapper::maptoMovieDTO).collect(Collectors.toList());
    }

    public MovieDTO getbyId(Long id) {
        Movie n1=repo.findById(id).orElse(null);

        return Mapper.maptoMovieDTO(n1);
    }



    public String deleteuser(Long id) {
        repo.deleteById(id);
        return "Deleted the Movie";
    }

    public String deleteall() {
        repo.deleteAll();
        LOG.info("Movie has been Deleted");
        return null;
    }



}
