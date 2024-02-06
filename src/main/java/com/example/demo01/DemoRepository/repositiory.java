package com.example.demo01.DemoRepository;

import com.example.demo01.Demo.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repositiory extends JpaRepository<Movie,Long> {
}
