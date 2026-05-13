package com.example.raithavartha.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_articles")
data class NewsArticle(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val titleEn: String,
    val titleKn: String,
    val descriptionEn: String,
    val descriptionKn: String,
    val imageUrl: String,
    val date: String
)
