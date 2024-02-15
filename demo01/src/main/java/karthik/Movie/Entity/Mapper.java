package karthik.Movie.Entity;

public class Mapper {

	public static MovieDTO maptoMovieDTO(Movie movie) {
		return new MovieDTO(movie.getTitle(), movie.getDirector());
	}

	public static Movie maptoMovie(MovieDTO user) {
		return new Movie(0L, user.getTitle(), user.getDirector());
	}
}
