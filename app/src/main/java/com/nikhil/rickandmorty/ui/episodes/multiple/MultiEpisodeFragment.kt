package com.nikhil.rickandmorty.ui.episodes.multiple

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nikhil.rickandmorty.R
import com.nikhil.rickandmorty.databinding.FragmentCharacterListBinding
import com.nikhil.rickandmorty.databinding.FragmentMultiCharacterBinding
import com.nikhil.rickandmorty.databinding.FragmentMultiEpisodeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MultiEpisodeFragment : Fragment() {

    private var _binding: FragmentMultiEpisodeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMultiEpisodeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}