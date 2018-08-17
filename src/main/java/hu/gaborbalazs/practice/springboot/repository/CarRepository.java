package hu.gaborbalazs.practice.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.gaborbalazs.practice.springboot.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
