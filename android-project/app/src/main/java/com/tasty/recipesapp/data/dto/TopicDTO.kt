package com.tasty.recipesapp.data.dto

import com.google.gson.annotations.SerializedName

data class TopicDTO(
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val slug: String
)
