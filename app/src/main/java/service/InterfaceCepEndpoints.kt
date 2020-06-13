package service

import model.CEP_Kotlin
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface InterfaceCepEndpoints {


    @GET("{CEP}/json/")
    fun getCEP(@Path("CEP") CEP: String): Call<CEP_Kotlin>


}