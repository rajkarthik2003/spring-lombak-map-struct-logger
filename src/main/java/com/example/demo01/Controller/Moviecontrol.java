package com.example.demo01.Controller;

import com.example.demo01.Demo.Movie;
import com.example.demo01.Demo.MovieDTO;
import com.example.demo01.Service.userservice;
import lombok.AllArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class Moviecontrol {

    private userservice service;
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(Movie.class);
    @PostMapping("/add")
    public ResponseEntity<MovieDTO> createuser(@RequestBody MovieDTO user){
        MovieDTO n1= service.createuser(user);
        return new ResponseEntity<>(n1, HttpStatus.CREATED);
    }

    @PostMapping("/getall")
    public ResponseEntity<List<MovieDTO>> getuser(){
        LOG.info("\"Hi I am Controller \"");
        List<MovieDTO> l1= service.getall();
        return ResponseEntity.ok(l1);
    }





    @PostMapping("/getid/{id}")
    public ResponseEntity<MovieDTO> getid(@PathVariable Long id){
       MovieDTO u=service.getbyId(id);
        return ResponseEntity.ok(u);
    }




    @DeleteMapping("/deleteall")
    public String deleteusers(){
        return  service.deleteall();

    }

    @DeleteMapping("/deleteuser/{id}")
    public String deleteuser(@PathVariable Long id){
        return service.deleteuser(id);
    }


}
