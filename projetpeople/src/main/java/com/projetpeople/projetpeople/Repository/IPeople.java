package com.projetpeople.projetpeople.Repository;

import com.projetpeople.projetpeople.Models.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPeople  extends JpaRepository<People, Integer> {
}
