package com.allstate.services;

import com.allstate.entities.Klass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class LearningServiceTest {

    @Autowired
    private LearningService learningService;

    @Autowired
    private KlassService klassService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    @Transactional
    public void shouldEnrollStudentsIntoClass() throws Exception {
        List<String> emailList = new ArrayList<>();
        emailList.add("test4@gmail.com");
        emailList.add("test5@gmail.com");
        emailList.add("test6@gmail.com");

        Klass result =learningService.enroll(emailList, klassService.findByName("test1"));
        assertEquals(1, result.getId());
        assertEquals(3, result.getStudents().size());
    }

}