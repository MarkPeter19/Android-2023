package com.tasty.recipesapp.data.models

data class RecipeModel(
    val id: Int,
    val name: String,
    val description: String,
    val instructions: List<InstructionModel>,
    val sections: List<SectionModel>,
    val user_ratings: UserRatingModel,
    val tags: List<TagModel>,
)

data class PriceModel(
    val consumption_portion: Int,
    val total: Int,
    val updated_at: String,
    val portion: Int,
    val consumption_total: Int
)

data class CompilationModel(
    val language: String,
    val thumbnail_url: String,
    val name: String,
    val slug: String,
    val aspect_ratio: String,
    val keywords: String?,
    val description: String,
    val draft_status: String,
    val video_url: String,
    val beauty_url: String?,
    val buzz_id: String?,
    val canonical_id: String,
    val id: Int,
    val country: String,
    val is_shoppable: Boolean,
    val show: ShowModel,
    val created_at: Long,
    val video_id: Int,
    val facebook_posts: List<String>,
    val thumbnail_alt_text: String,
    val approved_at: Long,
    val promotion: String
)

data class ShowModel(
    val name: String,
    val id: Int
)

data class RenditionModel(
    val content_type: String,
    val width: Int,
    val maximum_bit_rate: Int?,
    val container: String,
    val poster_url: String,
    val file_size: Long,
    val aspect: String,
    val minimum_bit_rate: Int?,
    val name: String,
    val height: Int,
    val url: String,
    val duration: Long,
    val bit_rate: Int
)

data class TotalTimeTierModel(
    val tier: String,
    val display_tier: String,
)
