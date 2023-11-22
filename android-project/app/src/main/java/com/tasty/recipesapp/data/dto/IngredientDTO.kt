package com.tasty.recipesapp.data.dto

import com.google.gson.annotations.SerializedName

data class IngredientDTO(
    @SerializedName("id")
    val id: Int,
    @SerializedName("display_singular")
    val displaySingular: String,
    @SerializedName("updated_at")
    val updatedAt: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("created_at")
    val createdAt: Long,
    @SerializedName("display_plural")
    val displayPlural: String
)
