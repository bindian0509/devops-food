package com.bharat.devops.food.mapper;

import com.bharat.devops.food.dto.FoodItemDTO;
import com.bharat.devops.food.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/*
 * @author Bharat V. <bindian0509@gmail.com>
 * @created Thursday, 18 January 2024
 */
@Mapper
public interface FoodItemMapper {
    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemToFoodItemDto(FoodItem foodItem);
}