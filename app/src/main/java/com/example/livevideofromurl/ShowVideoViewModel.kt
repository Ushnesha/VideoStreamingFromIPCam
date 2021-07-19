package com.example.livevideofromurl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.longdo.mjpegviewer.MjpegView

class ShowVideoViewModel : ViewModel() {

    fun setVideoView1(view : MjpegView, url : String) {
        view.mode = MjpegView.MODE_FIT_WIDTH
        view.isAdjustHeight = true
        view.supportPinchZoomAndPan = true
        view.setUrl(url)
        startStream(view)
    }

    private fun startStream(view: MjpegView) {
        Log.i("ShowVideoViewModel", "Stream is started")
        view.startStream()
    }

    fun onRefresh(view: MjpegView){
        view.stopStream()
        Log.i("ShowVideoViewModel", "Stream is stopped")
        view.startStream()
        Log.i("ShowVideoViewModel", "Stream is started again")
    }

}
