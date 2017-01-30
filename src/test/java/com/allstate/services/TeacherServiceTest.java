package com.allstate.services;

import com.allstate.entities.Klass;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {
    @Autowired
    private TeacherService teacherService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateTeacher() throws Exception {
        Teacher result = this.teacherService.create(new Teacher("chyld", 25, Gender.M));
        assertEquals(4, result.getId());
    }

    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher result = this.teacherService.findById(2);
        assertEquals(2, result.getId());
        assertEquals("teacher2", result.getName());
    }

    @Test
    public void shouldFindTeacherByName() throws Exception {
        Teacher result = this.teacherService.findByName("teacher2");
        assertEquals(2, result.getId());
        assertEquals("teacher2", result.getName());
    }

    @Test
    public void shouldFindTeachersByGender() throws Exception {
        Iterable<Teacher> teacherList = this.teacherService.findByGender(Gender.F);
        List<Teacher> list = (List<Teacher>) teacherList;
        assertEquals(2, list.size());
    }

    @Test
    public void shouldFindTeachersOlderThenAge() throws Exception {
        Iterable<Teacher> teacherList = this.teacherService.findByAgeGreaterThan(25);
        List<Teacher> list = (List<Teacher>) teacherList;
        assertEquals(2, list.size());
    }

    @Test
    @Transactional
    public void shouldFindAllTheKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.teacherService.findById(1).getKlasses();
        assertEquals(1, klasses.size());
    }

    @Test
    @Transactional
    public void shouldFindNoKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.teacherService.findById(3).getKlasses();
        assertEquals(0, klasses.size());
    }
}