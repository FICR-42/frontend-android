package com.example.carrosabandonados

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class busca_denun : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca_denun)
    }

    fun goBack(view: View) {


        val intent = Intent(this, tela2activity::class.java)

        startActivity(intent)
    }

}
