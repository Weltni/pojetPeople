package com.projetpeople.projetpeople.controller;


import com.projetpeople.projetpeople.Models.People;
import com.projetpeople.projetpeople.Repository.IPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Component
@RequestMapping("/people")
// @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class people {

    @Autowired
      private IPeople peopleRepo;


      @GetMapping("/test")
      public List<People> getAllPeople() {
     return peopleRepo.findAll();
    }


}
