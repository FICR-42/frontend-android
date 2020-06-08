package com.example.carrosabandonados

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class posloginmenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posloginmenu)
    }

    fun funGerenciarDenuncias(view: View) {

        val intent = Intent(this, GerenciarDenunciasMain::class.java)

        startActivity(intent)
    }

    fun funGerenciarUsuarios(view: View) {

        val intent = Intent(this, GerenciarUsuariosMain::class.java)

        startActivity(intent)
    }

}
