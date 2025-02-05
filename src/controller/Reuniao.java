package controller;

public class Reuniao {
    private String data, motivoReuniao, link;

    public Reuniao(String data, String motivoReuniao, String link) {
        setData(data);
        setMotivoReuniao(motivoReuniao);
        setLink(link);
    }

    public void cadastroSucesso() {
        System.out.print("Reunião cadastrada com sucesso!");
    }

    public void cadastroErro() {
        System.out.print("Erro ao cadastrar a reunião!");
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMotivoReuniao() {
        return motivoReuniao;
    }

    public void setMotivoReuniao(String motivoReuniao) {
        this.motivoReuniao = motivoReuniao;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
