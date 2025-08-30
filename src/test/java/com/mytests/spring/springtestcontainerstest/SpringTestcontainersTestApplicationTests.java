package com.mytests.spring.springtestcontainerstest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(initializers = PostgresTestContainerInitializer.class)
@SpringBootTest
class SpringTestcontainersTestApplicationTests {
    @Autowired
    private PersonService service;
    @Test
    void testPersons() {
        System.out.println("Test started");
        service.populateDB();
        List<Person> all = service.getAll();
        all.forEach(System.out::println);
        assertEquals(3, all.size());
    }
}