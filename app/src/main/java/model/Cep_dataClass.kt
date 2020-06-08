package model

import com.google.gson.annotations.SerializedName

data class Cep_dataClass constructor(


    @SerializedName("cep") val cep: String? = null,
    @SerializedName("logradouro") val logradouro: String? = null,
    @SerializedName("complemento") val complemento: String? = null,
    @SerializedName("bairro") val bairro: String? = null,
    @SerializedName("localidade") val localidade: String? = null,
    @SerializedName("uf") val uf: String? = null,
    @SerializedName("unidade") val unidade: String? = null,
    @SerializedName("ibge") val ibge: String? = null,
    @SerializedName("gia") val gia: String? = null
)

