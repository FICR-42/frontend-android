package service


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DenunciaWebService {


    val retrofitpostDenuncia = Retrofit.Builder()
        .baseUrl("http://backend.teste-route52-42.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun PostDenuncia(): InterfaceDenunciaEndpoints {
        return retrofitpostDenuncia.create(InterfaceDenunciaEndpoints::class.java)
    }

    fun GETDenuncia(): InterfaceDenunciaEndpoints {
        return retrofitpostDenuncia.create(InterfaceDenunciaEndpoints::class.java)
    }
}