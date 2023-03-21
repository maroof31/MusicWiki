package com.example.musicwiki.screens.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.musicwiki.adapters.AdapterArtists
import com.example.musicwiki.databinding.FragmentGenreArtistsBinding
import com.example.musicwiki.repository.Repository
import com.example.musicwiki.viewmodels.MainViewModel
import com.example.musicwiki.viewmodels.FactoryMainViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [GenreArtistsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GenreArtistsFragment(name: String) : Fragment() {

    val sname=name
    private lateinit var binding: FragmentGenreArtistsBinding
    private lateinit var genreArtistsAdapter: AdapterArtists
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenreArtistsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = FactoryMainViewModel(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTagTopArtists(sname.toString())
        viewModel.tagTopArtistsResposne.observe(viewLifecycleOwner) { topArtists ->
            setupRecyclerView()
            genreArtistsAdapter.genreArtists = topArtists
        }

    }

    private fun setupRecyclerView() =binding.artistsRv.apply {
        genreArtistsAdapter = AdapterArtists(context)
        adapter = genreArtistsAdapter
        layoutManager = GridLayoutManager(context,2)
    }

}