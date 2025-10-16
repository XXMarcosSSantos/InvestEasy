package com.projeto.investeasy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // tela principal e calculo feito
        val edtaporte = findViewById<EditText>(R.id.edtText_Aporte)
        val edtNumMeses= findViewById<EditText>(R.id.edtText_NumMeses)
        val edtJuros = findViewById<EditText>(R.id.edtText_Juros)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        val tvInvestimento = findViewById<TextView>(R.id.tv_ValorFinal)
        val tvResult_Rendimento = findViewById<TextView>(R.id.tv_ValorRendimento)

        btnLimpar.setOnClickListener {
             edtaporte.text.clear()
             edtNumMeses.text.clear()
             edtJuros.text.clear()

            tvInvestimento.text = ""
            tvResult_Rendimento.text = ""
        }

        btnCalcular.setOnClickListener {
            val aporte = edtaporte.text.toString().toInt()
            val NumMeses = edtNumMeses.text.toString().toInt()
            val juros = edtJuros.text.toString().toDouble()

            val jurosMensal = juros / 100

            val ResultadoFinal = aporte * ((1 + jurosMensal).pow( NumMeses) - 1) / jurosMensal
            val totalInvestido = aporte * NumMeses
            val VR_Rendimeto = ResultadoFinal - totalInvestido

            tvInvestimento.text = ResultadoFinal.toString()
            tvResult_Rendimento.text = VR_Rendimeto.toString()
        }

    }
}