package com.tasty.recipesapp.ui.profile

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.google.gson.Gson
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.NewRecipeModel
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.database.entities.RecipeEntity
import com.tasty.recipesapp.providers.RepositoryProvider
import com.tasty.recipesapp.ui.recipe.NewRecipeDetailFragment
import kotlinx.coroutines.launch

class ProfileViewModel() : ViewModel(){

    private val _allRecipes = MutableLiveData<List<NewRecipeModel>>()

    val allRecipes: LiveData<List<NewRecipeModel>>
        get() = _allRecipes

    suspend fun getAllRecipes(){
        viewModelScope.launch {
            val recipes = RepositoryProvider.recipeRepository.getAllOwnRecipes()
            _allRecipes.value = recipes
        }
    }

    fun insertRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            RepositoryProvider.recipeRepository.insertRecipe(recipe)
        }
    }

    fun removeRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            RepositoryProvider.recipeRepository.deleteRecipe(recipe)
            _allRecipes.value = RepositoryProvider.recipeRepository.getAllOwnRecipes()
        }
    }

}