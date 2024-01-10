package com.tasty.recipesapp.ui.recipe

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.providers.RepositoryProvider
import com.tasty.recipesapp.services.RecipeApiClient
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    var recipeData = MutableLiveData<List<RecipeModel>>()

    //load data from file
//    fun loadRecipesFromAssets(context: Context): List<RecipeModel>? {
//        return RepositoryProvider.recipeRepository.getAllFromFile(context)
//    }


    //load data from API
    fun getAllRecipesFromApi() {
        viewModelScope.launch {
            recipeData.value = RepositoryProvider.recipeRepository.getRecipesFromApi("0", "15","")
        }
    }

}