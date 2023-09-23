package com.example.themovieapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.themovieapp.R
import com.example.themovieapp.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment() {

    lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return FragmentFavoriteBinding.inflate(inflater).also {
            binding = it
        }.root
    }


    }
