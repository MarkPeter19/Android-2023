package com.tasty.recipesapp.data.dto

import com.google.gson.annotations.SerializedName

data class UnitDTO(
    @SerializedName("display_singular")
    val displaySingular: String,
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("system")
    val system: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("display_plural")
    val displayPlural: String
)
