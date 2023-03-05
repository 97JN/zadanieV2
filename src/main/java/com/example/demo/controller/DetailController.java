package com.example.demo.controller;

import com.example.demo.entity.CarEntity;
import com.example.demo.entity.DetailEntity;
import com.example.demo.entity.Detail_DTO;
import com.example.demo.service.DetailService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/details")
public class DetailController {
    private DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }
    @GetMapping("/all")
    public Iterable <DetailEntity> getAll(){
        return detailService.findAll();
    }

    @PostMapping
    public DetailEntity addDetail(@RequestBody Detail_DTO detailDto){
        return  detailService.save(detailDto);
    }
}
