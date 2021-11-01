package com.alisamir.mediaapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.SeekBar
import com.alisamir.mediaapp.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {
    lateinit var binding:ActivitySongBinding
    lateinit var mediaPlayer: MediaPlayer
    val handler: Handler = Handler()
    lateinit var runnable: Runnable
    //var isPlaying = false
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySongBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        var seekValue:Int = 0
        mediaPlayer = MediaPlayer.create(this,R.raw.bad_liar)
        binding.seekBar.max = mediaPlayer.duration
        binding.seekBar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                seekValue = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                mediaPlayer.seekTo(seekValue)
            }

        })
        binding.playImg.setOnClickListener {
            if(!mediaPlayer.isPlaying){
                binding.playImg.setImageResource(R.drawable.ic_baseline_pause_circle_outline_24)
                mediaPlayer.start()
                handler.post(runnable)
            }else{
                binding.playImg.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
                mediaPlayer.pause()
            }
        }
        binding.repeatImg.setOnClickListener {

                mediaPlayer.seekTo(0)
                binding.seekBar.progress = 0

        }
        binding.stopImg.setOnClickListener {
            mediaPlayer.stop()
            mediaPlayer.prepare()
            binding.playImg.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
        }
        mediaPlayer.setOnCompletionListener {
            binding.seekBar.progress = 0
            handler.removeCallbacksAndMessages(null);
            binding.playImg.setImageResource(R.drawable.ic_baseline_play_circle_outline_24)
        }
        runnable = Runnable {

            binding.seekBar.progress = mediaPlayer.currentPosition
            handler.postDelayed(runnable,1000)
        }




    }

}