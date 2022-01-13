package com.coc.service.impl;

import com.coc.model.Course;
import com.coc.repository.CourseRepository;
import com.coc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return (List<Course>) courseRepository.findAll();
    }
}
