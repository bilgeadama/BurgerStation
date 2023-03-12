package com.bilgeadam.proje.repository;

import com.bilgeadam.proje.common.repository.BaseRepository;
import com.bilgeadam.proje.model.Food;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodRepository extends BaseRepository<Food, UUID> {
}
