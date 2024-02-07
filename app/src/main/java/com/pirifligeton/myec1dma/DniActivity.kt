package com.pirifligeton.myec1dma

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.pirifligeton.myec1dma.databinding.ActivityDniBinding
import java.time.LocalDate

class DniActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityDniBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDniBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShowDni.setOnClickListener(this)
    }

    fun goBack(view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDniResult(year : Int) : String{
        val currentYear = LocalDate.now().year
        if(currentYear - year > 18){
            return "Is not required to show ID"
        }
        else{
            return "Is required to show ID"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onClick(v: View?) {
        val dniResult = getDniResult(
            binding.etnIdDni.text.toString().toInt()
        )
        binding.ettPromptDni.setText(dniResult)
    }
}