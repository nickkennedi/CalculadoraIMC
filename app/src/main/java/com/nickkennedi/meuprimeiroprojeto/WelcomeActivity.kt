package com.nickkennedi.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.nickkennedi.meuprimeiroprojeto.databinding.ActivityWelcomeBinding


class WelcomeActivity : AppCompatActivity() {

private  lateinit var binding:ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val navegarScreenHome = Intent(this,HomeActivity::class.java)
            startActivity(navegarScreenHome)
        }
    }
}