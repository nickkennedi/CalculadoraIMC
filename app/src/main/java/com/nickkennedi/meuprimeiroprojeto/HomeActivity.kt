package com.nickkennedi.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.nickkennedi.meuprimeiroprojeto.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btnCalcular.setOnClickListener {
            if(binding.editTextPeso.text.isNotEmpty() && binding.editTextAltura.text.isNotEmpty()){

                /*recebe o valor dos input e converte para string para ser adicionados na outra tela*/
                val peso = binding.editTextPeso.text.toString()
                val altura = binding.editTextAltura.text.toString()

                /*recebe o valor dos input para o calculo*/
                val edtPeso: EditText = findViewById(R.id.editText_peso)
                val edtAltura: EditText = findViewById(R.id.editText_altura)



                    /*converte o valor dos input para o calculo*/
                    val alturaEdt = edtAltura.text.toString().toFloat()
                    val pesoEdt = edtPeso.text.toString().toFloat()
                    val alturaFinal: Float = alturaEdt * alturaEdt
                    val pesoFinal: Float = pesoEdt
                    val imc = pesoFinal / alturaFinal


                /*logica para obter a classificacao*/
                var classificacao = "classificacao"
                if (imc < 18.5){
                    classificacao = "A BAIXO DO PESO"

                }else if (imc >= 18.5 && imc <= 24.9) {
                    classificacao = "NORMAL"

                }else if (imc >= 25.0 &&imc <= 29.9) {
                    classificacao = "SOBREPESO I"

                }else if (imc >= 30.0 && imc <= 39.9) {
                    classificacao = "OBESIDADE II"

                }else if(imc >= 40.0) {
                    classificacao = "OBESIDADE III"
                }


                /*abre a tela em questao*/
                val navegarScreenResult = Intent(this,ResultActivity::class.java)
                    .apply {

                        putExtra("imc", imc)
                        putExtra("classificado", classificacao)
                        putExtra("peso", peso)
                        putExtra("altura", altura)

                    }
                startActivity(navegarScreenResult)


            }else {
                Toast.makeText(this, "preeencha todos os campos", Toast.LENGTH_LONG).show()
            }

        }
        /*logica para resetar os input*/
        binding.btnResetar.setOnClickListener{
            if (binding.editTextPeso.text.isNotEmpty() && binding.editTextAltura.text.isNotEmpty()){
                binding.editTextPeso.text.clear()
                binding.editTextAltura.text.clear()

            } else if (binding.editTextPeso.text.isEmpty() && binding.editTextAltura.text.isNotEmpty()){
                binding.editTextAltura.text.clear()
            } else if (binding.editTextPeso.text.isNotEmpty() && binding.editTextAltura.text.isEmpty()){
                binding.editTextPeso.text.clear()
            }
        }
    }
}