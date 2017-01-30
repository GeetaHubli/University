package com.allstate.services;

import com.allstate.entities.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateNewStudent() throws Exception {
        Student stud1 = studentService.create("test4@gmail.com");
        assertEquals(4, stud1.getId());
    }

    @Test
    public void shouldFindStudentById() throws Exception {
        Student result = studentService.findById(3);
        assertEquals(3, result.getId());
        assertEquals("test3@gmail.com", result.getEmail());
    }

    @Test
    public void shouldFindStudentByEmail() throws Exception {
        Student result = studentService.findByEmail("test2@gmail.com");
        assertEquals(2, result.getId());
        assertEquals("test2@gmail.com", result.getEmail());
    }
}