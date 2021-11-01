package com.alisamir.mediaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.alisamir.mediaapp.databinding.ActivityWebBinding
import java.net.URL

class webActivity : AppCompatActivity() {
    lateinit var binding: ActivityWebBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityWebBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.webView.loadUrl(intent.getStringExtra("Url").toString())
        binding.webView.webViewClient = WebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.builtInZoomControls = true
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack()){
            binding.webView.goBack()
        }else{
            super.onBackPressed()
        }

    }
}