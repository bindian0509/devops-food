package com.bharat.devops.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author Bharat V. <bindian0509@gmail.com>
 * @created Thursday, 18 January 2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCataloguePage {

    private List<FoodItem> foodItemsList;
    private Restaurant restaurant;
}