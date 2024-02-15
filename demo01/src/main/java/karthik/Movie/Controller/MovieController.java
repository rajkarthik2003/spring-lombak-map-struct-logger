package karthik.Movie.Controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import karthik.Movie.Entity.Movie;
import karthik.Movie.Entity.MovieDTO;
import karthik.Movie.Service.MovieService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MovieController {

	private MovieService service;
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Movie.class);

	@PostMapping("/add")
	public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO user) {
		MovieDTO n1 = service.createuser(user);
		return new ResponseEntity<>(n1, HttpStatus.CREATED);
	}

	@PostMapping("/getall")
	public ResponseEntity<List<MovieDTO>> getuser() {
		LOG.info("\"Hi I am Controller \"");
		List<MovieDTO> l1 = service.getall();
		return ResponseEntity.ok(l1);
	}

	@PostMapping("/getid/{id}")
	public ResponseEntity<MovieDTO> getid(@PathVariable Long id) {
		MovieDTO u = service.getbyId(id);
		return ResponseEntity.ok(u);
	}

	@DeleteMapping("/deleteall")
	public String deleteusers() {
		return service.deleteall();

	}

	@DeleteMapping("/deleteuser/{id}")
	public String deleteuser(@PathVariable Long id) {
		return service.deleteuser(id);
	}

}
