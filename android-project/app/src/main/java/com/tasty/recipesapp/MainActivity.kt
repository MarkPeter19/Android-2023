package com.tasty.recipesapp

import android.R
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.tasty.recipesapp.R.layout.activity_main)

        val getStartedButton = findViewById<Button>(com.tasty.recipesapp.R.id.getStartedButton)
//        getStartedButton.setOnClickListener {
//            // Ide add meg, hogy mit szeretnél tenni a 'Get Started' gombra kattintáskor.
//            // Például átirányítás egy másik Activity-re vagy tevékenységre.
//        }
    }
}