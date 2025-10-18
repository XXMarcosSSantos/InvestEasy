package com.projeto.investeasy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
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

            val aporte = edtaporte.text.toString()
            val NumMeses = edtNumMeses.text.toString()
            val juros = edtJuros.text.toString()

            if (aporte.isEmpty() || NumMeses.isEmpty() || juros.isEmpty()) {
                Snackbar.make(
                    it,
                    "preencha os campos vazios",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {

                val jurosMensal = juros.toFloat() / 100

                val ResultadoFinal = aporte.toInt() * ((1 + jurosMensal).pow(NumMeses.toFloat()) - 1) / jurosMensal
                val totalInvestido = aporte.toInt() * NumMeses.toInt()
                val VR_Rendimeto = ResultadoFinal - totalInvestido

                tvInvestimento.text = ResultadoFinal.toString()
                tvResult_Rendimento.text = VR_Rendimeto.toString()
            }
        }
    }
}