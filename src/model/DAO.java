package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    String driver = "com.mysql.cj.jdbc.Driver";
    String enderecoIp = "jdbc:mysql://10.62.55.65:3306/dbAgenda";
    String usuario = "senac";
    String senha = "123@senac";

    public Connection conectar() {
        Connection conexao = null;

        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(enderecoIp, usuario, senha);
            return conexao;

        } catch (Exception error) {
            System.out.println(error);
            return null;
        }
    }
}