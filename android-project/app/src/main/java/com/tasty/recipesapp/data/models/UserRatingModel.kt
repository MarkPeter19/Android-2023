package com.tasty.recipesapp.data.models

data class UserRatingModel(
    val count_positive: Int,
    val count_negative: Int,
    val score: Double
)
