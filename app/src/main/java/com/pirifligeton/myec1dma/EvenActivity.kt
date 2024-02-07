package com.pirifligeton.myec1dma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pirifligeton.myec1dma.databinding.ActivityEvenBinding

class EvenActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityEvenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEvenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShowEven.setOnClickListener(this)
    }

    fun goBack(view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun showEvenNumbers() : String{
        var promptResult = ""
        val evenNumbers = (11..19).filter {x -> x % 2 == 0}
        for (x in evenNumbers.sortedDescending()){
            promptResult += "$x "
        }
        return promptResult
    }

    override fun onClick(v: View?) {
        val prompt = showEvenNumbers()
        binding.ettPromptEven.setText(prompt)
    }

}