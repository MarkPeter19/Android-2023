package com.tasty.recipesapp.ui.profile

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.database.entities.RecipeEntity
import com.tasty.recipesapp.providers.RepositoryProvider
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel() {

    private val _recipeModels = MutableLiveData<List<RecipeModel>>()
    val recipeModels: LiveData<List<RecipeModel>> = _recipeModels

    //Function to load data from the repository
    fun loadRecipeData(context: Context) {
        val data = RepositoryProvider.recipesRepository.getAll(context)
        _recipeModels.value = data
    }
    fun insertRecipe(recipe: RecipeEntity) {
        viewModelScope.launch {
            repository.insertRecipe(recipe)
        }
    }


}