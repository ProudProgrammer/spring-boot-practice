package hu.gaborbalazs.practice.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hu.gaborbalazs.practice.springboot.entity.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

}
