package com.example.nestedrecycleviewactivity.Data

data class Category(
    var id :Int,
    var tittle:String,
    var movielist:MutableList<Movie>
)
