package com.tasty.recipesapp.data.utils

import com.tasty.recipesapp.data.dto.ComponentDTO
import com.tasty.recipesapp.data.dto.IngredientDTO
import com.tasty.recipesapp.data.dto.InstructionDTO
import com.tasty.recipesapp.data.dto.RecipeDTO
import com.tasty.recipesapp.data.dto.SectionDTO
import com.tasty.recipesapp.data.dto.TagDTO
import com.tasty.recipesapp.data.dto.UserRatingDTO
import com.tasty.recipesapp.data.models.ComponentModel
import com.tasty.recipesapp.data.models.InstructionModel
import com.tasty.recipesapp.data.models.InstructionTime
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.data.models.SectionModel
import com.tasty.recipesapp.data.models.TagModel
import com.tasty.recipesapp.data.models.UserRatingModel

object Mapping {
    @JvmName("toRecipeModel")
    fun RecipeDTO.toModel(): RecipeModel {
        return RecipeModel(
            id = this.id,
            name = this.name,
            description = this.description,
            instructions = instructions.toModelList(),
            sections = sections.toModelList(),
            user_ratings = user_ratings.toModel(),
            tags = tags.toModelList(),
        )
    }

    @JvmName("toRecipeModelList")
    fun List<RecipeDTO>.toModelList(): List<RecipeModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toInstructionModel")
    fun InstructionDTO.toModel(): InstructionModel {
        return InstructionModel(
            id = this.id,
            display_text = this.display_text,
            time = InstructionTime(this.start_time,this.end_time),
        )
    }

    @JvmName("toInstructionModelList")
    fun List<InstructionDTO>.toModelList(): List<InstructionModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toSectionModel")
    fun SectionDTO.toModel(): SectionModel {
        return SectionModel(
            components = this.components.toModelList(),
            position = this.position ?: 0,
            name = this.name ?: "",
        )
    }

    @JvmName("toSectionModelList")
    fun List<SectionDTO>.toModelList(): List<SectionModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toTagModel")
    fun TagDTO.toModel(): TagModel {
        return TagModel(
            display_name = this.display_name,
            type = this.type,
            id = this.id,
            name = this.name,
            root_tag_type = this.root_tag_type,
        )
    }

    @JvmName("toTagModelList")
    fun List<TagDTO>.toModelList(): List<TagModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toUserRatingModel")
    fun UserRatingDTO.toModel(): UserRatingModel {
        return UserRatingModel(
            count_positive = this.count_positive,
            count_negative = this.count_negative,
            score = this.score
        )
    }

    @JvmName("toUserRatingModelList")
    fun List<UserRatingDTO>.toModelList(): List<UserRatingModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toComponentModel")
    fun ComponentDTO.toModel(): ComponentModel {
        return ComponentModel(
            extra_comment = this.extra_comment,
            ingredient = this.ingredient.toModel(),
            id = this.id,
            position = this.position,
            measurements = this.measurements.toModelList(),
            raw_text = this.raw_text,
        )
    }

    @JvmName("toComponentModelList")
    fun List<ComponentDTO>.toModelList(): List<ComponentModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toIngredientModel")
    fun IngredientDTO.toModel(): com.tasty.recipesapp.data.models.IngredientModel {
        return com.tasty.recipesapp.data.models.IngredientModel(
            created_at = this.created_at,
            display_plural = this.display_plural,
            id = this.id,
            display_singular = this.display_singular,
            updated_at = this.updated_at,
            name = this.name,
        )
    }

    @JvmName("MeasurementModel")
    fun com.tasty.recipesapp.data.dto.MeasurementDTO.toModel(): com.tasty.recipesapp.data.models.MeasurementModel {
        return com.tasty.recipesapp.data.models.MeasurementModel(
            unit = this.unit.toModel(),
            quantity = this.quantity,
            id = this.id,
        )
    }

    @JvmName("toMeasurementModelList")
    fun List<com.tasty.recipesapp.data.dto.MeasurementDTO>.toModelList(): List<com.tasty.recipesapp.data.models.MeasurementModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toUnitModel")
    fun com.tasty.recipesapp.data.dto.UnitDTO.toModel(): com.tasty.recipesapp.data.models.UnitModel {
        return com.tasty.recipesapp.data.models.UnitModel(
            system = this.system,
            name = this.name,
            display_plural = this.display_plural,
            display_singular = this.display_singular,
            abbreviation = this.abbreviation,
        )
    }

    @JvmName("toUnitModelList")
    fun List<com.tasty.recipesapp.data.dto.UnitDTO>.toModelList(): List<com.tasty.recipesapp.data.models.UnitModel> {
        return this.map { it.toModel() }
    }
}