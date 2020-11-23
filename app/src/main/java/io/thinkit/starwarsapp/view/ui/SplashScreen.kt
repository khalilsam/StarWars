package io.thinkit.starwarsapp.view.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import io.thinkit.starwarsapp.R

class SplashScreen : AppCompatActivity() {
    //  loading time of the splash screen
    private val SPLASH_TIME_OUT: Long = 1000 //  3sec

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, MainActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)

    }
}