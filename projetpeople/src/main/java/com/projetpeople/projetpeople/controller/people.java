package com.projetpeople.projetpeople.controller;


import com.projetpeople.projetpeople.Models.People;
import com.projetpeople.projetpeople.Repository.IPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Component
@RequestMapping("/people")
@SpringBootApplication
// @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class people {

    @Autowired
      private IPeople peopleRepo;




    @GetMapping("/test")
    public List<People> getAllPeople() {
        return peopleRepo.findAll();
    }


    @DeleteMapping("{peopleid}")
    public void deletePeople(@PathVariable("peopleid") Integer id){

          peopleRepo.deleteById(id);
    }


   record  NewPeople(
           String firstname,
           String lastname,
           String email,
           String phone,
           String country

   ){}

    @PostMapping
    public void addPeople(@RequestBody NewPeople request){
        People people = new People();
        people.setFirstname(request.firstname());
        people.setLastname(request.lastname());
        people.setEmail(request.email());
        people.setPhone(request.phone());
        people.setCountry(request.country());
       peopleRepo.save(people);
    }

    @GetMapping("/find/{id}")
    public Optional<People> findPeople(@PathVariable Integer id){
        return peopleRepo.findById(id);
    }

    @GetMapping("/test/{lastname}")
    public List<People> getPeopleByName(@PathVariable String lastname) {

        return peopleRepo.findBylastnameStartingWith(lastname);
    }
    @PutMapping("/{peopleid}")
    public void updatePeople(@PathVariable("peopleid") Integer id, @RequestBody People peopleDetail) {

        People updatePeople = peopleRepo.findById(id).orElseThrow();

        updatePeople.setFirstname(peopleDetail.getFirstname());
        updatePeople.setLastname(peopleDetail.getLastname());
        updatePeople.setEmail(peopleDetail.getEmail());
        updatePeople.setPhone(peopleDetail.getPhone());
        updatePeople.setCountry(peopleDetail.getCountry());

        peopleRepo.save(updatePeople);
    }

}
