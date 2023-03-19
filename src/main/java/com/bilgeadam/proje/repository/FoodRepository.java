package com.bilgeadam.proje.repository;

import com.bilgeadam.proje.common.repository.BaseRepository;
import com.bilgeadam.proje.entity.FoodEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FoodRepository extends BaseRepository<FoodEntity, UUID> {

    /**
     * Example of derived query in spring data jpa
     *
     * @param title of food which has comments
     * @return Food object related with selected title
     */
    FoodEntity findByIgnoreCaseTitle(String title);

    /**
     * Example of derived query in spring data jpa
     *
     * @param category of food which has category
     * @return list of Food objects related with selected category
     */
    List<FoodEntity> findByCategory(String category);

    /**
     * Example of derived query in spring data jpa
     *
     * @param price of food which has less than price
     * @return list of Food objects related with selected price
     */
    List<FoodEntity> findByPriceLessThan(int price);

    /**
     * Example of derived query in spring data jpa
     *
     * @param price of food which has greater than price
     * @return list of Food objects related with selected price
     */
    List<FoodEntity> findByPriceGreaterThan(int price);
}
