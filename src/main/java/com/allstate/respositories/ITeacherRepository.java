package com.allstate.respositories;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITeacherRepository extends CrudRepository<Teacher, Integer>{
    public Teacher findByName(String name);

    public Iterable<Teacher> findByGender(Gender gender);

    public Iterable<Teacher> findByAgeGreaterThan(int age);

}
