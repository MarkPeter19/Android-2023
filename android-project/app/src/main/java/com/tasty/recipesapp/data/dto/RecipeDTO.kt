package com.tasty.recipesapp.data.dto

data class RecipeDTO(
    val aspect_ratio: String,
    val brand_id: String?,
    val tags: List<TagDTO>,
    val thumbnail_alt_text: String,
    val promotion: String,
    val thumbnail_url: String,
    val original_video_url: String,
    val price: PriceDTO,
    val tips_and_ratings_enabled: Boolean,
    val servings_noun_plural: String,
    val video_ad_content: String,
    val seo_title: String,
    val seo_path: String,
    val canonical_id: String,
    val beauty_url: String?,
    val user_ratings: UserRatingDTO,
    val draft_status: String,
    val compilations: List<CompilationDTO>,
    val renditions: List<RenditionDTO>,
    val language: String,
    val id: Int,
    val servings_noun_singular: String,
    val sections: List<SectionDTO>,
    val name: String,
    val inspired_by_url: String?,
    val video_url: String,
    val brand: String?,
    val yields: String,
    val nutrition: NutritionDTO,
    val is_app_only: Boolean,
    val approved_at: Long,
    val topics: List<TopicDTO>,
    val instructions: List<InstructionDTO>,
    val slug: String,
    val buzz_id: String?,
    val credits: List<CreditDTO>,
    val nutrition_visibility: String,
    val is_subscriber_content: Boolean,
    val country: String,
    val prep_time_minutes: Int,
    val total_time_minutes: Int?,
    val updated_at: Long,
    val is_one_top: Boolean,
    val total_time_tier: TotalTimeTierDTO,
    val video_id: Int,
    val num_servings: Int,
    val created_at: Long,
    val show: ShowDTO,
    val description: String,
    val cook_time_minutes: Int,
    val facebook_posts: List<String>,
    val show_id: Int,
    val is_shoppable: Boolean,
    val keywords: String,
)

data class PriceDTO(
    val consumption_portion: Int,
    val total: Int,
    val updated_at: String,
    val portion: Int,
    val consumption_total: Int
)

data class CompilationDTO(
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
    val show: List<ShowDTO>,
    val created_at: Long,
    val video_id: Int,
    val facebook_posts: List<String>,
    val thumbnail_alt_text: String,
    val approved_at: Long,
    val promotion: String
)

data class ShowDTO(
    val name: String,
    val id: Int
)

data class RenditionDTO(
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

data class TotalTimeTierDTO(
    val tier: String,
    val display_tier: String,
)



