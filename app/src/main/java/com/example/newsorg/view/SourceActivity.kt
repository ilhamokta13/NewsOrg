package com.example.newsorg.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsorg.adapter.SourceAdapter
import com.example.newsorg.databinding.ActivitySourceBinding
import com.example.newsorg.viewmodel.SourceViewModel

class SourceActivity : AppCompatActivity() {
    lateinit var binding : ActivitySourceBinding
    lateinit var sourceAdapter: SourceAdapter
    lateinit var sourceVm : SourceViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySourceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sourceAdapter = SourceAdapter(ArrayList())

        sourceVm = ViewModelProvider(this).get(SourceViewModel::class.java)

        binding.rvSource.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val bundle = intent.extras
        val getCategory = bundle?.getString("name", "").toString()

        sourceVm.callApiSource(getCategory)
        binding.rvSource.adapter = sourceAdapter

        sourceVm.getDataSource().observe(this, Observer {
            if(it != null){
                sourceAdapter.setListSource(it)
            }
        })

        sourceAdapter.onClickso = {
            var bundle = Bundle().apply {
                putString("sources", it.name)
            }
            var intent = Intent(this, ArticleActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }



    }


}