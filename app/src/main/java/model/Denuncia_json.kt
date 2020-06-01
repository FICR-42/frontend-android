package model

import com.google.gson.annotations.SerializedName

class Denuncia_json {



    @SerializedName("placa")
     var placa: String  = "";

    @SerializedName("motor")
     var motor: String   = "";

    @SerializedName("marca")
     var marcaModelo: String  = "";

    @SerializedName("cep")
     var cep: String  = "";

    @SerializedName("endereco")
     var endereco: String  = ""

    @SerializedName("rua")
     var rua: String  = "";

    @SerializedName("numero")
     var numero: String  = "";

    @SerializedName("complemento")
     var complemento: String  = "";

    @SerializedName("bairro")
     var bairro: String  = "";

    @SerializedName("cidade")
     var cidade: String  = "";

    @SerializedName("uf")
     var uf: String  = "";

    @SerializedName("referencia")
     var referencia: String  = "";

    @SerializedName("email")
     var email: String  = "";

    @SerializedName("descricao")
     var descricao: String  = "";



    override fun toString(): String {
        return "Denuncia_kotlin(placa='$placa', motor='$motor', marcaModelo='$marcaModelo', cep='$cep', rua='$rua', numero='$numero', complemento='$complemento', bairro='$bairro', cidade='$cidade', uf='$uf', referencia='$referencia', email='$email', descricao='$descricao')"
    }
    fun Endereco(){

        if (rua == null || rua=="") rua = "rua não informada"
        if (numero == null || numero=="") numero = "num. não informado"
        if (bairro == null || bairro=="") bairro = "bairro não informado"
        if (cidade == null || cidade=="") cidade = "cidade não informada"
        if (uf == null || uf=="") uf = "uf não informada"
        if (cep == null || cep=="") cep = "cep não informado"

        endereco= rua + ", " + numero + " - " + bairro +"," + cidade +"-" + uf + " - CEP:" + cep
    }

}