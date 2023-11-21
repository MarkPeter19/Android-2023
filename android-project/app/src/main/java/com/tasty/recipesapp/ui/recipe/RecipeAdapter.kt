package com.tasty.recipesapp.ui.recipe



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tasty.recipesapp.R
import com.tasty.recipesapp.data.models.RecipeModel

class RecipeAdapter(
    private val recipes: List<RecipeModel>,
    private val onItemClick: (RecipeModel) -> Unit,
    private val onDetailsClick: (RecipeModel) -> Unit
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recipeImageView: ImageView = itemView.findViewById(R.id.RecipeImageView)
        val textRecipeName: TextView = itemView.findViewById(R.id.textRecipeName)
        val textRecipeDescription: TextView = itemView.findViewById(R.id.textRecipeDescription)
        // Add TextViews for other details if needed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]

        // Load image using a library like Glide or Picasso
        // Example with Glide:
//        Glide.with(holder.itemView.context)
//            .load(recipe.show.thumbnail_url)
//            .into(holder.recipeImageView)

        holder.textRecipeName.text = recipe.name
        holder.textRecipeDescription.text = recipe.description
        // Add other recipe details to UI elements here

        holder.itemView.setOnClickListener { onItemClick(recipe) }
        // You can set onLongClickListener or other listeners as needed
    }

    override fun getItemCount(): Int {
        return recipes.size
    }
}
