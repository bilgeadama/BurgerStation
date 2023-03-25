package com.bilgeadam.proje.controller;

import com.bilgeadam.proje.dto.FoodDto;
import com.bilgeadam.proje.service.FoodService;
import com.bilgeadam.proje.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;
    private final UserService userService;

    public FoodController(FoodService foodService, UserService userService) {

        this.foodService = foodService;
        this.userService = userService;
    }

    @GetMapping("/get-all-foods")
    ResponseEntity<List<FoodDto>> allFoods() {

        return new ResponseEntity<>(foodService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-category")
    ResponseEntity<List<FoodDto>> getByCategory(@RequestParam("categoryName") String categoryName) {

        return new ResponseEntity<>(foodService.findByCategory(categoryName), HttpStatus.OK);
    }

    @GetMapping("/search-foods-by-name")
    ResponseEntity<FoodDto> getByName(@RequestParam("name") String name) {

        return new ResponseEntity<>(foodService.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/add-food")
    ResponseEntity<FoodDto> addFood(@RequestBody FoodDto foodDto) {

        return new ResponseEntity<>(foodService.saveFood(foodDto), HttpStatus.CREATED);
    }

    @GetMapping("/payment-action")
    void paymentAction(HttpSession session) {

        int spent = Integer.parseInt(session.getAttribute("price").toString());
        userService.makePayment(spent);
        session.removeAttribute("price");
    }
}
