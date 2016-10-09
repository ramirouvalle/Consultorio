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
    private static final String PASSWORD = "";
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
    
    /**
     * Ejecuta un query y nos retorna un ResultSet
     * @param query
     * @return ResultSet
     */
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
    
    /**
     * Insert, update and delete
     * @param query 
     * @return Retorna el numero de filas afectadas o 0 si no afecto ninguna.
     */
    public static int executeUpdate(String query){
        getConnection();
        try{
            Statement stm = conn.createStatement();
            return stm.executeUpdate(query);
        } catch (SQLException ex) {
            Tools.mensajeError("Error en el query: " + ex);
            return 0;
        }finally{
            Conexion.closeConnection();
        }
    }
    
    public static void closeConnection(){
        try {
            if (conn != null) 
                conn.close();
        } catch (SQLException ex) {
            Tools.mensajeError("Problema al cerrar la conexion " + ex);
        }
    }
    
    public static void statusConnection(){
        try {
            if (conn != null) {
                if (conn.isClosed()) {
                    System.out.println("Conexion cerrada");
                }else{
                    System.out.println("Conexion abierta");
                }
            }else{
                System.out.println("Conexion nula");
            }                
        } catch (SQLException ex) {
            Tools.mensajeError("Error al consultar el estado de la conexion. "+ex);
        }
    }
}
