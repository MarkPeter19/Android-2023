package com.tasty.recipesapp.data.models

data class TagModel(
    val display_name: String,
    val type: String,
    val id: Int,
    val name: String,
    val root_tag_type: String,
)
