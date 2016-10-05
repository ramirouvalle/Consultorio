package sql;

import consultorio.Tools;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author RAP4
 */
public class Conexion{
    private static final String DB = "consultorio";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String HOST = "jdbc:mysql://localhost:3306/"+DB+"?connectTimeout=5000";
    private static final String DRIVERNAME = "com.mysql.jdbc.Driver"; 
    private static Connection conn = null;
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVERNAME);
            try {
                conn = DriverManager.getConnection(HOST, USER, PASSWORD);
            } catch (SQLException ex) {
                Tools.mensajeError("No se pudo conectar con la base de datos.");
            }
        } catch (ClassNotFoundException ex) {
            Tools.mensajeError("No se encontro el driver.");
        }
        return conn;
    }
    
    public static ResultSet executeQuery(String query){
        getConnection();
        ResultSet rs = null;
        try {
            Statement stm = conn.createStatement();
            rs = stm.executeQuery(query);
        } catch (SQLException ex) {
            Tools.mensajeError("Error en el query: " + ex);
        }
        return rs;
    }
    
    public static void closeConnection(){
        try {
            if (conn != null) 
                conn.close();
        } catch (SQLException ex) {
            Tools.mensajeError("Problema al cerrar la conexion " + ex);
        }
    }
}
