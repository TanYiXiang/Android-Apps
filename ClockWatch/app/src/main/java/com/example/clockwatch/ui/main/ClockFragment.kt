package com.example.clockwatch.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.clockwatch.R
import com.example.clockwatch.databinding.ClockFragmentBinding



class ClockFragment : Fragment() {

    companion object {
        fun newInstance() = ClockFragment()
    }

    private lateinit var viewModel: ClockFragmentViewModel
    private lateinit var binding: ClockFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.clock_fragment,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ClockFragmentViewModel::class.java)

        viewModel.timeZoneString.observe(viewLifecycleOwner, Observer { currentTimeZone->
            binding.locationText.text = currentTimeZone.toString()
        })

        viewModel.dateString.observe(viewLifecycleOwner, Observer { currentDate->
            binding.dateText.text = currentDate.toString()
        })


    }


}
