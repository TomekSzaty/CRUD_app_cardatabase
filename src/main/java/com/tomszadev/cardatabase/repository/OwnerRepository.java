package com.tomszadev.cardatabase.repository;

import com.tomszadev.cardatabase.domain.Car;
import com.tomszadev.cardatabase.domain.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    public List<Owner> findOwnersByFirstname(String firstname);
}
