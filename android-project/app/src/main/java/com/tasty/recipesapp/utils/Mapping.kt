package com.tasty.recipesapp.utils

import com.tasty.recipesapp.data.dto.*
import com.tasty.recipesapp.data.models.*



object Mapping {
    fun InstructionDTO.toModel(): InstructionModel {
        return InstructionModel(
            id = this.id,
            displayText = this.displayText,
            time = InstructionTime(this.startTime, this.endTime)
        )
    }

    fun List<InstructionDTO>.toInstructionModelList(): List<InstructionModel> {
        return this.map { it.toModel() }
    }

    fun TagDTO.toModel(): TagModel {
        return TagModel(
            displayName = this.displayName
        )
    }

    fun List<TagDTO>.toTagModelList(): List<TagModel> {
        return this.map { it.toModel() }
    }

    fun CreditDTO.toModel(): CreditModel {
        return CreditModel(
            name = this.name
        )
    }

    fun List<CreditDTO>.toCreditModelList(): List<CreditModel> {
        return this.map { it.toModel() }
    }

    fun IngredientDTO.toModel(): IngredientModel {
        return IngredientModel(
            name = this.name
        )
    }

    fun List<IngredientDTO>.toIngredientModelList(): List<IngredientModel> {
        return this.map { it.toModel() }
    }

    fun UserRatingsDTO.toModel(): UserRatingsModel {
        return UserRatingsModel(
            countPositive = this.countPositive,
            countNegative = this.countNegative
        )
    }

    fun List<UserRatingsDTO>.toUserRatingsModelList(): List<UserRatingsModel> {
        return this.map { it.toModel() }
    }

    fun UnitDTO.toModel(): UnitModel {
        return UnitModel(
            displaySingular = this.displaySingular,
            name = this.name,
            displayPlural = this.displayPlural
        )
    }

    fun List<UnitDTO>.toUnitModelList(): List<UnitModel> {
        return this.map { it.toModel() }
    }

    fun MeasurementDTO.toModel(): MeasurementModel {
        return MeasurementModel(
            unit = this.unit.toModel(),
            quantity = this.quantity
        )
    }

    fun List<MeasurementDTO>.toMeasurementModelList(): List<MeasurementModel> {
        return this.map { it.toModel() }
    }

    fun ComponentDTO.toModel(): ComponentModel {
        return ComponentModel(
            measurements = this.measurements.toMeasurementModelList(),
            rawText = this.rawText,
            ingredient = this.ingredient.toModel(),
        )
    }

    fun List<ComponentDTO>.toComponentModelList(): List<ComponentModel> {
        return this.map { it.toModel() }
    }

    fun SectionDTO.toModel(): SectionModel {
        return SectionModel(
            components = this.components.toComponentModelList(),
            name = this.name
        )
    }

    fun List<SectionDTO>.toSectionModelList(): List<SectionModel> {
        return this.map { it.toModel() }
    }

    fun TopicDTO.toModel(): TopicModel {
        return TopicModel(
            name = this.name
        )
    }

    fun List<TopicDTO>.toTopicModelList(): List<TopicModel> {
        return this.map { it.toModel() }
    }

    fun NutritionDTO.toModel(): NutritionModel {
        return NutritionModel(
            carbohydrates = this.carbohydrates,
            fiber = this.fiber,
            protein = this.protein,
            fat = this.fat,
            calories = this.calories,
            sugar = this.sugar
        )
    }

    fun List<NutritionDTO>.toNutritionModelList(): List<NutritionModel> {
        return this.map { it.toModel() }
    }

    fun RecipeDTO.toModel(): RecipeModel {
        return RecipeModel(
            tags = this.tags.toTagModelList(),
            thumbnailUrl = this.thumbnailUrl,
            originalVideoUrl = this.originalVideoUrl,
            userRatings = this.userRatings.toModel(),
            sections = this.sections.toSectionModelList(),
            name = this.name,
            videoUrl = this.videoUrl,
            nutrition = this.nutrition.toModel(),
            topics = this.topics.toTopicModelList(),
            instructions = this.instructions.toInstructionModelList(),
            credits = this.credits.toCreditModelList(),
            description = this.description,
            numServings = this.numServings
        )
    }

    fun List<RecipeDTO>.toRecipeModelList(): List<RecipeModel> {
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