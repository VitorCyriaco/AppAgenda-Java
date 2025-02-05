package controller;

public class Endereco {
    private String rua, numero, cidade, estado, cep, complemento;
    private int idfkCont;

    public Endereco(String rua, String numero, String cidade, String estado, String cep, String complemento, int idfkCont) {
        setRua(rua);
        setNumero(numero);
        setCidade(cidade);
        setEstado(estado);
        setCep(cep);
        setComplemento(complemento);
        setIdfkCont(idfkCont);
    }

    public void cadastroSucesso() {
        System.out.print("Endereço cadastrado com sucesso!");
    }

    public void cadastroErro() {
        System.out.print("Erro ao cadastrar endereço!");
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getIdfkCont() {
        return idfkCont;
    }

    public void setIdfkCont(int idfkCont) {
        this.idfkCont = idfkCont;
    }
}
