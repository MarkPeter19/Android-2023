package com.tasty.recipesapp.ui.recipe

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.tasty.recipesapp.R
import com.tasty.recipesapp.database.daos.RecipeDao
import com.tasty.recipesapp.database.dataBases.RecipeDatabase
import com.tasty.recipesapp.database.entities.RecipeEntity
import com.tasty.recipesapp.databinding.FragmentNewRecipeBinding
import com.tasty.recipesapp.providers.RepositoryProvider
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject

class NewRecipeFragment : Fragment(){

    private lateinit var binding : FragmentNewRecipeBinding
    private lateinit var recipeDao: RecipeDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        RepositoryProvider.initialize(context)
        recipeDao = RecipeDatabase.getDatabase(requireContext()).recipeDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflate the layout for this fragment
        val binding = FragmentNewRecipeBinding.inflate(inflater, container, false)

        val linearLayoutIngredient = binding.layoutIngredients
        val linearLayoutInstruction = binding.layoutInstructions

        //add buttons
        val addIngredientButton = binding.addIngredientButton
        val addInstructionButton = binding.addInstructionButton

        addIngredientButton.setOnClickListener {
            addNewEditText(linearLayoutIngredient, "Enter ingredient")
        }

        addInstructionButton.setOnClickListener {
            addNewEditText(linearLayoutInstruction, "Enter instruction")
        }

        //save button
        val saveRecipeButton = binding.saveRecipeButton
        saveRecipeButton.setOnClickListener {
            viewLifecycleOwner.lifecycleScope.launch {
                saveRecipeToDatabase(binding) //save to db
                Toast.makeText(requireContext(), "Recipe saved", Toast.LENGTH_SHORT).show() //message
                findNavController().navigate(R.id.action_newRecipeFragment_to_profileFragment)  //navigation
            }
        }


        return binding.root
    }

    private suspend fun saveRecipeToDatabase(binding: FragmentNewRecipeBinding) {

        //get inputs from edit text
        val title = binding.recipeTitle.text.toString()
        val description = binding.recipeDescription.text.toString()
        val pictureURL = binding.recipePictureURL.text.toString()
        val videoURL = binding.recipeVideoURL.text.toString()

        val ingredients = mutableListOf<String>()
        for (i in 0 until binding.layoutIngredients.childCount) {
            val editText = binding.layoutIngredients.getChildAt(i) as? EditText
            editText?.let {
                ingredients.add(it.text.toString())
            }
        }

        val instructions = mutableListOf<String>()
        for (i in 0 until binding.layoutInstructions.childCount) {
            val editText = binding.layoutInstructions.getChildAt(i) as? EditText
            editText?.let {
                instructions.add(it.text.toString())
            }
        }

        //format to json
        val recipe = createJsonFromInputs(title, description, pictureURL, videoURL, ingredients, instructions)
        val recipeEntity = RecipeEntity(
            json = recipe
        )

        //save new recipe to db using repository provider
        viewLifecycleOwner.lifecycleScope.launch {
            RepositoryProvider.recipeRepository.insertRecipe(recipeEntity)
        }
    }

    private fun createJsonFromInputs(title: String, description: String, pictureUrl: String, videoUrl: String, ingredients: List<String>, instructions: List<String>): String {
        val jsonObject = JSONObject()
        jsonObject.put("title", title)
        jsonObject.put("description", description)
        jsonObject.put("pictureUrl", pictureUrl)
        jsonObject.put("videoUrl", videoUrl)
        jsonObject.put("ingredients", JSONArray(ingredients))
        jsonObject.put("instructions", JSONArray(instructions))

        return jsonObject.toString()
    }

    //add new editText function dynamically
    private fun addNewEditText(linearLayout: LinearLayout, hint: String) {
        val editText = EditText(context)
        editText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        editText.hint = hint
        editText.textSize = 16f

        linearLayout.addView(editText)
    }

}