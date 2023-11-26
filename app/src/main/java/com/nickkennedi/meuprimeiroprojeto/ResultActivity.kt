package com.nickkennedi.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.bottomappbar.BottomAppBar
import com.nickkennedi.meuprimeiroprojeto.databinding.ActivityHomeBinding
import com.nickkennedi.meuprimeiroprojeto.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textoRecebidoResult = intent.getFloatExtra("imc", 0.1f)
        val textViewResult = findViewById<TextView>(R.id.txtTitulo)
        textViewResult.text = textoRecebidoResult.toString()

        val textoRecebidoClassificacao = intent.getStringExtra("classificado")
        val textViewClassificacao = findViewById<TextView>(R.id.resultado)
        textViewClassificacao.text = textoRecebidoClassificacao

        val textoRecebidoPeso = intent.getStringExtra("peso")
        val textView = findViewById<TextView>(R.id.peso_kg)
        textView.text = textoRecebidoPeso +"kg"

        val textoRecebidoAltura = intent.getStringExtra("altura")
        val textViewAltura = findViewById<TextView>(R.id.altura_cm)
        textViewAltura.text = textoRecebidoAltura +"m"



        binding.btnCalcularNovamente.setOnClickListener{
            val voltarScreenHome = Intent(this,HomeActivity::class.java)
            startActivity(voltarScreenHome)
        }


    }
}