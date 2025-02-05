package model;

import controller.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContatoDAO {
    private final DAO dao = new DAO();
    private int id;

    public boolean inserirContato(Contato contato) {
        try {
            Connection conexao = dao.conectar();

            PreparedStatement newRow = conexao.prepareStatement("INSERT INTO contato (nome, telefone)" +
                    "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);

            newRow.setString(1, contato.getNome());
            newRow.setString(2, contato.getTelefone());

            int rowsAffected = newRow.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet rs = newRow.getGeneratedKeys();
                rs.next();
                id = rs.getInt(1);
                conexao.close();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public int getId(){
        return id;
    }
}
