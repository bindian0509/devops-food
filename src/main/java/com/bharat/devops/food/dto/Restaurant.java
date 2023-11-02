package com.bharat.devops.food.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author Bharat V. <bindian0509@gmail.com>
 * @created Thursday, 18 January 2024
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {
    private int id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;
}
