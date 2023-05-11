package com.example.newsorg.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsorg.R
import com.example.newsorg.adapter.CategoryAdapter
import com.example.newsorg.databinding.ActivityCategoryBinding
import com.example.newsorg.model.CategoryData

class CategoryActivity : AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding
    lateinit var category : CategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listCategory = arrayListOf(
            CategoryData("BUSINESS",R.drawable.business),
            CategoryData("ENTERTAINMENT",R.drawable.entertainment),
            CategoryData("GENERAL",R.drawable.general),
            CategoryData("HEALTH",R.drawable.health),
            CategoryData("SCIENCE",R.drawable.science),
            CategoryData("SPORTS",R.drawable.sports),
            CategoryData("TECHNOLOGY",R.drawable.technology)
        )

        category = CategoryAdapter(listCategory)
        binding.rvCategory.apply {
            layoutManager =LinearLayoutManager(this@CategoryActivity, LinearLayoutManager.VERTICAL,false)
            adapter = category

            category.onClick={
                var categ = it.name
                val intent = Intent(context,SourceActivity::class.java)
                intent.putExtra("name", categ)
                startActivity(intent)
            }

        }

    }
}