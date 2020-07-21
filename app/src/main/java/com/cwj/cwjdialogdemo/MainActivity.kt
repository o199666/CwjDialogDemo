package com.cwj.cwjdialogdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        java_tv.setOnClickListener {
            startActivity(Intent(this,JavaActivity::class.java))
        }
        kotlin_tv.setOnClickListener {
            startActivity(Intent(this,KotlinActivity::class.java))

        }
    }
}