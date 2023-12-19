package com.tasty.recipesapp.repositories


import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tasty.recipesapp.data.dto.NewRecipeDTO
import com.tasty.recipesapp.data.dto.RecipeDTO
import com.tasty.recipesapp.data.models.NewRecipeModel
import com.tasty.recipesapp.data.models.RecipeModel
import com.tasty.recipesapp.utils.Mapping.toModel
import com.tasty.recipesapp.utils.Mapping.toRecipeModelList
import com.tasty.recipesapp.database.entities.RecipeEntity
import com.tasty.recipesapp.database.daos.RecipeDao
import com.tasty.recipesapp.database.dataBases.RecipeDatabase
import com.tasty.recipesapp.services.RecipeApiClient
import org.json.JSONObject
import java.io.IOException

class RecipesRepository(private val recipeDao: RecipeDao) : IGenericRepository<RecipeModel> {

    //initalize RecipeApiClient
    private val recipeApiClient = RecipeApiClient()

    suspend fun getRecipesFromApi(
        from: String,
        size: String,
        tags: String? = null
    ): List<RecipeModel> {
        // You can call the suitable method from the API client here
        // For example, if your RecipeApiClient has a method named getRecipes,
        // you can use it like this:
        return recipeApiClient.getRecipes(from, size, tags)?.recipes ?: emptyList()
    }




    //insert
    suspend fun insertRecipe(recipe: RecipeEntity) {
        recipeDao.insertRecipe(recipe)
    }

    //delete
    suspend fun deleteRecipe(recipe: RecipeEntity) {
        recipeDao.deleteRecipe(recipe)
    }

    // get recipies from database
    suspend fun getAllRecipes(): List<Unit> {
        return recipeDao.getAllRecipes().map {
            val jsonObject = JSONObject(it.json)
            jsonObject.apply { put("id", it.internalId) }
            val gson = Gson()
            gson.fromJson(jsonObject.toString(), NewRecipeDTO::class.java).toModel()
        }
    }

    //get all created recipes (profileViewModel)
    suspend fun getAllOwnRecipes(): List<NewRecipeModel> {
        return recipeDao.getAllRecipes().map {
            val jsonObject = JSONObject(it.json)
            jsonObject.apply { put("id", it.internalId) }
            val gson = Gson()
            gson.fromJson(jsonObject.toString(), NewRecipeDTO::class.java).toModel()
        }
    }

    suspend fun getRecipeById(recipeId: Long): NewRecipeModel? {
        val recipeEntity = recipeDao.getRecipeById(recipeId)
        return recipeEntity?.let {
            val jsonObject = JSONObject(it.json)
            jsonObject.put("id", it.internalId)
            val gson = Gson()
            gson.fromJson(jsonObject.toString(), NewRecipeDTO::class.java).toModel()
        }
    }



    //read data form json file
    override fun getAll(context: Context): List<RecipeModel> {
        return readFromAssets(context).toRecipeModelList()
    }

    fun readFromAssets(context: Context): List<RecipeDTO> {
        val gson = Gson()
        var recipeList = listOf<RecipeDTO>()
        val assetManager = context.assets
        try {
            val inputStream = assetManager.open("recipesData.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            val jsonString = String(buffer, Charsets.UTF_8)

            val jsonObject = JSONObject(jsonString)
            val recipesArray = jsonObject.getJSONArray("results")

            val type = object : TypeToken<List<RecipeDTO>>() {}.type
            recipeList = gson.fromJson(recipesArray.toString(), type)

            Log.i("GSON", recipeList.toString())
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return recipeList
    }
}