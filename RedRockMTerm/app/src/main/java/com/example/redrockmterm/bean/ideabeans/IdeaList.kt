package com.example.redrockmterm.bean.ideabeans

data class IdeaList(
    val code: Int,
    val `data`: List<DataIdeaList>,
    val message: String
)

data class DataIdeaList(
    val ideaDetail: Int
)