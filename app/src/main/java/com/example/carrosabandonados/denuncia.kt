package com.example.carrosabandonados

import CEP_Kotlin
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import model.Denuncia_json
import okhttp3.internal.wait
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import service.CepWebService
import service.DenunciaWebService


class denuncia : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_denuncia)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val btnCEP = findViewById<Button>(R.id.btnCEP)
        val etCep = findViewById<EditText>(R.id.etCEPdenuncia)
        val etLogradouro = findViewById<EditText>(R.id.etLogradouro)
        val etBairro = findViewById<EditText>(R.id.etBairro)
        val etNumero = findViewById<EditText>(R.id.etNumero)
        val etReferencia = findViewById<EditText>(R.id.etReferencia)
        val etMarcaModelo = findViewById<EditText>(R.id.etMarcaModelo)
        val etPlaca = findViewById<EditText>(R.id.etPlaca)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val cbMotor = findViewById<CheckBox>(R.id.checkBoxMotor)
        val cbPlaca = findViewById<CheckBox>(R.id.checkBoxPlaca)
        val etDescricao = findViewById<EditText>(R.id.etDescricao)
        var cep = CEP_Kotlin()
        var cepDigitado: String = ""
        var BaseUrl: String = "viacep.com.br/ws/" + cepDigitado + "/json/"
        var erro: String = ""
        var motor: String=""

        val builder = AlertDialog.Builder(this@denuncia)

        etCep.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                etCep.setText("")
            }
            false
        })

        etBairro.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                etBairro.setText("")
            }
            false
        })

        etDescricao.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                etDescricao.setText("")
            }
            false
        })


        etEmail.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                etEmail.setText("")
            }
            false
        })


        etLogradouro.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                etLogradouro.setText("")
            }
            false
        })

        etMarcaModelo.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                etMarcaModelo.setText("")
            }
            false
        })

        etNumero.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                etNumero.setText("")
            }
            false
        })

        etPlaca.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                etPlaca.setText("")
            }
            false
        })

        etReferencia.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                etReferencia.setText("")
            }
            false
        })


        btnCEP.setOnClickListener {


            doAsync {
                /* Realizar a chamada da API passando o caminho do EditText */
                val call = CepWebService().apiRetrofitCEP()
                    .getCEP(etCep.text.toString())

                /* A chamada deve implementar dois metodos: onResponse e onFailure */
                call.enqueue(object : Callback<CEP_Kotlin> {

                    /* Caso a resposta seja positiva extraimos o objeto da resposta e exibimos o resultado na tela */
                    override fun onResponse(
                        call: Call<CEP_Kotlin>,
                        response: Response<CEP_Kotlin>
                    ) {

                        response.let {
                            val CEPs: CEP_Kotlin? = it.body()

                            if (CEPs == null) {
                                etCep.setText("Cep inválido!")

                            } else {

                                etCep.setText(CEPs.cep)
                                etLogradouro.setText(CEPs.logradouro)
                                etBairro.setText(CEPs.bairro)
                                //CEPs.localidade + "\n" +
                                //"UF: " + CEPs.uf
                            }
                        }
                    }

                    /* Caso ocorra uma falha na resposta lançamos um erro no log */
                    override fun onFailure(call: Call<CEP_Kotlin>?, t: Throwable?) {
                        Log.e("Erro", t?.message)
                    }
                })
            }
        }
        btnEnviar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

                var denuncia = Denuncia_json()
                denuncia.cep = etCep.text.toString()
                denuncia.bairro = etBairro.text.toString()
                denuncia.cidade = cep.localidade.toString()
                denuncia.complemento = "N." + etNumero.text.toString()
                denuncia.descricao = etDescricao.text.toString()
                denuncia.email = etEmail.text.toString()
                denuncia.marcaModelo = etMarcaModelo.text.toString()
                denuncia.motor = ""
                denuncia.numero = etNumero.text.toString()
                denuncia.placa = etPlaca.text.toString()
                denuncia.referencia = etReferencia.text.toString()
                denuncia.rua = etLogradouro.text.toString()
                denuncia.uf = cep.uf.toString()
                denuncia.Endereco()

            println(denuncia.toString())

                //doAsync {
                    val call = DenunciaWebService().PostDenuncia().postDenuncia(denuncia)

                    /* A chamada deve implementar dois metodos: onResponse e onFailure */
                    call.enqueue(object : Callback<Denuncia_json> {

                        /* Caso a resposta seja positiva extraimos o objeto da resposta e exibimos o resultado na tela */
                        override fun onResponse(
                            call: Call<Denuncia_json>,
                            response: Response<Denuncia_json>
                        ) {

                            response.let {
                               val denun: Denuncia_json? = it.body()

                               goThanks()


                            }
                        }

                        /* Caso ocorra uma falha na resposta lançamos um erro no log */
                        override fun onFailure(call: Call<Denuncia_json>?, t: Throwable?) {
                            Log.e("Erro", t?.message)
                            builder.setTitle("Oops.. algo deu errado!")
                            builder.setMessage(t?.message)
                        }
                    })


                }
           // }

        })
//instancia de Denuncia


    }

    fun goThanks (){

        val intent = Intent(this, denuncia_enviada_k::class.java)

        startActivity(intent)
    }
    /* fun insertDenuncia(denuncia: Denuncia_kotlin) {

         val call = RetrofitInitializer().PostDenuncia().postDenuncia(denuncia)

           call.enqueue(object : Callback<Denuncia_kotlin> {
                     override fun onResponse(
                         call: Call<Denuncia_kotlin>,
                         response: Response<Denuncia_kotlin>
                     ) {
                         if (!response.isSuccessful()) {

                             builder.setMessage("Code: " + response.code())
                             return
                         }
                         val postResponse: Denuncia_kotlin? = response.body()
                         var content = ""
                         content += """
                                         Code: ${response.code()}

                                         """.trimIndent()
                         content += """
                                         Veiculo: ${postResponse.marcaModelo.toString()} + ", " +  ${postResponse.placa.toString()}

                                         """.trimIndent()
                         content += """
                                         Endereço: ${postResponse.rua.toString()} + ", " + ${postResponse.numero.toString()} +  ${postResponse.bairro.toString()}

                                         """.trimIndent()

                     }

                     override fun onFailure(call: Call<Denuncia_kotlin?>, t: Throwable) {
                         builder.setTitle("Houve algum problema!")
                         builder.setMessage(t.message)
                     }
                 })
             }*/
}



