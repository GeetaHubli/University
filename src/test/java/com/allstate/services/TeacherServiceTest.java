package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.enums.Gender;
import com.allstate.respositories.ITeacherRepository;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {

    private ITeacherRepository teacherRepository;

    @Autowired
    public  void setStudentRepository(ITeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateTeacher() throws Exception {
        Teacher result = this.teacherRepository.save(new Teacher("chyld", 25, Gender.M));
        assertEquals(4, result.getId());
    }

    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher result = this.teacherRepository.findOne(2);
        assertEquals(2, result.getId());
        assertEquals("teacher2", result.getName());
    }

    @Test
    public void shouldFindTeacherByName() throws Exception {
        Teacher result = this.teacherRepository.findByName("teacher2");
        assertEquals(2, result.getId());
        assertEquals("teacher2", result.getName());
    }

    @Test
    public void shouldFindTeachersByGender() throws Exception {
        Iterable<Teacher> teacherList = this.teacherRepository.findByGenderIs(Gender.F);
        List<Teacher> list = (List<Teacher>) teacherList;
        assertEquals(2, list.size());
    }

    @Test
    public void shouldFindTeachersOlderThenAge() throws Exception {
        Iterable<Teacher> teacherList = this.teacherRepository.findByAgeGreaterThan(25);
        List<Teacher> list = (List<Teacher>) teacherList;
        assertEquals(2, list.size());
    }
}