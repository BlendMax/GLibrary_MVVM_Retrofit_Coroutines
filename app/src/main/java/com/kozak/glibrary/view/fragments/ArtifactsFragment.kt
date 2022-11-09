package com.kozak.glibrary.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kozak.glibrary.CardAdapter
import com.kozak.glibrary.data.api.ApiInstance
import com.kozak.glibrary.data.api.ApiInterface
import com.kozak.glibrary.data.repository.ArtifactsRepository
import com.kozak.glibrary.databinding.FragmentArtifactsBinding
import com.kozak.glibrary.viewmodel.ArtifactsViewModel
import com.kozak.glibrary.viewmodel.factories.ArtifactsViewModelFactory

class ArtifactsFragment : Fragment() {
    lateinit var binding: FragmentArtifactsBinding
    private lateinit var artifactsViewModel: ArtifactsViewModel
    private val adapter = CardAdapter(mutableListOf<String>())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentArtifactsBinding.inflate(inflater)
        val artifactsRepository = ArtifactsRepository(ApiInstance.getRetrofitInstance().create(ApiInterface::class.java))
        artifactsViewModel = ViewModelProvider(this, ArtifactsViewModelFactory(artifactsRepository))[ArtifactsViewModel::class.java]
        artifactsViewModel.artifacts.observe(viewLifecycleOwner){
            initRecyclerView(it)
            Log.d("MyLog", it.toString())
        }
        return binding.root
    }

    private fun initRecyclerView(array: ArrayList<String>) = with(binding){
        recViewArtifacts.layoutManager = LinearLayoutManager(context)
        recViewArtifacts.adapter = adapter
        adapter.addCharcter(array)
    }

    companion object {
        @JvmStatic
        fun newInstance() = ArtifactsFragment()
    }
}