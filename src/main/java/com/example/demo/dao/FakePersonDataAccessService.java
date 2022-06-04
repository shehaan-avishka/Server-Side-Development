package com.example.demo.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    List<Person > DB = new ArrayList<>();


    @Override
    public int insertPerson(UUID id, Person person){
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> getAllPeople(){
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID uuid){
        return DB.stream()
                .filter(person -> person.getId().equals(uuid))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID uuid){
        Optional<Person> personMaybe = selectPersonById(uuid);
        if(personMaybe.isEmpty()){
            return 0;
        }else{
            DB.remove(personMaybe.get());
            return 1;
        }
    }

    @Override
    public int updatePersonById(UUID uuid, Person person){
        return selectPersonById(uuid)
                .map(person1 -> {
                    int indexOfPersonToDelete = DB.indexOf(person1);
                    if(indexOfPersonToDelete>=0){
                        DB.set(indexOfPersonToDelete,new Person(uuid,person.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }




}
