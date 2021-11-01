package com.alisamir.mediaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.alisamir.mediaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.songBtn.setOnClickListener {
            startActivity(Intent(this,SongActivity::class.java))
        }
        binding.videosBtn.setOnClickListener {
            startActivity(Intent(this,VideoActivity::class.java))
        }
        binding.subBtn.setOnClickListener {
            val webUrl = binding.webUrlEdit.text
            if (!Patterns.WEB_URL.equals(webUrl)){
                binding.webUrlEdit.setError("Enter Valid URL")
                binding.webUrlEdit.requestFocus()
            }else{
                val intent = Intent(this,webActivity::class.java)
                intent.putExtra("Url",webUrl)
                startActivity(intent)
            }
        }
    }
}