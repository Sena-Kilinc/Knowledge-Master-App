package com.senakilinc.knowledgemasters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.senakilinc.knowledgemasters.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    lateinit var splashBinding: ActivityWelcomeBinding // to access the components in the welcome activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // to access the components in the welcome activity
        splashBinding = ActivityWelcomeBinding.inflate(layoutInflater)
        val view = splashBinding.root
        setContentView(view)
        // now creating animation with alpha
        val alphaAnnotation=AnimationUtils.loadAnimation(applicationContext,R.anim.splash_anim)
        splashBinding.textViewSplash.startAnimation(alphaAnnotation)
        // to change screens we use handler
        val handler=Handler(Looper.getMainLooper())
        handler.postDelayed(object :Runnable{
            override fun run() {
                val intent = Intent(this@WelcomeActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        },5000)

    }
}