package com.bilgeadam.proje.service.impl;

import com.bilgeadam.proje.common.service.impl.BaseService;
import com.bilgeadam.proje.dto.FoodDto;
import com.bilgeadam.proje.entity.Food;
import com.bilgeadam.proje.repository.FoodRepository;
import com.bilgeadam.proje.service.FoodService;
import com.bilgeadam.proje.service.mapper.FoodMapper;
import com.bilgeadam.proje.validation.FoodValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FoodServiceImpl extends BaseService<FoodRepository, FoodMapper, Food, FoodDto> implements FoodService {

    private final FoodValidator foodValidator;
    private final FoodRepository foodRepository;

    @Autowired
    protected FoodServiceImpl(FoodMapper mapper, FoodRepository repository, FoodValidator foodValidator, FoodRepository foodRepository) {
        super(mapper, repository);
        this.foodValidator = foodValidator;
        this.foodRepository = foodRepository;
    }

    /**
     * @param foodDto
     * @return
     */
    public FoodDto saveFood(FoodDto foodDto) {

        foodValidator.foodSaveValidator(foodDto);
        return super.save(foodDto);
    }

    /**
     * @param foodDto
     * @return
     */
    public FoodDto updateFood(FoodDto foodDto) {

        return super.save(foodDto);
    }

    public List<FoodDto> saveAllFoods(List<FoodDto> foodDtoList) {

        return super.saveAll(foodDtoList);
    }

    /**
     * @return
     */
    @Override
    public List<FoodDto> findAll() {

        return super.findAll();
    }

    /**
     * @return
     */
    @Override
    public List<FoodDto> findByCategory(String categoryName) {

        return mapper.entityListToDtoList(foodRepository.findByCategory(categoryName));
    }

    /**
     * @return
     */
    @Override
    public FoodDto findByName(String name) {

        return mapper.entityToDto(foodRepository.findByIgnoreCaseTitle(name));
    }

    /**
     * @param uuid
     * @return
     */
    @Override
    public FoodDto findById(UUID uuid) {

        return super.findById(uuid);
    }

    /**
     * @param foodDto
     */
    @Override
    public void delete(FoodDto foodDto) {

        super.delete(foodDto);
    }

    /**
     * @param uuid
     */
    @Override
    public void deleteById(UUID uuid) {

        super.deleteById(uuid);
    }

    /**
     * @param foodDtos
     */
    @Override
    public void deleteAll(List<FoodDto> foodDtos) {

        super.deleteAll(foodDtos);
    }
}
