package com.alisamir.mediaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SongActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}