package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("Mango DB")
public class PersonDataAccessService implements PersonDao{
    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<Person> getAllPeople() {
        return List.of(new Person(UUID.randomUUID(),"Person from progress DB"));
    }

    @Override
    public int deletePersonById(UUID uuid) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
