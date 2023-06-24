package com.example.nestedrecycleviewactivity.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.nestedrecycleviewactivity.Data.Category
import com.example.nestedrecycleviewactivity.databinding.ChildLayoutBinding
import com.example.nestedrecycleviewactivity.databinding.ParentLayoutBinding

class ParentListAdapter(var context: Context, var Categorylist:MutableList<Category>):RecyclerView.Adapter<ParentListAdapter.MyViewHolder>(){
        lateinit var binding :ParentLayoutBinding
    class MyViewHolder(var bind:ParentLayoutBinding):RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding=ParentLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
}

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      var category=Categorylist[position]
        holder.bind.tvTittel.text="${category.tittle}"

        var childAdapter=ChildListAdapter(context,category.movielist)
        holder.bind.childRecycleview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        holder.bind.childRecycleview.adapter=childAdapter

        holder.bind.btnView.setOnClickListener {
            Toast.makeText(context,"${category.tittle}",Toast.LENGTH_SHORT).show()
        }



    }

    override fun getItemCount(): Int {
        return Categorylist.size
    }

}


