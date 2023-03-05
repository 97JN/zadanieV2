package com.example.demo.service;

import com.example.demo.entity.CarEntity;
import com.example.demo.entity.DetailEntity;
import com.example.demo.entity.Detail_DTO;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.DetailRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class DetailService {

    private final DetailRepository detailRepository;
    private final CarRepository carRepository;

    public DetailService(DetailRepository detailRepository, CarRepository carRepository) {
        this.detailRepository = detailRepository;
        this.carRepository = carRepository;
    }

    public Iterable<DetailEntity> findAll() {
        return detailRepository.findAll();
    }

    public DetailEntity save(Detail_DTO detailDto) {
        Optional<CarEntity> carPossible=carRepository.findById(detailDto.getCar_id());
        if(carPossible.isPresent()){
            CarEntity car = carPossible.get();
            return detailRepository.save(new DetailEntity( detailDto.getModel(), detailDto.getColor(), car));
        }
        else {
            throw new RuntimeException("Nie znaleziono takiego samochodu!");
        }
    }
}
