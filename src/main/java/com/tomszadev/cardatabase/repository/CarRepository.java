package com.tomszadev.cardatabase.repository;

import com.tomszadev.cardatabase.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

    public List<Car> findByBrand(@Param("brand") String brand);
    public List<Car> findByColor(@Param("color") String color);
}
