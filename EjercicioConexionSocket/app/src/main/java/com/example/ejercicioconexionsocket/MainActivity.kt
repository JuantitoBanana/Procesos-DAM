package com.example.ejercicioconexionsocket

import android.os.Bundle
import android.os.StrictMode
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicioconexionsocket.databinding.ActivityMainBinding
import java.io.ObjectOutputStream
import java.net.Socket

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Politicas para conectar (hay que meter permiso de internet en androidManifest)
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lateinit var oos : ObjectOutputStream

        binding.bConectar.setOnClickListener(){
            var socket : Socket = Socket("172.26.8.26", 4444)
            oos = ObjectOutputStream(socket.getOutputStream())

            binding.bEnviar.isEnabled = true
        }

        binding.bEnviar.setOnClickListener(){
            var msj : Mensaje = Mensaje(binding.tietTexto.text.toString())
            oos.writeObject(msj.cadena)
            binding.tietTexto.text?.clear()
        }
    }
}