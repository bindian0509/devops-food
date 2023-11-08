package com.bharat.devops.food.service;

import com.bharat.devops.food.dto.FoodCataloguePage;
import com.bharat.devops.food.dto.FoodItemDTO;
import com.bharat.devops.food.dto.Restaurant;
import com.bharat.devops.food.entity.FoodItem;
import com.bharat.devops.food.mapper.FoodItemMapper;
import com.bharat.devops.food.repo.FoodItemRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    public FoodItemDTO addFoodItem(FoodItemDTO foodItemDTO) {
        FoodItem foodItemSavedInDB = foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDto(foodItemSavedInDB);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<FoodItem> foodItemList =  fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<FoodItem> foodItemList, Restaurant restaurant) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemsList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepo.findByRestaurantId(restaurantId);
    }
}
