package com.coc.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Course {

    @Id
    private Long id;

    private String name;

    private String teacher;

    private int year;

    private int length;
}
