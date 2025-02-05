package model;

import controller.InfoReuniao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InfoReuniaoDAO {
    private final DAO dao = new DAO();

    public boolean inserirInfoReuniao(InfoReuniao infoReuniao) {
        try {
            Connection conexao = dao.conectar();

            PreparedStatement newRow = conexao.prepareStatement("INSERT INTO infoReuniao (idFkCont, idFkReuniao) " +
                    "VALUES (?, ?);");

            newRow.setInt(1, infoReuniao.getIdFkCont());
            newRow.setInt(2, infoReuniao.getIdFkReuniao());

            int rowsAffected = newRow.executeUpdate();
            conexao.close();
            return rowsAffected > 0;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
