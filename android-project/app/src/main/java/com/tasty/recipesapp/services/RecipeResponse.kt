package com.tasty.recipesapp.services

import com.google.gson.annotations.SerializedName
import com.tasty.recipesapp.data.models.RecipeModel

data class RecipeResponse(
    @SerializedName("recipes")
    val recipes: List<RecipeModel>?,
    // Add other fields if needed
)
