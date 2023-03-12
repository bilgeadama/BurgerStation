package com.bilgeadam.proje.repository;

import com.bilgeadam.proje.common.repository.BaseRepository;
import com.bilgeadam.proje.model.Food;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodRepository extends BaseRepository<Food, UUID> {

    Food findByIgnoreCaseTitle(String title);

    List<Food> findByCategory(String category);

    List<Food> findByPriceLessThan(int price);

    List<Food> findByPriceGreaterThan(int price);
}
