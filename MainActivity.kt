package com.example.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            val peso = edtPeso.text.toString().toFloatOrNull()
            val altura = edtAltura.text.toString().toFloatOrNull()

            if (peso != null && altura != null && altura > 0) {
                val imc = peso / (altura * altura)

                val classificacao = if (imc < 18.5) {
                    "Abaixo do peso"
                } else if (imc in 18.5..24.9) {
                    "Peso normal"
                } else if (imc in 25.0..29.9) {
                    "Sobrepeso"
                } else if (imc in 30.0..34.9) {
                    "Obesidade grau 1"
                } else if (imc in 35.0..39.9) {
                    "Obesidade grau 2"
                } else {
                    "Obesidade grau 3 (obesidade mórbida)"
                }

                txtResultado.text = "IMC: %.2f\n%s".format(imc, classificacao)

            } else {
                txtResultado.text = "Por favor, insira valores válidos!"
            }
        }
    }
}
