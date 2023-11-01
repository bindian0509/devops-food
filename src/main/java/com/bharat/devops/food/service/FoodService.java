package com.bharat.devops.food.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
 * @author Bharat V. <bindian0509@gmail.com>
 * @created Thursday, 18 January 2024
 */
@Service
public class FoodService {

    private final RestTemplate restTemplate;
    private final FoodItemRepo foodItemRepo;

    public FoodService(RestTemplate restTemplate, FoodItemRepo foodItemRepo) {
        this.restTemplate = restTemplate;
        this.foodItemRepo = foodItemRepo;
    }
}
