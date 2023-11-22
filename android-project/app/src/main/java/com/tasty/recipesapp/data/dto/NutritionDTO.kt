package com.tasty.recipesapp.data.dto

import com.google.gson.annotations.SerializedName

data class NutritionDTO(
    @SerializedName("fiber")
    val fiber: Int,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("protein")
    val protein: Int,
    @SerializedName("fat")
    val fat: Int,
    @SerializedName("calories")
    val calories: Int,
    @SerializedName("salt")
    val salt: Int,
    @SerializedName("sugar")
    val sugar: Int,
    @SerializedName("carbohydrates")
    val carbohydrates: Int
)
