package com.tasty.recipesapp.ui.recipe

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.RecipeModel
import java.util.concurrent.Executors
import com.tasty.recipesapp.data.models.ascendingComparator
import com.tasty.recipesapp.data.models.descendingComparator
import kotlin.coroutines.coroutineContext



interface OnAddToFavoritesClickListener {
    fun onAddToFavoritesClick(recipe: RecipeModel)
}


class RecipeAdapter(private var recipes: List<RecipeModel>, private val onAddToFavoritesClickListener: OnAddToFavoritesClickListener, private val context: Context) :


    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private var filteredRecipes: List<RecipeModel> = recipes
    private lateinit var onAddToFavoritesClick: (RecipeModel) -> Unit
    private var originalList: List<RecipeModel> = recipes

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val recipeTitle: TextView = itemView.findViewById(R.id.recipeTitle)
        val recipeImage: ImageView = itemView.findViewById(R.id.recipeImage)
        //val addToFavorites: Button = itemView.findViewById(R.id.addToFavoritesButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = filteredRecipes[position]
        holder.recipeTitle.text = recipe.name

//        holder.addToFavorites.setOnClickListener{
//            onAddToFavoritesClickListener.onAddToFavoritesClick(recipe)
//            Toast.makeText(context,"Recipe Added to Favorites", Toast.LENGTH_SHORT).show()
//        }

        holder.itemView.setOnClickListener { view ->
            val action: NavDirections = object : NavDirections {

                override val actionId: Int
                    get() = R.id.action_recipesFragment_to_recipeDetailFragment
                override val arguments: Bundle
                    get() = bundleOf(
                        "arg_recipe_id" to recipe.id,
                        "arg_recipe_title" to recipe.name,
                        "arg_recipe_description" to recipe.description,
                        "arg_recipe_image" to recipe.thumbnailUrl,
                        "arg_recipe_instructions" to recipe.instructions
                    )
            }
            view.findNavController().navigate(action)
        }


        // Load recipe image using Glide
        Glide.with(holder.itemView.context)
            .load(recipe.thumbnailUrl)
            .placeholder(R.drawable.baseline_cookie_24) // Placeholder image if loading fails
            .into(holder.recipeImage)
    }

    override fun getItemCount(): Int {
        return filteredRecipes.size
    }




    // Function to perform search
    fun search(query: CharSequence?) {
        if(query.isNullOrBlank()) {
            setOriginalList(originalList)
        }
        updateFilteredList(query.toString())
    }
    fun setOriginalList(list: List<RecipeModel>) {
        filteredRecipes = list
        updateFilteredList("")
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateFilteredList(query: String) {
        filteredRecipes = if (query.isBlank()) {
            originalList
        } else {
            originalList.filter { recipe ->
                // Check if the recipe name contains the query as a whole word or subword
                recipe.name.contains(query, ignoreCase = true) ||
                        recipe.name.split("\\s+".toRegex()).any { it.contains(query, ignoreCase = true) }
            }
        }
        notifyDataSetChanged()
    }


    @SuppressLint("NotifyDataSetChanged")
    fun sort(ascending: Boolean) {
        Log.d("SORT", "sort: "+  ascending)
        val comparator = if (ascending) ascendingComparator else descendingComparator
        filteredRecipes = filteredRecipes.sortedWith(comparator)
        notifyDataSetChanged()
    }


}

