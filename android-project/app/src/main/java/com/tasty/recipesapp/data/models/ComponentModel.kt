package com.tasty.recipesapp.data.models

data class ComponentModel(
    val position: Int,
    val measurements: List<MeasurementModel>,
    val raw_text: String,
    val extra_comment: String,
    val ingredient: IngredientModel,
    val id: Int
)
