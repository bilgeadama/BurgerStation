package com.bilgeadam.proje.service;

import com.bilgeadam.proje.dto.FoodDto;

import java.util.List;
import java.util.UUID;

public interface FoodService {

    FoodDto saveFood(FoodDto foodDto);

    FoodDto updateFood(FoodDto foodDto);

    List<FoodDto> saveAllFoods(List<FoodDto> foodDtoList);

    List<FoodDto> findAll();

    List<FoodDto> findByCategory(String categoryName);

    FoodDto findByName(String name);

    FoodDto findById(UUID uuid);

    void delete(FoodDto foodDto);

    void deleteById(UUID uuid);

    void deleteAll(List<FoodDto> foodDtos);
}
