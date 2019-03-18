package com.example.gamernoob


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.gamernoob.view.LoginActivity


class SplashActivity : AppCompatActivity() {

    var mDelayhandler : Handler? = null
    val SPLASH_DELAY : Long = 2500

         val mRunnable : Runnable = Runnable {
        if (!isFinishing){
            val intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

            mDelayhandler = Handler()

            mDelayhandler!!.postDelayed(mRunnable, SPLASH_DELAY)

    }

    public override fun onDestroy() {
        if (mDelayhandler != null){
            mDelayhandler!!.removeCallbacks(mRunnable)
        }

        super.onDestroy()
    }
}