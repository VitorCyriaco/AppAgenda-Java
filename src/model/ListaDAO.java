package model;

import controller.Lista;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ListaDAO {
    private final DAO dao = new DAO();

    public boolean inserirLista(Lista lista) {
        try {
            Connection conexao = dao.conectar();

            PreparedStatement newRow = conexao.prepareStatement("INSERT INTO lista (nome) " +
                    "VALUES (?);");

            newRow.setString(1, lista.getNome());

            int rowsAffected = newRow.executeUpdate();
            conexao.close();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
