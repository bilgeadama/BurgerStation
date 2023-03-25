package com.bilgeadam.proje.service;

import com.bilgeadam.proje.dto.CommentDto;

import java.util.List;
import java.util.UUID;

public interface CommentService {

    CommentDto saveComment(CommentDto CommentDto);

    List<CommentDto> saveAllComments(List<CommentDto> CommentDtoList);

    List<CommentDto> findAll();

    CommentDto findById(UUID uuid);

    List<CommentDto> findByFoodId(UUID foodId);

    void delete(CommentDto CommentDto);

    void deleteById(UUID uuid);

    void deleteAll(List<CommentDto> CommentDtos);

    String loadComments(UUID foodId);
}
