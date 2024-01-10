package com.tasty.recipesapp.providers

import android.content.Context
import com.tasty.recipesapp.repositories.RecipesRepository
import com.tasty.recipesapp.database.daos.RecipeDao
import com.tasty.recipesapp.database.dataBases.RecipeDatabase
import com.tasty.recipesapp.repositories.PreferencesManager


object RepositoryProvider {
    private lateinit var recipeDao: RecipeDao
    lateinit var preferencesManager : PreferencesManager
    fun initialize(context: Context) {
        recipeDao = RecipeDatabase.getDatabase(context).recipeDao()
    }
    fun initaliazePreferencesManager(context: Context) {
        preferencesManager = PreferencesManager(context)
    }

    val recipeRepository: RecipesRepository by lazy {
        checkInitialized()
        RecipesRepository(recipeDao)
    }

    private fun checkInitialized() {
        if (!::recipeDao.isInitialized) {
            throw UninitializedPropertyAccessException("RepositoryProvider has not been initialized")
        }
    }


}