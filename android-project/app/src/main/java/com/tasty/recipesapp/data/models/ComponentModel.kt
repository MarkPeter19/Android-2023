package com.tasty.recipesapp.data.models

data class ComponentModel(
    val measurements: List<MeasurementModel>,
    val rawText: String,
    val ingredient: IngredientModel,
)
