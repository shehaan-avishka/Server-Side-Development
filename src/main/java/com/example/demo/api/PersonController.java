package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public int insertPerson(@RequestBody Person person){
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person selectPersonById(@PathVariable("id") UUID uuid){
        return personService.selectPersonByID(uuid)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID uuid){
        personService.deletePersonById(uuid);
    }

    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") UUID uuid, @RequestBody Person person){
        return personService.updatePersonById(uuid,person);
    }
}
