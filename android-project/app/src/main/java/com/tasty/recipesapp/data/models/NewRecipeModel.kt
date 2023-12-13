package com.tasty.recipesapp.data.models

data class NewRecipeModel(
    val id: Long,
    val title: String?,
    val description: String?,
    val ingredients: List<String>?,
    val instructions: List<String>?,
    val thumbnailUrl: String?,
    //val videoUrl: String?
)
