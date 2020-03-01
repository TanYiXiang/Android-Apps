package com.example.clockwatch.ui.main


import android.os.Bundle
import android.os.SystemClock
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.clockwatch.R
import com.example.clockwatch.databinding.StopWatchFragmentBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class StopWatchFragment : Fragment() {

    companion object {
        fun newInstance() = StopWatchFragment()
    }

    private lateinit var viewModel: StopWatchViewModel
    private lateinit var binding: StopWatchFragmentBinding
    private lateinit var startButton: FloatingActionButton
    private lateinit var resetButton: FloatingActionButton
    private lateinit var stopWatch: Chronometer

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.stop_watch_fragment, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StopWatchViewModel::class.java)
        startButton = binding.startButton
        resetButton = binding.resetButton
        stopWatch = binding.stopWatch

        var pauseOffset: Long = 0

        startButton.setOnClickListener {
            if (viewModel.isRunning.value == true) {
                stopWatch.base = SystemClock.elapsedRealtime() - pauseOffset
                stopWatch.start()
                startButton.setImageResource(R.drawable.ic_pause_black_24dp)
                resetButton.isClickable = false
                resetButton.alpha = 0.5F
            } else {
                pauseOffset = viewModel.calculateOffset(stopWatch.base)
                stopWatch.stop()
                startButton.setImageResource(R.drawable.ic_play_arrow_black_24dp)
                resetButton.isClickable = true
                resetButton.alpha = 1.0F
            }
            viewModel.toggleRunning()
        }

        resetButton.setOnClickListener {
            stopWatch.base = SystemClock.elapsedRealtime()
            pauseOffset = 0
        }

    }


}
