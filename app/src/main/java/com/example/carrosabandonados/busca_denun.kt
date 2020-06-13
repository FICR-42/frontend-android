package com.example.carrosabandonados

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import model.Denuncia

import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import service.DenunciaWebService

class busca_denun : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busca_denun)

        val btnFind  = findViewById<Button>(R.id.btnFindDenun)
        val etProtocolo = findViewById<EditText>(R.id.etCoddenuncia)
        val tvEndereco = findViewById<TextView>(R.id.enderecoResp)
        val tvNumProtocolo = findViewById<TextView>(R.id.codigoResp)
        val tvVeiculo = findViewById<TextView>(R.id.marcaResp)
        val tvPlaca = findViewById<TextView>(R.id.placaResp)
        val tvEmail = findViewById<TextView>(R.id.emailResp)
        val tvStatus = findViewById<TextView>(R.id.descricaoResp)
        var protocolo : String = ""

        var denuncia = Denuncia();

        btnFind.setOnClickListener {



            doAsync {
                /* Realizar a chamada da API passando o caminho do EditText */
                val call = DenunciaWebService().GETDenuncia().getDenuncia(etProtocolo.text.toString())


                /* A chamada deve implementar dois metodos: onResponse e onFailure */
                call.enqueue(object : Callback<Denuncia> {

                    /* Caso a resposta seja positiva extraimos o objeto da resposta e exibimos o resultado na tela */
                    override fun onResponse(
                        call: Call<Denuncia>,
                        response: Response<Denuncia>
                    ) {

                        response.let {
                            val Denuns: Denuncia? = it.body()

                            if (Denuns == null) {
                                tvNumProtocolo.setText("Cep inválido!")

                            } else {

                                denuncia.status = Denuns.status
                                denuncia.protocolo = Denuns.protocolo
                                denuncia.endereco = Denuns.endereco
                                denuncia.marcaModelo = Denuns.marcaModelo
                                denuncia.placa = Denuns.placa
                                denuncia.email = Denuns.email
                            }
                        }
                    }

                    /* Caso ocorra uma falha na resposta lançamos um erro no log */
                    override fun onFailure(call: Call<Denuncia>?, t: Throwable?) {
                        Log.e("Erro", t?.message)
                    }
                })


            }
            tvNumProtocolo.setText(denuncia.protocolo)
            tvEndereco.setText(denuncia.endereco)
            tvVeiculo.setText(denuncia.marcaModelo)
            tvPlaca.setText(denuncia.placa)
            tvEmail.setText(denuncia.email)
            tvStatus.setText(denuncia.status)

        }



    }

    fun goBack(view: View) {


        val intent = Intent(this, tela2activity::class.java)

        startActivity(intent)
    }

}
