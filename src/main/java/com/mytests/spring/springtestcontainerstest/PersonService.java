package com.mytests.spring.springtestcontainerstest;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *
 * <p>Created by Irina on 8/30/2025.</p>
 * *
 */
@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public List<Person> getAll() {
        return repository.findAll();
    }

    ;

    public void populateDB() {
        System.out.println("====== DB population  =====");
        repository.save(new Person("ivan", "ivanov", "male"));
        repository.save(new Person("petr", "petrov", "male"));
        repository.save(new Person("pavel", "pavlov", "undefined"));
        System.out.println("===================");
    }

}