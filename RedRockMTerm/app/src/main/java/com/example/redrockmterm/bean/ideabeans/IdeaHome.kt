package com.example.redrockmterm.bean.ideabeans

data class IdeaHome(
    val code: Int,
    val `data`: List<DataIdea>,
    val message: String
)

data class DataIdea(
    val id: Int,
    val image: String,
    val name: String
)