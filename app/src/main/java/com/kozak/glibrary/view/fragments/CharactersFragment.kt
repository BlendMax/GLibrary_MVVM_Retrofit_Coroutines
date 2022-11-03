package com.kozak.glibrary.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kozak.glibrary.CardAdapter
import com.kozak.glibrary.data.api.ApiInstance
import com.kozak.glibrary.data.api.ApiInterface
import com.kozak.glibrary.data.repository.CharactersRepository
import com.kozak.glibrary.databinding.FragmentCharacterBinding
import com.kozak.glibrary.viewmodel.CharactersViewModel
import com.kozak.glibrary.viewmodel.factories.CharactersViewModelFactory

class CharactersFragment : Fragment() {
    lateinit var binding: FragmentCharacterBinding
    private lateinit var charactersViewModel: CharactersViewModel
    private val adapter = CardAdapter(mutableListOf<String>())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(inflater)
        val apiInterface = ApiInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val charactersRepository = CharactersRepository(apiInterface)
        charactersViewModel = ViewModelProvider(this, CharactersViewModelFactory(charactersRepository))[CharactersViewModel::class.java]
        charactersViewModel.characters.observe(viewLifecycleOwner) {
            initRec(it)
            }

        return binding.root
    }

    fun initRec(array: ArrayList<String>) = with(binding){
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = adapter
        adapter.addCharcter(array)
    }

    companion object {
        @JvmStatic
        fun newInstance() = CharactersFragment()
    }
}