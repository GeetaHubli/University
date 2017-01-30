package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.enums.Departments;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class KlassServiceTest {
    @Autowired
    private KlassService klassService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateKlass() throws Exception {
        Date date = new Date();
        Klass klass = new Klass("Compozed", new Timestamp(date.getTime()), 5, Departments.ENGINEERING, 20.0);
        Klass result = klassService.create(klass);
        assertEquals(4, result.getId());
    }

    @Test
    public void shouldFindById() throws Exception {
        Klass klass = klassService.findById(2);
        assertEquals(2, klass.getId());
        assertEquals("test2", klass.getName());
    }

    @Test
    public void shouldFindByName() throws Exception {
        Klass klass = klassService.findByName("test2");
        assertEquals(2, klass.getId());
        assertEquals("test2", klass.getName());
    }
}