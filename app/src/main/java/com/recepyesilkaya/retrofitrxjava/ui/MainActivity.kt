package com.recepyesilkaya.retrofitrxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.recepyesilkaya.retrofitrxjava.viewmodel.PrayViewModel

class MainActivity : AppCompatActivity() {

    private val prayViewModel: PrayViewModel by lazy {
        ViewModelProvider(this).get(PrayViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGetData=findViewById<Button>(R.id.btnGetData)

        btnGetData.setOnClickListener {
            prayViewModel.getPray("9541")
        }

        prayViewModel.prayList.observe(this, Observer {
            Log.e("PRAY","deneme başarılı")
            Log.e("PRAY", it.toString())
        })
    }


}