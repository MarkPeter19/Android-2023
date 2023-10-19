package com.tasty.recipesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tasty.recipesapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    companion object{
        const val TAG = "SplashActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash)

        //UI elemek keresese bindinggal
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("mesage", "Hello World!")
            startActivity(intent)
            Log.d(TAG, "onCreate: Button clicked.")
        }


        Log.d(TAG, "onCreate: SplashActivity created.")
    }

    override fun onStart(){
        super.onStart();
        Log.d(TAG, "onStart: SplashActivity started.")
    }

    override fun onResume(){
        super.onResume();
        Log.d(TAG, "onResume: SplashActivity resumed.")
    }

    override fun onPause(){
        super.onPause();
        Log.d(TAG, "onPause: SplashActivity paused.")
    }

    override fun onStop(){
        super.onStop();
        Log.d(TAG, "onStop: SplashActivity stoped.")
    }

    override fun onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: SplashActivity destroyed.")
    }



}