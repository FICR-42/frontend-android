import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CepEndpoints {


    @GET("{CEP}/json/")
    fun getCEP(@Path("CEP") CEP: String): Call<CEP_Kotlin>


}