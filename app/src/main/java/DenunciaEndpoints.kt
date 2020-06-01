import model.Denuncia_json
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface DenunciaEndpoints {



    @POST("denuncia")
    fun postDenuncia(@Body user:Denuncia_json): Call<Denuncia_json>

}