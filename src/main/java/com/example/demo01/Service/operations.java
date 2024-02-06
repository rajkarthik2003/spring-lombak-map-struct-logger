package com.example.demo01.Service;

import com.example.demo01.Demo.MovieDTO;

import java.util.List;

public interface operations {

    public MovieDTO createuser(MovieDTO user);

    public String deleteuser(Long id);

    public  String deleteall();

    public List<MovieDTO> getall();

    public MovieDTO getbyId(Long id);
}
