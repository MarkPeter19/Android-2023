package com.tasty.recipesapp.data.dto

data class UserRatingDTO(
    val count_positive: Int,
    val count_negative: Int,
    val score: Double
)
