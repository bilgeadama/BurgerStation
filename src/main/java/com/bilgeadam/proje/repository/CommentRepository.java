package com.bilgeadam.proje.repository;

import com.bilgeadam.proje.common.repository.BaseRepository;
import com.bilgeadam.proje.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends BaseRepository<Comment, UUID> {

    /**
     * Example of derived query in spring data jpa
     *
     * @param foodId id of food which has comments
     * @return  list of comments related with selected food
     */
    List<String> findByFoodId(UUID foodId);

    /**
     * Example of jpql in spring data jpa
     * @param foodId
     * @return
     */
//    @Query("SELECT c from Comment c where c.food =:foodId")
//    List<String> findByFood(@Param("foodId") UUID foodId);

    @Query("SELECT c from Comment c where c.food =?1")
    List<String> findByFood(UUID foodId);


}