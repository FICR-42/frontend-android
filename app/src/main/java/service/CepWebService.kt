package service

import CepEndpoints
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CepWebService {



        /* Consumir JSON da API e converter (parser) */
        val retrofitgetCEP = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun apiRetrofitCEP(): CepEndpoints {
        return retrofitgetCEP.create(CepEndpoints::class.java)
    }

}