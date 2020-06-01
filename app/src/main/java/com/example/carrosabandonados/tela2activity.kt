package com.example.carrosabandonados

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.view.WindowManager
import com.example.carrosabandonados.ui.login.LoginActivity

class tela2activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT < 16) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
        window.decorView.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()


        setContentView(R.layout.activity_tela2activity)

    }

    fun buttonDenunciar (view: View){

        val intent = Intent(this, denuncia::class.java)

        startActivity(intent)
    }

    fun buttonLogar(view: View){

        val intent = Intent(this, LoginActivity::class.java)

        startActivity(intent)
    }

}
