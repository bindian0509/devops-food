package com.bharat.devops.food.controller;

import com.bharat.devops.food.service.FoodService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Bharat V. <bindian0509@gmail.com>
 * @created Thursday, 18 January 2024
 */
@RestController
@RequestMapping("/food")
@CrossOrigin
public class FoodController {

    private final FoodService foodService;
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }


}
