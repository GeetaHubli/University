package com.allstate.services;

import com.allstate.entities.Student;
import com.allstate.respositories.IStudentRepository;
import org.omg.CosNaming._BindingIteratorStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private IStudentRepository studentRepository;

    @Autowired
    public  void setStudentRepository(IStudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student create(String email){
        return this.studentRepository.save(new Student(email));
    }


    public Student findById(int id) {
        return this.studentRepository.findOne(id);
    }

    public Student findByEmail(String email) {
        return this.studentRepository.findByEmail(email);
    }
}
