package com.tasty.recipesapp.data.dto

import com.google.gson.annotations.SerializedName

data class TagDTO(
    @SerializedName("root_tag_type")
    val rootTagType: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("display_name")
    val displayName: String,
    @SerializedName("type")
    val type: String
)
