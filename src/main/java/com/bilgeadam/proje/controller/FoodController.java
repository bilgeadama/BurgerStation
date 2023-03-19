package com.bilgeadam.proje.controller;

import com.bilgeadam.proje.dto.FoodDto;
import com.bilgeadam.proje.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/get-all-foods")
    ResponseEntity<List<FoodDto>> allFoods(){

        return new ResponseEntity<>(foodService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-category")
    ResponseEntity<List<FoodDto>> getByCategory(@RequestParam("categoryName") String categoryName){

        return new ResponseEntity<>(foodService.findByCategory(categoryName), HttpStatus.OK);
    }

    @GetMapping("/search-foods-by-name")
    ResponseEntity<FoodDto> getByName(@RequestParam("name") String name){

        return new ResponseEntity<>(foodService.findByName(name), HttpStatus.OK);
    }



}
