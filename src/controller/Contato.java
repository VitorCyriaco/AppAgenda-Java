package controller;

public class Contato {
    private String nome, telefone;
    private int lista;

    public Contato(String nome, String telefone) {
        setNome(nome);
        setTelefone(telefone);
    }

    public void cadastroSucesso() {
        System.out.print("Contato cadastrado com sucesso!");
    }

    public void cadastroErro(){
        System.out.print("Erro ao cadastrar o contato!");
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}