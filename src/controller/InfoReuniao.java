package controller;

public class InfoReuniao {
    private int idFkCont, idFkReuniao;

    public InfoReuniao(int idFkCont, int idFkReuniao) {
        setIdFkCont(idFkCont);
        setIdFkReuniao(idFkReuniao);
    }

    public void cadastroSucesso() {
        System.out.print("Reunião cadastrada com sucesso!");
    }

    public void cadastroErro() {
        System.out.print("Erro ao cadastrar a reunião!");
    }

    public int getIdFkCont() {
        return idFkCont;
    }

    public void setIdFkCont(int idFkCont) {
        this.idFkCont = idFkCont;
    }

    public int getIdFkReuniao() {
        return idFkReuniao;
    }

    public void setIdFkReuniao(int idFkReuniao) {
        this.idFkReuniao = idFkReuniao;
    }
}
