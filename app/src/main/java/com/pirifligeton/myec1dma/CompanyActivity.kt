package com.pirifligeton.myec1dma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pirifligeton.myec1dma.databinding.ActivityCompanyBinding

class CompanyActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding : ActivityCompanyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCompanyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculateCompany.setOnClickListener(this)
    }

    fun goBack(view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun getLoanResult(loan : Double) : Pair<Double, Int>{

        if (loan > 5000) return Pair(loan*1.1/3,3)
        else if(loan in 4000.0..5000.0) return Pair(loan*1.1/5,5)
        else if(loan in 2000.0 .. 3000.0) return Pair(loan*1.12/2,2)
        else if(loan < 1000) return Pair(loan * 1.12, 1)
        else return Pair(loan*1.12/5,5)
    }

    override fun onClick(v: View?) {
        val (instalmentValue,instalments) = getLoanResult(
            binding.etndAmountCompany.text.toString().toDouble()
        )
        binding.etndInstalmentValueCompany.setText("%.2f".format(instalmentValue).toString())
        binding.ednInstalmentsCompany.setText(instalments.toString())
    }
}