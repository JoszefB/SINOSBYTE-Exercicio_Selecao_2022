package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/aluno";
    private static final String USER = "root";
    private static final String PASS = "J0sz3f-B4nc0-d3-d4d0s"; //Digite a senha do seu DB aqui

    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch (ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Erro ao conectar com o banco", ex);
        }
    }

    public static void closeConnection(Connection con){
        try{
            if(con!=null){
                con.close();
            }
        }
        catch(SQLException exSQL){
            throw new RuntimeException("Ops! Algum erro inexperado aconteceu!");
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try{
            if(con!=null){
                stmt.close();
            }
        }
        catch(SQLException ex){
            throw new RuntimeException("Ops! Algum erro inexperado aconteceu!");
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try{
            if(con!=null){
                rs.close();
            }
        }
        catch(SQLException ex){
            throw new RuntimeException("Ops! Algum erro inexperado aconteceu!");
        }
    }
}
