package com.tasty.recipesapp.data.dto

data class SectionDTO(
    val components: List<ComponentDTO>,
    val position: Int,
    val name: String,
)

data class ComponentDTO(
    val extra_comment: String,
    val ingredient: IngredientDTO,
    val id: Int,
    val position: Int,
    val measurements: List<MeasurementDTO>,
    val raw_text: String
)

data class IngredientDTO(
    val created_at: Long,
    val display_plural: String,
    val id: Int,
    val display_singular: String,
    val updated_at: Long,
    val name: String
)

data class MeasurementDTO(
    val unit: UnitDTO,
    val quantity: String,
    val id: Int
)

data class UnitDTO(
    val system: String,
    val name: String,
    val display_plural: String,
    val display_singular: String,
    val abbreviation: String
)
