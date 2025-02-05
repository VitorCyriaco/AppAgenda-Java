package model;

import controller.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class EnderecoDAO {
    private final DAO dao = new DAO();

    public boolean inserirEndereco(Endereco endereco) {
        try {
            Connection conexao = dao.conectar();

            PreparedStatement newRow = conexao.prepareStatement("INSERT INTO endereco (rua, numero, cidade, estado, cep, complemento, idFkCont) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);");

            newRow.setString(1, endereco.getRua());
            newRow.setString(2, endereco.getNumero());
            newRow.setString(3, endereco.getCidade());
            newRow.setString(4, endereco.getEstado());
            newRow.setString(5, endereco.getCep());
            newRow.setString(6, endereco.getComplemento());
            newRow.setInt(7, endereco.getIdfkCont());

            int rowsAffected = newRow.executeUpdate();
            conexao.close();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
