package com.projetpeople.projetpeople.controller;


import com.projetpeople.projetpeople.Models.People;
import com.projetpeople.projetpeople.Repository.IPeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Component
@RequestMapping("/people")
@SpringBootApplication
// @CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class people {

    @Autowired
      private IPeople peopleRepo;




    @GetMapping("/")
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

    @GetMapping("/lastname/{lastname}")
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

    @GetMapping("/country/{country}")
    public List<People> getPeopleByCountry(@PathVariable String country){
        List<People> peopleList = peopleRepo.findAll();

        return peopleList.stream()
                .filter(people -> people.getCountry().equals(country))
                .collect(Collectors.toList());
    }

    @GetMapping("/{country}/{telephone}")
    public List<People> getPeopleCountrylastname(@PathVariable String country,@PathVariable String telephone){
        List<People> peopleList = peopleRepo.findByCountry(country);

        return peopleList.stream()
                .filter(people -> people.getPhone().startsWith(telephone))
                .collect(Collectors.toList());
    }

    @GetMapping("/test/{param1}/{param2}")
    public List<People> findnumber(@PathVariable String param1,@PathVariable String param2) {
        List<People> peopleList = peopleRepo.findAll();
        List<People> franceNum = peopleList.stream()
                .filter(p -> p.getCountry().equals(param1) && p.getPhone().startsWith(param2))
                .collect(Collectors.toList());
        return franceNum;
    }

}
