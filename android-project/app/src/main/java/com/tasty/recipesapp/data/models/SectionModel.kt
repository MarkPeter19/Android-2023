package com.tasty.recipesapp.data.models

data class SectionModel(
    val components: List<ComponentModel>,
    val position: Int,
    val name: String,
)

data class ComponentModel(
    val extra_comment: String,
    val ingredient: IngredientModel,
    val id: Int,
    val position: Int,
    val measurements: List<MeasurementModel>,
    val raw_text: String
)

data class IngredientModel(
    val created_at: Long,
    val display_plural: String,
    val id: Int,
    val display_singular: String,
    val updated_at: Long,
    val name: String
)

data class MeasurementModel(
    val unit: UnitModel,
    val quantity: String,
    val id: Int
)

data class UnitModel(
    val system: String,
    val name: String,
    val display_plural: String,
    val display_singular: String,
    val abbreviation: String
)
