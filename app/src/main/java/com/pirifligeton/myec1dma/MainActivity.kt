package com.pirifligeton.myec1dma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goApp1(view : View){
        val intent = Intent(this, StorageActivity::class.java)
        startActivity(intent)
    }

    fun goApp2(view : View){
        val intent = Intent(this, CompanyActivity::class.java)
        startActivity(intent)
    }

    fun goApp3(view : View){
        val intent = Intent(this, DniActivity::class.java)
        startActivity(intent)
    }

    fun goApp4(view : View){
        val intent = Intent(this, EvenActivity::class.java)
        startActivity(intent)
    }
}