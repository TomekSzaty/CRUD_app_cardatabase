package com.tomszadev.cardatabase.repository;

import com.tomszadev.cardatabase.domain.Car;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepoPageAndSort extends PagingAndSortingRepository<Car, Long> {

    public Iterable<Car>findCarByColorContainingIgnoreCase(String colour);
}
