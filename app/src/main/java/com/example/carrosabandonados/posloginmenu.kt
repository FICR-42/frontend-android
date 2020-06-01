package com.example.carrosabandonados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.carrosabandonados.ui.login.LoginActivity

class posloginmenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posloginmenu)
    }

    fun funGerenciarDenuncias (view: View){

        val intent = Intent(this, GerenciarDenunciasMain::class.java)

        startActivity(intent)
    }

    fun funGerenciarUsuarios(view: View){

        val intent = Intent(this, GerenciarUsuariosMain::class.java)

        startActivity(intent)
    }

}
