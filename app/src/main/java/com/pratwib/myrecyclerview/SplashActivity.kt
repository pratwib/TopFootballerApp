package com.pratwib.myrecyclerview

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashTime: Long = 3000

        Handler().postDelayed({
            val intentSplashScreen = Intent(this, MainActivity::class.java)
            startActivity(intentSplashScreen)
            finish()
        }, splashTime)
    }
}