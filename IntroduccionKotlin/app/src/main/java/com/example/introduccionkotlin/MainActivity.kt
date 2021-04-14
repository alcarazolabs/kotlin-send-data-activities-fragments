package com.example.introduccionkotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var texto:TextView //con lateinit decimos que en algun momento de ejecucion va ser inicializada pero yo prometo que va ser inicializada anterior a su uso
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto = findViewById<TextView>(R.id.txtActividad1)
        val button = findViewById<Button>(R.id.btnActivity1);

        button.setOnClickListener{
            irActivity2()
        }
    }
    private fun irActivity2(){
        val intent = Intent(this, SegundaActivity::class.java)
        intent.putExtra("nombre","Freddy")
        //startActivity(intent)
        startActivityForResult(intent, 1) //para recibir datos de la actividad 2
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //recibir los resultCode
        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
               val nombre = data?.getStringExtra("nombre2")
                texto.text = nombre
            }
        }
    }
}
