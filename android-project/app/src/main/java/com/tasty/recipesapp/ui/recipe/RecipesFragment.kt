package com.tasty.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import com.tasty.recipesapp.databinding.FragmentRecipesBinding
import androidx.lifecycle.Observer


class RecipesFragment : Fragment() {

    private val viewModel: RecipeViewModel by viewModels()

    private lateinit var binding: FragmentRecipesBinding
    private lateinit var adapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SCREENS", "Opened Recipe Screen!")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecipesBinding.inflate(inflater, container, false);
        return binding.root;
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recipes = viewModel.loadRecipesData(requireContext()) //load from file


        val recyclerView: RecyclerView = binding.recyclerView;
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = recipes?.let { RecipeAdapter(it) }
        recyclerView.adapter = adapter

//        viewModel.getAllRecipesFromApi() //load from API

//         Use observe to update UI when data changes
//        viewModel._recipesFromApi.observe(viewLifecycleOwner, Observer { recipes ->
//            adapter = RecipeAdapter(recipes)
//            binding.recyclerView.adapter = adapter
//        })

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Set up search button click listener
//        binding.searchButton.setOnClickListener {
//            val query = binding.searchView.query.toString()
//            // Perform search using the query (you need to implement this method)
//            performSearch(query)
//        }


    }

//    private fun performSearch(query: String) {
//        // Implement the search logic here
//        // Update the RecyclerView adapter with the search results
//        // For example, you might call a function in your ViewModel to get filtered recipes
//        viewModel.getFilteredRecipesFromApi(query).observe(viewLifecycleOwner, Observer { recipes ->
//            adapter.updateData(recipes)
//        })
//    }

}