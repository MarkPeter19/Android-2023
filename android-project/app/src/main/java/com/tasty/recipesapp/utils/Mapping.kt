package com.tasty.recipesapp.utils

import com.tasty.recipesapp.data.dto.*
import com.tasty.recipesapp.data.models.*



object Mapping {

    @JvmName("toInstructionModel")
    fun InstructionDTO.toModel(): InstructionModel {
        return InstructionModel(
            id = this.id,
            displayText = this.displayText,
            time = InstructionTime(this.startTime,this.endTime),
        )
    }

    @JvmName("toInstructionModelList")
    fun List<InstructionDTO>.toModelList(): List<InstructionModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toTagModel")
    fun TagDTO.toModel(): TagModel {
        return TagModel(
            id = this.id,
            displayName = this.display_name,
            type = this.type,
            rootTagType = this.root_tag_type,
            name = this.name
        )
    }
    @JvmName("toTagModelList")
    fun List<TagDTO>.toModelList(): List<TagModel> {
        return this.map { it.toModel() }
    }


    @JvmName("toPriceModel")
    private fun PriceDTO.toModel(): PriceModel {
        return PriceModel(
            consumptionPortion = this.consumption_portion,
            total = this.total,
            updatedAt = this.updated_at,
            portion = this.portion,
            consumptionTotal = this.consumption_total,
        )
    }

    @JvmName("toPriceModelList")
    fun List<PriceDTO>.toModelList(): List<PriceModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toIngredientModel")
    fun IngredientDTO.toModel(): IngredientModel {
        return IngredientModel(
            created_at = this.created_at,
            display_plural = this.display_plural,
            id = this.id,
            display_singular = this.display_singular,
            updated_at = this.updated_at,
            name = this.name,
        )
    }


    fun List<IngredientDTO>.toModelList(): List<IngredientModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toUserRatingsModel")
    fun UserRatingsDTO.toModel(): UserRatingsModel {
        return UserRatingsModel(
            countPositive = this.countPositive,
            score = this.score,
            countNegative = this.countNegative
        )
    }

    @JvmName("toUserRatingsModelList")
    fun List<UserRatingsDTO>.toModelList(): List<UserRatingsModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toUnitModel")
    fun UnitDTO.toModel(): UnitModel {
        return UnitModel(
            system = this.system,
            name = this.name,
            display_plural = this.display_plural,
            display_singular = this.display_singular,
            abbreviation = this.abbreviation,
        )
    }

    @JvmName("toUnitModelList")
    fun List<UnitDTO>.toModelList(): List<UnitModel> {
        return this.map { it.toModel() }
    }

    @JvmName("MeasurementModel")
    fun MeasurementDTO.toModel(): MeasurementModel {
        return MeasurementModel(
            unit = this.unit.toModel(),
            quantity = this.quantity,
            id = this.id,
        )
    }

    @JvmName("toMeasurementModelList")
    fun List<MeasurementDTO>.toModelList(): List<MeasurementModel> {
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


    @JvmName("toNutritionModelList")
    private fun NutritionDTO.toModel(): NutritionModel {
        return NutritionModel(
            protein = this.protein,
            calories = this.calories,
            fat = this.fat,
            sugar = this.sugar,
            carbohydrates = this.carbohydrates,
            fiber = this.fiber,
            updated_at = this.updated_at
        )
    }
    @JvmName("toNutritionModel")
    fun List<NutritionDTO>.toModelList(): List<NutritionModel> {
        return this.map { it.toModel() }
    }

    @JvmName("toRecipeModel")
    fun RecipeDTO.toModel(): RecipeModel {
        return RecipeModel(
            id = this.id,
            name = this.name,
            description= this.description,
            instructions = instructions.toModelList(),
            price = this.price.toModel(),
            sections = sections.toModelList(),
            nutrition = this.nutrition.toModel(),
            tags = this.tags.toModelList(),
            userRatings = this.userRatings.toModel(),
            thumbnailAltText = this.thumbnailAltText,
            thumbnailUrl = this.thumbnailUrl,
            videoUrl = this.videoUrl
        )
    }

    @JvmName("toRecipeModelList")
    fun List<RecipeDTO>.toModelList(): List<RecipeModel> {
        return this.map { it.toModel() }
    }


    // new recipe

    fun NewRecipeDTO.toModel(): NewRecipeModel {
        return NewRecipeModel(
            id = this.id,
            title = this.title,
            instructions = this.instructions,
            description = this.description,
            ingredients = this.ingredients,
            thumbnailUrl = this.thumbnailUrl,
            videoUrl = this.videoUrl,
        )
    }

    fun List<NewRecipeDTO>.toNewRecipeModelList(): List<NewRecipeModel> {
        return this.map { it.toModel() }
    }


}