package com.example.demo.service;

import com.example.demo.entity.CarEntity;
import com.example.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Iterable<CarEntity> findAll() {
        return carRepository.findAll();
    }

    public Optional<CarEntity> findById(Integer temp) {
        return carRepository.findById(temp);
    }

    public void deletyById(Integer temp) {
        carRepository.deleteById(temp);
    }

    public CarEntity save(CarEntity carEntity) {
        return carRepository.save(carEntity);
    }
}
