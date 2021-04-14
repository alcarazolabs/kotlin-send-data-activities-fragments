package com.example.introduccionkotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SegundaActivity : AppCompatActivity() {
    private var nombre:String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)
        val texto = findViewById<TextView>(R.id.txtActividad2)

        intent.extras?.let { bundle ->
         nombre = bundle.getString("nombre")
        }
        texto.text = nombre

        val button = findViewById<Button>(R.id.btnActivity2)
        button.setOnClickListener{
            val intent = Intent()
            intent.putExtra("nombre2", "Daniel de segunda actividad")
            setResult(Activity.RESULT_OK, intent) //valor -1
            finish()
        }
    }
}