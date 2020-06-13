package service

import model.Denuncia
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface InterfaceDenunciaEndpoints {


    @POST("denuncia")
    fun postDenuncia(@Body user: Denuncia): Call<Denuncia>

    @GET("/denuncia/{protocolo}")
    fun getDenuncia(@Path("protocolo") protocolo: String): Call<Denuncia>

}