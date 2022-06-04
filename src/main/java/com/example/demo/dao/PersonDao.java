package com.example.demo.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);


    //insert people to the database
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    Optional<Person> selectPersonById(UUID uuid);

    //get all people details
    List<Person> getAllPeople();

    int deletePersonById(UUID uuid);

    int updatePersonById(UUID id, Person person);



}

