package com.adrpien.mvvmapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.adrpien.mvvmapp.databinding.FragmentOutputTextBinding

class OutputTextFragment : Fragment() {

    private var _binding: FragmentOutputTextBinding? = null

    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val viewModelProvider = ViewModelProvider(requireActivity()).get(FragmentViewModel::class.java)
        viewModelProvider.getString().observe(this, object: Observer<String>{
            override fun onChanged(t: String?) {
                binding.outputTextView.text = t
            }
        })

        _binding = FragmentOutputTextBinding.inflate(inflater, container, false)
        return binding.root
    }

}