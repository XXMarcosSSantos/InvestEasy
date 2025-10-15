package com.projeto.investeasy

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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



        // recuperando os Id dos EditText
        val edtaporte = findViewById<EditText>(R.id.edtText_Aporte)
        val edtNumMeses= findViewById<EditText>(R.id.edtText_NumMeses)
        val edtJuros = findViewById<EditText>(R.id.edtText_Juros)

        // recuperando os botões pelos ID que é o calcular e limpar
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        // colocando click no botão quando o usuario digitar irar apagar os editext
        btnLimpar.setOnClickListener {
             edtaporte.text.clear()
             edtNumMeses.text.clear()
             edtJuros.text.clear()
        }

        btnCalcular.setOnClickListener {
            val aporte = edtaporte.text.toString().toInt()
            val NumMeses = edtNumMeses.text.toString().toInt()
            val juros = edtJuros.text.toString().toDouble()


        }


    }
}