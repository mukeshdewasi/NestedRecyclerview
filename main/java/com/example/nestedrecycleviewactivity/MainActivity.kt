package com.example.nestedrecycleviewactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nestedrecycleviewactivity.Data.Category
import com.example.nestedrecycleviewactivity.Data.Movie
import com.example.nestedrecycleviewactivity.adapter.ParentListAdapter
import com.example.nestedrecycleviewactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var categorylist= mutableListOf<Category>()
    var movielist= mutableListOf<Movie>()
    lateinit var parentAdapter:ParentListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        movielist.add(Movie(1, "Avenger","Action", 4.5f, "2020", R.drawable.image1))
        movielist.add(Movie(2, "joker","Action", 4.5f, "2014", R.drawable.joker))
        movielist.add(Movie(3, "Mystery of Forest","Suspence", 4.0f, "2021", R.drawable.image2))
        movielist.add(Movie(4, "Avenger","Action", 4.5f, "2020", R.drawable.image1))
        movielist.add(Movie(5, "joker","Action", 4.5f, "2020", R.drawable.image1))

        movielist.shuffle()
        categorylist.add(Category(1, "BlokBaster", movielist))
        movielist.shuffle()
        categorylist.add(Category(2, "latest & tranding", movielist))
        movielist.shuffle()
        categorylist.add(Category(3, "Hit Movies", movielist))

    parentAdapter= ParentListAdapter(this,categorylist)
        binding.parentRecycleView.layoutManager=LinearLayoutManager(this)
        binding.parentRecycleView.adapter=parentAdapter


    }
}