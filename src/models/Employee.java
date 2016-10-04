package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import sql.Conexion;

public class Employee {
    private int id;
    private String name;
    private String lastName;
    private String mail;
    private String username;
    private String password;

    /**
     * Inicio de sesión
     * @param username
     * @param password 
     */
    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Employee(int id, String name, String lastName, String mail, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Iniciar sesión
     * @param employee
     * @return retorna si existe hace o no login el usuario
     */
    public Employee loginEmployee(Employee employee){
        Connection conn = Conexion.getConnection();
        ResultSet rs = Conexion.executeQuery("SELECT * FROM empleados WHERE user = '"+employee.username+"' AND password = '"+employee.password+"' ");
        try {
            if(rs.next()) {
                int id_empleado = rs.getInt("id_empleado");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellidos");
                String correo = rs.getString("correo");
                String user = rs.getString("user");
                String pass = rs.getString("password");
                Employee e1 = new Employee(id_empleado, nombre, apellido, correo, user, pass);
                return e1;
            }
        } catch (SQLException ex) {
            System.out.println("xx" + ex);
        }
        return null;
    }
    
    
}
