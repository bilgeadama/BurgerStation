package com.bilgeadam.proje.controller;

import com.bilgeadam.proje.dto.CommentDto;
import com.bilgeadam.proje.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@RestController
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {

        this.commentService = commentService;
    }

    @GetMapping("/get-all-comments")
    public ResponseEntity<List<CommentDto>> getAllComments() {

        return new ResponseEntity<>(commentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-food")
    public ResponseEntity<List<CommentDto>> getByFood(UUID foodId) {

        return new ResponseEntity<>(commentService.findByFoodId(foodId), HttpStatus.OK);
    }

    @GetMapping("/get-comments")
    String getCommentsHTML(HttpSession session) {
        UUID foodId = session.getAttribute("foodId") == null ? UUID.fromString("") : (UUID) session.getAttribute("foodId");
        return commentService.loadComments(foodId);
    }
}