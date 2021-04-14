package com.example.fragmentoskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener


class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //mapeo de widgets
        val button = view.findViewById<Button>(R.id.btnNavegar)
        val texto = view.findViewById<TextView>(R.id.txtFragment1)

        //setear listener para recibir datos del fragment2
        setFragmentResultListener("requestKey"){ key, bundle ->
            val result = bundle.getString("bundleKey")
            texto.text = result
        }


        button.setOnClickListener{
            requireActivity().supportFragmentManager.commit {
                //add(R.id.fragmentContainerView, SegundoFragment()) //Esto agrega un fragment encima de otro
                replace(R.id.fragmentContainerView, SegundoFragment.newInstance("Freddy", 25)) //replace. Reemplaza el contenido.. Llamamos al método newInstance del fragment2 para pasar los parametros
                addToBackStack("primerFragment") //addToBackStack para poder volver atras entre fragments
            }
        }
    }

    //para recibir los datos del fragment 2 debemos de escuchar un listener con setFragmentResultListener

}