package com.example.demo.controller;


import com.example.demo.dto.Person;
import com.example.demo.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  RestService personService;

  //http://localhost:8080/persistPerson
//  {
//      "name": "First name",
//          "age": 32,
//          "id":"2",
//          "profession": "Software Developer"
//
//  }
    @RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
    public ResponseEntity < String > persistPerson(@RequestBody Person person) {

        personService.persist(person);
            return ResponseEntity.status(HttpStatus.CREATED).build();

    }


    // http://localhost:8080/person?id=2

    @RequestMapping(
            value = "/person",
            method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    ResponseEntity documentDetail(
            @RequestParam("id") String id) {

            return new ResponseEntity(personService.getPerson(id), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/valid-name/{name}",
            method = RequestMethod.GET)
    public void createUsername(@PathVariable("name") @NotBlank @Size(max = 10) String username) {

        System.out.println(username);

    }

    @RequestMapping(
            value = "/day",
            method = RequestMethod.GET)
    public ResponseEntity getNameOfDayByNumber(@RequestParam Integer dayOfWeek) {
        // ...

        System.out.println(dayOfWeek);
        return new ResponseEntity("dayOfWeek entered : "+dayOfWeek, HttpStatus.OK);
    }





}
