package com.tasty.recipesapp.data.models

data class RecipeModel(
    val tags: List<TagModel>,
    val thumbnailUrl: String?,
    val originalVideoUrl: String?,
    val userRatings: UserRatingsModel,
    val sections: List<SectionModel>,
    val name: String?,
    val videoUrl: String?,
    val nutrition: NutritionModel,
    val topics: List<TopicModel>,
    val instructions: List<InstructionModel>,
    val credits: List<CreditModel>,
    val description: String?,
    val numServings: Int,
)
