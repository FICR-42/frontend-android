package com.example.carrosabandonados

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class denuncia_enviada_k : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denuncia_enviada_k)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)


    }

    fun goBack(view: View) {

        val intent = Intent(this, tela2activity::class.java)

        startActivity(intent)
    }

}

