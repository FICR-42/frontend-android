import com.google.gson.annotations.SerializedName

class CEP_Kotlin {
    /*

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String unidade;

    public CEP(String cep) {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }
    public final void buscar(String cep) throws Exception {
        this.cep = cep;
    try{
        // define a url
        String url = "http://viacep.com.br/ws/" + cep + "/json/";

        // define os dados
        JSONObject obj = new JSONObject(this.get(url));

        if (!obj.has("erro")) {
            this.cep = obj.getString("cep");
            this.logradouro = obj.getString("logradouro");
            this.complemento = obj.getString("complemento");
            this.bairro = obj.getString("bairro");
            this.localidade = obj.getString("localidade");
            this.uf = obj.getString("uf");

        } }catch (Exception e){
            e.getMessage();

        }
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public final String get(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

        } catch (MalformedURLException ex) {
             ex.getMessage();
        } catch (IOException ex) {
            ex.getMessage();
        }

        return result.toString();
    }
*/
    @SerializedName("cep") val cep: String? = null
    @SerializedName("logradouro") val logradouro: String? = null
    @SerializedName("complemento") val complemento: String? = null
    @SerializedName("bairro") val bairro: String? = null
    @SerializedName("localidade") val localidade: String? = null
    @SerializedName("uf") val uf: String? = null
    @SerializedName("unidade") val unidade: String? = null
    @SerializedName("ibge") val ibge: String? = null
    @SerializedName("gia") val gia: String? = null


}