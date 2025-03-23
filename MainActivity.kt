package com.example.calculadoraimc

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {

    private lateinit var edtPeso: EditText
    private lateinit var edtAltura: EditText
    private lateinit var btnCalcular: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPeso = findViewById(R.id.edtPeso)
        edtAltura = findViewById(R.id.edtAltura)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)

        btnCalcular.setOnClickListener {
            calcularIMC()
        }
    }

    private fun calcularIMC() {
        val peso = edtPeso.text.toString().toFloatOrNull()
        val altura = edtAltura.text.toString().toFloatOrNull()

        if (peso != null && altura != null && altura > 0) {
            val imc = peso / (altura * altura)
            txtResultado.text = "IMC: %.2f\n$imc".format(imc)
        } else {
            txtResultado.text = "Por favor, insira valores válidos!"
        }
    }
}
