package com.example.newsorg.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsorg.databinding.ItemSourceBinding
import com.example.newsorg.model.articel.Article
import com.example.newsorg.model.source.Source

class SourceAdapter (var lisSource : List<Source>):RecyclerView.Adapter<SourceAdapter.ViewHolder>() {
    var onClickso : ((Source)->Unit)? = null
    class ViewHolder(var binding: ItemSourceBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemSourceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.nameSource.text = lisSource[position].name

    }

    override fun getItemCount(): Int {
       return lisSource.size
    }

    fun setListSource(list: List<Source>){
        this.lisSource = list
        notifyDataSetChanged()

        Log.d("HASIL_SOURCE", list.toString())
    }
}