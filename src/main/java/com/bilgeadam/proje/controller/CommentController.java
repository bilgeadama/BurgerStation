package com.bilgeadam.proje.controller;

import com.bilgeadam.proje.dto.CommentDto;
import com.bilgeadam.proje.repository.CommentRepository;
import com.bilgeadam.proje.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    public CommentController(CommentRepository commentRepository, CommentService commentService) {
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }

    @GetMapping("/get-all-comments")
    public ResponseEntity<List<CommentDto>> getAllComments(){

        return new ResponseEntity (commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-food")
    public ResponseEntity<List<CommentDto>> getByFood(UUID foodId){

        return new ResponseEntity (commentService.findByFoodId(foodId), HttpStatus.OK);
    }
}
