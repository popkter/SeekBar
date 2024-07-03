package com.pop.popview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.pop.popview.databinding.ActivityMain2Binding
import com.pop.seekbar.PopSeekBar

class Main2Activity : AppCompatActivity() {


    companion object{
        const val TAG = "Main2Activity"
    }

    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        supportActionBar?.hide()
/*        binding.seekbarTop.apply {

        }*/
        binding.seekbarBottom.apply {
            max = 50
            stretchStep = 150
            maxStretchDistance =70
//            canResponseTouch = true
        }

        binding.red.setOnClickListener {
            binding.seekbarTop.modifyDrawable(trackStartColor = android.graphics.Color.RED)
        }

        binding.green.setOnClickListener {
            binding.seekbarTop.modifyDrawable(trackStartColor = android.graphics.Color.GREEN)
        }

        binding.blue.setOnClickListener {
            binding.seekbarTop.modifyDrawable(trackStartColor = android.graphics.Color.BLUE)
        }

        binding.seekbarBottom.setOnSeekBarChangeListener(object : PopSeekBar.OnPopSeekBarChangeListener{
            override fun onStartTrackingTouch(seekBar: PopSeekBar, mProgress: Int) {
            }

            override fun onStopTrackingTouch(seekBar: PopSeekBar, mProgress: Int) {
            }

            override fun onProgressChanged(seekBar: PopSeekBar, mProgress: Int, fromUser: Boolean) {
//                binding.seekbarTop.modifyDrawable(PopSeekBarDrawable(trackSolidColor = android.graphics.Color.GREEN))
            }
        })

    }
}