package com.example.livevideofromurl

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.livevideofromurl.databinding.ActivityMain2Binding
import com.longdo.mjpegviewer.MjpegView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMain2Binding

    lateinit var showVideoViewModel: ShowVideoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        showVideoViewModel = ViewModelProvider(this).get(ShowVideoViewModel::class.java)

        binding.showViewModel = showVideoViewModel

        showVideoViewModel.setVideoView1(binding.view1, StringContants.VIDEO_URL)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding.view1.stopStream()
    }

}