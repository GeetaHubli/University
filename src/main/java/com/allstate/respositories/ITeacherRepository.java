package com.allstate.respositories;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import org.springframework.data.repository.CrudRepository;

public interface ITeacherRepository extends CrudRepository<Teacher, Integer>{
    public Teacher findByName(String name);

    public Iterable<Teacher> findByGenderIs(Gender gender);

    public Iterable<Teacher> findByAgeGreaterThan(int age);
}
