package com.example.musicwiki.screens.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.musicwiki.R
import com.example.musicwiki.adapters.TopGenreAdapter
import com.example.musicwiki.databinding.ActivityMainBinding
import com.example.musicwiki.models.response.genres.TagItem
import com.example.musicwiki.repository.Repository
import com.example.musicwiki.viewmodels.MainViewModel
import com.example.musicwiki.viewmodels.FactoryMainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var genreAdapter: TopGenreAdapter
    private lateinit var viewModel: MainViewModel

    var openList = false
    var tagList: MutableList<TagItem> =  arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        genreAdapter = TopGenreAdapter(this)
        initRv()



        val repository = Repository()
        val viewModelFactory = FactoryMainViewModel(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.topTagResponse.observe(this) { tags ->
            initRv()
            tagList= tags as MutableList<TagItem>
            genreAdapter.genres = tags
        }


       binding.btnDropDown.setOnClickListener{

            if(openList){
                openList = false
                binding.btnDropDown.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24))
                genreAdapter.updateDataset(tagList.subList(0,10))
            }else{
                openList = true
                binding.btnDropDown.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_keyboard_arrow_up_24))
                genreAdapter.updateDataset(tagList)
            }

        }
    }

    private fun initRv() = binding.genereRecyclerView.apply {
        adapter = genreAdapter
        layoutManager = GridLayoutManager(this@MainActivity,2)
        binding.genereRecyclerView.layoutManager=layoutManager

    }


}