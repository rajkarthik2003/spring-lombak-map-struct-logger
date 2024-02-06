package com.example.demo01.Service;

import com.example.demo01.Demo.Movie;
import com.example.demo01.Demo.MovieDTO;
import com.example.demo01.Demo.mapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo01.DemoRepository.repositiory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
//@NoArgsConstructor
public class userservice implements operations{

    @Autowired
   private  repositiory repo;
   private static final Logger LOG = LoggerFactory.getLogger(Movie.class);


    @Override
    public MovieDTO createuser(MovieDTO movie) {
        Movie n1= mapper.maptoMovie(movie);
        return mapper.maptoMovieDTO(repo.save(n1));
    }

    public List<MovieDTO> getall() {

        LOG.info("Task execution started.");
        List<Movie> n1=repo.findAll();
        return n1.stream().map(mapper::maptoMovieDTO).collect(Collectors.toList());
    }

    @Override
    public MovieDTO getbyId(Long id) {
        Movie n1=repo.findById(id).orElse(null);

        return mapper.maptoMovieDTO(n1);
    }



    @Override
    public String deleteuser(Long id) {
        repo.deleteById(id);
        return "Deleted the Movie";
    }

    @Override
    public String deleteall() {
        repo.deleteAll();
        LOG.info("Movie has been Deleted");
        return null;
    }



}
