package com.alisamir.mediaapp

import android.graphics.Color
import android.media.MediaDataSource
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alisamir.mediaapp.databinding.ActivityVideoBinding
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

class VideoActivity : AppCompatActivity() {
    lateinit var binding:ActivityVideoBinding
    lateinit var simpleExoPlayer: SimpleExoPlayer
    lateinit var mediaDataSourceFactory: DataSource.Factory
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityVideoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        simpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this)
        mediaDataSourceFactory = DefaultDataSourceFactory(this, Util.getUserAgent(this,"Video player"))
        if(Util.SDK_INT>23){
            val videoSrc = ProgressiveMediaSource.Factory(mediaDataSourceFactory).createMediaSource(Uri.parse("https://s11.dl-vid.org/download/jxptIpCYAJA/mp4/22/1635797899/4c488fc8afbdd2c721af811f5ec9d7f7063f493848c600443650b72644d57aad/1"))
            simpleExoPlayer.prepare(videoSrc,false,false)
            simpleExoPlayer.playWhenReady = true
            binding.videPlayer.player = simpleExoPlayer
            binding.videPlayer.requestFocus()
            binding.videPlayer.setShutterBackgroundColor(Color.TRANSPARENT)
        }


    }
}