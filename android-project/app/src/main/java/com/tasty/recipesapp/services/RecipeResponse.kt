package com.tasty.recipesapp.services


import com.tasty.recipesapp.data.dto.RecipeDTO


data class RecipeResponseDTO(
    val count : Int,
    val results: List<RecipeDTO>
)



