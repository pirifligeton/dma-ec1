package com.pirifligeton.myec1dma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pirifligeton.myec1dma.databinding.ActivityStorageBinding

class StorageActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var binding : ActivityStorageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStorageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculateStorage.setOnClickListener(this)
    }

    fun goBack(view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun valueOfStorageStore(quantity : Int, price : Double) : Pair<Double, String>{
        val q = quantity
        val p = price
        return if(q*p > 200){
            Pair(q*p*0.8, "Discount applied!")
        }
        else{
            Pair(q*p, "Discount no applied!")
        }
    }

    override fun onClick(v: View?) {
        val (resultStorage,discountStorage) = valueOfStorageStore(
            binding.etnQuantityStorage.text.toString().toInt(),
            binding.etndPriceStorage.text.toString().toDouble()
        )
        binding.etxResultStorage.setText(resultStorage.toString())
        binding.txvCommentStorage.setText(discountStorage.toString())
    }
}

