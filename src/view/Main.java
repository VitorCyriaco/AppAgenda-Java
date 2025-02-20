package view;

import controller.*;
import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n\n******* Escolha uma Opção *******");
            System.out.println("\n1- Inserir/Atualizar Lista\n2- Novo Contato");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.println("1- Inserir\n2- Atualizar");
                    int opc = sc.nextInt();
                    if(opc == 1){
                        inputLista();
                        break;
                    }else if(opc == 2){
                        updateLista();
                    }else {
                        System.out.println("Opção inválida");
                    }

                    break;
                case 2:
                    inputContato();
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }

    private static final ListaDAO listaDAO = new ListaDAO();
    private static final ContatoDAO contatoDAO = new ContatoDAO();
    private static final EnderecoDAO enderecoDAO = new EnderecoDAO();
    private static final ReuniaoDAO reuniaoDAO = new ReuniaoDAO();
    private static final InfoReuniaoDAO infoReuniaoDAO = new InfoReuniaoDAO();

    private static final Scanner sc = new Scanner(System.in);

    private static void inputLista() {
        System.out.println("------ NOVA LISTA ------");
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty()) {
            System.out.println("Inserir algo");
        }else{
            Lista lista = new Lista(nome);
            boolean sucesso = listaDAO.inserirLista(lista);

            if (sucesso) {
                lista.cadastroSucesso();
            } else {
                lista.cadastroErro();
            }
        }
    }
    private static void updateLista(){
        System.out.println("------ ATUALIZAR LISTA ------");
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();

        if (nome.isEmpty()){
            System.out.println("Inserir algo");
        }else {
            Lista lista = new Lista(nome);
            boolean sucesso = listaDAO.atualizarLista(lista);

            if (sucesso) {
                lista.cadastroSucesso();
            } else {
                lista.cadastroErro();
            }
        }
    }

    private static void inputContato() {
        System.out.println("------ NOVO CONTATO ------");
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine().trim();

        if (nome.isEmpty() || telefone.isEmpty()) {
            System.out.println("Campo obrigatório");
        } else {
            Contato contato = new Contato(nome, telefone);
            boolean sucesso = contatoDAO.inserirContato(contato);

            if (sucesso) {
                contato.cadastroSucesso();
                System.out.println("\nDeseja cadastrar um endereço para o contato?\n1- Sim\n2- Não");
                int op = Integer.parseInt(sc.nextLine());

                switch (op) {
                    case 1:
                        inputEndereco(contatoDAO.getId());
                        auxiliar();
                        break;
                    case 2:
                        System.out.print("Contato sem endereço!");
                        auxiliar();
                        break;
                    default:
                        System.out.print("Opção Inválida!");
                        break;
                }
            } else {
                contato.cadastroErro();
            }
        }
    }

    private static void inputReuniao() {
        System.out.println("------ NOVA REUNIÃO ------");
        System.out.print("Data: ");
        String data = sc.nextLine().trim();
        System.out.print("Motivo: ");
        String motivo = sc.nextLine().trim();
        System.out.print("Link: ");
        String link = sc.nextLine().trim();

        Reuniao reuniao = new Reuniao(data, motivo, link);
        boolean sucesso = reuniaoDAO.inserirReuniao(reuniao);

        if (sucesso) {
            inputInfoReuniao(contatoDAO.getId(), reuniaoDAO.getId());
        } else {
            reuniao.cadastroErro();
        }
    }

    private static void inputEndereco(int idFk) {

        System.out.print("------ NOVO ENDEREÇO ------\n");

        System.out.print("Rua: ");
        String rua = sc.nextLine().trim();
        System.out.print("Número: ");
        String numero = sc.nextLine().trim();
        System.out.print("CEP: ");
        String cep = sc.nextLine().trim();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine().trim();
        System.out.print("Estado: ");
        String estado = sc.nextLine().trim();
        System.out.print("Complemento: ");
        String complemento = sc.nextLine().trim();

        Endereco endereco = new Endereco(rua, numero, cidade, estado, cep, complemento, idFk);
        boolean sucesso = enderecoDAO.inserirEndereco(endereco);

        if (sucesso) {
            endereco.cadastroSucesso();
        } else {
            endereco.cadastroErro();
        }
    }

    private static void inputInfoReuniao(int idFkCont, int idFkReuniao) {

        InfoReuniao infoReuniao = new InfoReuniao(idFkCont, idFkReuniao);
        boolean sucesso = infoReuniaoDAO.inserirInfoReuniao(infoReuniao);

        if(sucesso){
            infoReuniao.cadastroSucesso();
        }else{
            infoReuniao.cadastroErro();
        }
    }
    private static void auxiliar(){
        System.out.println("\nDeseja iniciar uma reunião?\n1- Sim\n2- Não");
        int rn = Integer.parseInt(sc.nextLine());
        switch (rn){
            case 1:
                inputReuniao();
                break;
            case 2:
                System.out.println("Contato sem reunião!");
                break;
            default:
                System.out.print("Opção Inválida!");
                break;
        }
    }
}