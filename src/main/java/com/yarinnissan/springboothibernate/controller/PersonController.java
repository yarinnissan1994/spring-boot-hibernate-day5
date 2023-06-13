package com.yarinnissan.springboothibernate.controller;

import com.yarinnissan.springboothibernate.dao.PersonDao;
import com.yarinnissan.springboothibernate.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orm")
public class PersonController {

    @Autowired
    private PersonDao dao;

    @PostMapping("/savePerson")
    public String save(@RequestBody Person person){
        dao.savePerson(person);
        return "saved successfully";
    }

    @GetMapping("/getAllPersons")
    public List<Person> getAllPersons(){
        return dao.getPersons();
    }
}
