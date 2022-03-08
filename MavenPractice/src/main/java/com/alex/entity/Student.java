package com.alex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    int sid;
    String name;
    String gender;

    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}
