package com.kozak.glibrary.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.kozak.glibrary.R
import com.kozak.glibrary.databinding.FragmentStartBinding


class StartFragment : Fragment() {
    lateinit var binding: FragmentStartBinding
    lateinit var array: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater)

        binding.tvCharacters.setOnClickListener{
            it.findNavController().navigate(R.id.action_startFragment_to_characterFragment)
        }
        binding.tvArtifacts.setOnClickListener{
            it.findNavController().navigate(R.id.action_startFragment_to_artifactsFragment)
        }
        binding.tvWeapons.setOnClickListener{
            it.findNavController().navigate(R.id.action_startFragment_to_weaponsFragment)
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = StartFragment()
    }
}