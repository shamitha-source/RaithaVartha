package com.example.raithavartha.data.model

data class Crop(
    val id: Int,
    val nameEn: String,
    val nameKn: String,
    val suggestionsEn: List<String>,
    val suggestionsKn: List<String>,
    val imageUrl: String
)
