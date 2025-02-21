package model;

import controller.Reuniao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReuniaoDAO {
    private final DAO dao = new DAO();
    private int id;

    public boolean inserirReuniao(Reuniao reuniao) {
        try {
            Connection conexao = dao.conectar();

            PreparedStatement newRow = conexao.prepareStatement("INSERT INTO reuniao (dataReuniao, motivoReuniao, link) " +
                    "VALUES (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);

            newRow.setString(1, reuniao.getData());
            newRow.setString(2, reuniao.getMotivoReuniao());
            newRow.setString(3, reuniao.getLink());

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

    public boolean atualizarReuniao(Reuniao reuniao) {

        try {
            Connection conexao = dao.conectar();

            PreparedStatement updateRow = conexao.prepareStatement("UPDATE reuniao SET dataReuniao = ?, motivoReuniao = ?, link = ? WHERE id = ?;");

            updateRow.setString(1, reuniao.getData());
            updateRow.setString(2, reuniao.getMotivoReuniao());
            updateRow.setString(3, reuniao.getLink());
            updateRow.setInt(4, reuniao.getId());

            int rowsAffected = updateRow.executeUpdate();
            conexao.close();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
