package com.bilgeadam.proje.repository;

import com.bilgeadam.proje.common.repository.BaseRepository;
import com.bilgeadam.proje.dto.CommentDto;
import com.bilgeadam.proje.entity.CommentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends BaseRepository<CommentEntity, UUID> {

    /**
     * Example of derived query in spring data jpa
     *
     * @param foodId id of food which has comments
     * @return list of comments related with selected food
     */
    List<CommentEntity> findByFoodIdOrderByCreateDateDesc(UUID foodId);

    /**
     * Example of jpql in spring data jpa
     *
     * @param foodId
     * @return
     */
//    @Query("SELECT c from Comment c where c.food =:foodId")
//    List<String> findByFood(@Param("foodId") UUID foodId);
    @Query("SELECT c from CommentEntity c where c.food =?1")
    List<String> findByFood(UUID foodId);


}
