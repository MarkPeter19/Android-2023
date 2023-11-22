package com.tasty.recipesapp.data.dto

import com.google.gson.annotations.SerializedName

data class SectionDTO(
    @SerializedName("components")
    val components: List<ComponentDTO>,
    @SerializedName("name")
    val name: String?,
    @SerializedName("position")
    val position: Int
)
