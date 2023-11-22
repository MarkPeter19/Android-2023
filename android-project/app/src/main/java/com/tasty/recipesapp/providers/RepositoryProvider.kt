package com.tasty.recipesapp.providers


import com.tasty.recipesapp.data.repositories.InstructionsRepository
import com.tasty.recipesapp.data.repositories.RecipesRepository

object RepositoryProvider {
    val instructionsRepository: InstructionsRepository = InstructionsRepository()
    val recipesRepository: RecipesRepository = RecipesRepository()
}