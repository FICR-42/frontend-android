package model;

public class Denuncia {

    private String id_denuncia;
    private String placa;
    private String motor;
    private String marcaModelo;
    private String cep;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String referencia;
    private String email;
    private String descricao;
    private String data;
    private boolean selected;



    public String getId_denuncia() {
        return id_denuncia;
    }

    public void setId_denuncia(String id_denuncia) {
        this.id_denuncia = id_denuncia;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public static class DenunciaBuilder{

        private String id_denuncia;
        private String placa;
        private String motor;
        private String marcaModelo;
        private String cep;
        private String rua;
        private String numero;
        private String complemento;
        private String bairro;
        private String cidade;
        private String uf;
        private String referencia;
        private String email;
        private String descricao;
        private String data;
        private boolean selected;

        public DenunciaBuilder setId_denuncia(String id_denuncia) {
            this.id_denuncia = id_denuncia;
            return this;
        }

        public DenunciaBuilder setPlaca(String placa) {
            this.placa = placa;
            return this;
        }

        public DenunciaBuilder setMotor(String motor) {
            this.motor = motor;
            return this;
        }

        public DenunciaBuilder setMarcaModelo(String marcaModelo) {
            this.marcaModelo = marcaModelo;
            return this;
        }

        public DenunciaBuilder setCep(String cep) {
            this.cep = cep;
            return this;
        }

        public DenunciaBuilder setRua(String rua) {
            this.rua = rua;
            return this;
        }

        public DenunciaBuilder setNumero(String numero) {
            this.numero = numero;
            return this;
        }

        public DenunciaBuilder setComplemento(String complemento) {
            this.complemento = complemento;
            return this;
        }

        public DenunciaBuilder setBairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public DenunciaBuilder setCidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public DenunciaBuilder setUf(String uf) {
            this.uf = uf;
            return this;
        }

        public DenunciaBuilder setReferencia(String referencia) {
            this.referencia = referencia;
            return this;
        }

        public DenunciaBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public DenunciaBuilder setDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public DenunciaBuilder setData(String data) {
            this.data = data;
            return this;
        }

        public DenunciaBuilder setSelected(boolean selected) {
            this.selected = selected;
            return this;
        }

        private DenunciaBuilder(){}

        public static DenunciaBuilder builder(){

           return new DenunciaBuilder();
        }

        public Denuncia build(){
            Denuncia denuncia = new Denuncia();

            denuncia.bairro=bairro;
            denuncia.cep=cep;
            denuncia.cidade = cidade;
            denuncia.complemento=complemento;
            denuncia.data=data;
            denuncia.descricao=descricao;
            denuncia.email=email;
            denuncia.id_denuncia=id_denuncia;
            denuncia.marcaModelo=marcaModelo;
            denuncia.motor=motor;
            denuncia.numero=numero;
            denuncia.placa=placa;
            denuncia.referencia=referencia;
            denuncia.rua=rua;
            denuncia.selected=selected;
            denuncia.uf=uf;

            return denuncia;

        }

    }


}
