package com.example.demo01.Demo;

public class mapper {

    public static MovieDTO maptoMovieDTO(Movie movie){
        return  new MovieDTO(
                movie.getTitle(),
                movie.getDirector()

        );
    }

    public static Movie maptoMovie(MovieDTO user){
        return new Movie(
                0L,
                user.getTitle(),
                user.getDirector()
        );
    }
}

