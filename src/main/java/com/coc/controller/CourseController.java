package com.coc.controller;

import com.coc.model.Course;
import com.coc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService service;

    @GetMapping("course")
    List<Course> getAll() {
        return service.getAll();
    }

}
