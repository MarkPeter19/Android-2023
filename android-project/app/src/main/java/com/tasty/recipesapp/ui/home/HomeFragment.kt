package com.tasty.recipesapp.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.FragmentHomeBinding
import kotlin.math.log


class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        //Log.d("onCreate: HomeFragment")
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }





}