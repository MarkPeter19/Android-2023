package com.tasty.recipesapp.ui.recipe

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.RecipeModel
import java.util.concurrent.Executors

class RecipeAdapter(private val recipes: List<RecipeModel>) :


    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val recipeTitle: TextView = itemView.findViewById(R.id.recipeTitle)
        val recipeImage: ImageView = itemView.findViewById(R.id.recipeImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.recipeTitle.text = recipe.name

        holder.itemView.setOnClickListener { view ->
            val action: NavDirections = object : NavDirections {

                override val actionId: Int
                    get() = R.id.action_recipesFragment_to_recipeDetailFragment
                override val arguments: Bundle
                    get() = bundleOf(
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
//            .error(R.drawable.error_image) // Image to show if there's an error
            .into(holder.recipeImage)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}

