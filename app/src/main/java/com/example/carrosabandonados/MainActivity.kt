package com.example.carrosabandonados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        actionBar?.hide()

        val maxSplashTime: Long = 3000
        var progressSplash: Long = 0
        val percentResult = maxSplashTime / 101

        for(x in 0..100){
            Handler().postDelayed({
                progressSplashBar.progress = x
            }, progressSplash)
            progressSplash = progressSplash + percentResult
        }

        Handler().postDelayed({
            startActivity(Intent(this, tela2activity::class.java))
            finish()
        },maxSplashTime)
    }
}