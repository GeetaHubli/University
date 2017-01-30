package com.allstate.controllers;

import com.allstate.entities.Student;
import com.allstate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    public void studentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = {"", "/"}, method = RequestMethod.POST)
    public Student create(@RequestBody Map<String, String> json){
        return this.studentService.create(json.get("email"));
    }

}
