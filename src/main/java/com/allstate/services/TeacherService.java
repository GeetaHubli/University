package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.respositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private ITeacherRepository teacherRepository;

    @Autowired
    public  void setStudentRepository(ITeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }

    public Teacher findById(int id) {
        return this.teacherRepository.findOne(id);
    }
}
