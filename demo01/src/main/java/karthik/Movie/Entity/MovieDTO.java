package karthik.Movie.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieDTO {

	//        private Long id;
	private String title;
	private String director;

	// Add other fields, getters, setters
}
