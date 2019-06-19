package com.teknhe.androidkotlinalarmservice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val iniciar = findViewById<Button>(R.id.iniciar)
        val terminar = findViewById<Button>(R.id.terminar)
        val intent = Intent(applicationContext, AlarmService::class.java)

        iniciar.setOnClickListener {
                view -> startService(intent)
        }

        terminar.setOnClickListener {
                view -> stopService(intent)
        }
    }
}
