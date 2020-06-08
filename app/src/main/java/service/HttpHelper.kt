package service

import CepEndpoints
import com.google.gson.Gson
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class HttpHelper {

    private val client = OkHttpClient()
    val gson = Gson();


    fun postDenuncia(json: String): String {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("http://backend.teste-route52-15.com/denuncia")
            .post(json.toRequestBody(MEDIA_TYPE_MARKDOWN))
            .build()

        val resposta = client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            println(response.body!!.string())
        }
        return resposta.toString()

    }

    fun getDenuncia(json: String) {


        val request = Request.Builder()
            .url("http://backend.teste-route52-42.com/cli/denuncia")
            .get()
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            println(response.body!!.string())
        }
    }

    companion object {
        fun getCEP(toString: String, kotlin: Class<Any>) {
            val MEDIA_TYPE_MARKDOWN = "application/json; charset=utf-8".toMediaType()
        }


        fun buildService(kotlin: Class<CepEndpoints>) {
            val MEDIA_TYPE_MARKDOWN = "application/json; charset=utf-8".toMediaType()
        }


        val MEDIA_TYPE_MARKDOWN = "application/json; charset=utf-8".toMediaType()
    }


/*
        //URL DO SERVIDOR
        val URL = "http://backend.teste-route52-42.com/"

        //CABEÇALHO
      val header = MediaType.get("application/json; charset=utf-8")
*/


}
