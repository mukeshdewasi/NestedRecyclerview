package com.example.nestedrecycleviewactivity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecycleviewactivity.Data.Movie
import com.example.nestedrecycleviewactivity.databinding.ChildLayoutBinding

class ChildListAdapter(var context: Context, var movielist:MutableList<Movie>) :RecyclerView.Adapter<ChildListAdapter.MyViewHolder> (){
    lateinit var binding:ChildLayoutBinding
    class MyViewHolder(var bind:ChildLayoutBinding):RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding= ChildLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
     var movie=movielist[position]
        holder.bind.tvImage.setImageResource(movie.image)
    }

    override fun getItemCount(): Int {
    return movielist.size
    }
}