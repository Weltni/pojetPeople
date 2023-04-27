package com.projetpeople.projetpeople.Repository;

import com.projetpeople.projetpeople.Models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPeople  extends JpaRepository<People, Integer> {

    List<People> findBylastnameStartingWith(String lastName);



}
