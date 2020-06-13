package com.example.carrosabandonados

import model.CEP_Kotlin
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
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import model.Denuncia
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
        var cidade: String = ""
        var uf: String = ""
        var cep = CEP_Kotlin()
        var txtcep = ""
        var motor: String = "Com motor."
        var placa: String = "Sem placa."

        val builder = AlertDialog.Builder(this@denuncia)


        cbMotor.setOnCheckedChangeListener { buttonView, isChecked ->
            motor = "Sem motor."
        }

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

            txtcep = etCep.text.toString()
            txtcep = txtcep.replace(".", "")
            txtcep = txtcep.replace("-", "")
            txtcep = txtcep.replace(",", "")


            doAsync {
                /* Realizar a chamada da API passando o caminho do EditText */
                val call = CepWebService().apiRetrofitCEP()
                    .getCEP(txtcep)

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
                                cidade = CEPs.localidade.toString()
                                uf = CEPs.uf.toString()
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

                var denuncia = Denuncia()
                denuncia.cep = etCep.text.toString()
                denuncia.bairro = etBairro.text.toString()
                denuncia.cidade = cep.localidade.toString()
                denuncia.complemento = etNumero.text.toString()
                denuncia.descricao = etDescricao.text.toString()
                denuncia.email = etEmail.text.toString()
                denuncia.marcaModelo = etMarcaModelo.text.toString()
                denuncia.motor = motor
                denuncia.numero = etNumero.text.toString()

                if (cbPlaca.isChecked) {
                    denuncia.placa = placa
                } else {
                    denuncia.placa = etPlaca.text.toString()
                }
                denuncia.cidade = cidade
                denuncia.referencia = etReferencia.text.toString()
                denuncia.rua = etLogradouro.text.toString()
                denuncia.uf = uf
                denuncia.Endereco()

                println(denuncia.toString())

                //doAsync {
                val call = DenunciaWebService().PostDenuncia().postDenuncia(denuncia)

                /* A chamada deve implementar dois metodos: onResponse e onFailure */
                call.enqueue(object : Callback<Denuncia> {

                    /* Caso a resposta seja positiva extraimos o objeto da resposta e exibimos o resultado na tela */
                    override fun onResponse(
                        call: Call<Denuncia>,
                        response: Response<Denuncia>
                    ) {

                        response.let {

                                val denun: Denuncia? = it.body()
                              goThanks(denuncia.email)

                        }
                    }

                    /* Caso ocorra uma falha na resposta lançamos um erro no log */
                    override fun onFailure(call: Call<Denuncia>?, t: Throwable?) {
                        Log.e("Erro", t?.message)
                        builder.setTitle("Oops.. algo deu errado!")
                        builder.setMessage(t?.message)
                    }
                })
            }
        })
    }

    fun goThanks(email:String) {

        val intent = Intent(this, denuncia_enviada_k::class.java)

        intent.putExtra("email", email)

        startActivity(intent)
    }
}



