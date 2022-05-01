package com.adrpien.mvvmapp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.adrpien.mvvmapp.databinding.FragmentInputTextBinding

class InputTextFragment : Fragment() {

    private var _binding: FragmentInputTextBinding? = null
    private val binding: FragmentInputTextBinding
            get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentInputTextBinding.inflate(layoutInflater, container, false)

        //
        val viewModelProvider = ViewModelProvider(requireActivity()).get(FragmentViewModel::class.java)


        binding.inputEditText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModelProvider.setString(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        return binding.root
    }
}