package com.example.seenapaytask.di

data class RecycleModle(
    val item: List<RecycleList>
)
data class RecycleList(
    val title: String?,
    val type: String?,
    val published_date: String?,
    var abstract: String?,
    var baseUrl: Url?
)
data class Url(
    val url: String?
)

