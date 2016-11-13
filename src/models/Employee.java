package models;

import consultorio.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sql.Conexion;

public class Employee {
    private int id;
    private String name;
    private String lastName;
    private String direction;
    private String phone;
    private String cellular;
    private String mail;
    private String username;
    private String password;
    private String type;

    /**
     * Inicio de sesión
     * @param username
     * @param password 
     */
    public Employee(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * 
     * @param id
     * @param name
     * @param lastName
     * @param direction
     * @param phone
     * @param cellular
     * @param mail
     * @param username
     * @param password
     * @param type 
     */
    public Employee(int id, String name, String lastName, String direction, String phone, String cellular, String mail, String username, String password, String type) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.direction = direction;
        this.phone = phone;
        this.cellular = cellular;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    /**
     * 
     * @param name
     * @param lastName
     * @param direction
     * @param phone
     * @param cellular
     * @param mail
     * @param username
     * @param password
     * @param type 
     */
    public Employee(String name, String lastName, String direction, String phone, String cellular, String mail, String username, String password, String type) {
        this.name = name;
        this.lastName = lastName;
        this.direction = direction;
        this.phone = phone;
        this.cellular = cellular;
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.type = type;
    }

        /**
     * Iniciar sesión
     * @param employee
     * @return retorna si existe hace o no login el usuario
     */
    public Employee loginEmployee(Employee employee){
        String query = "SELECT * FROM empleados WHERE emp_user = '"+employee.username+"' AND emp_password = '"+employee.password+"' ";
        ResultSet rs = Conexion.executeQuery(query);
        try {
            if(rs.next()) {
                int id_empleado = rs.getInt("emp_id");
                String nombre = rs.getString("emp_nombre");
                String apellido = rs.getString("emp_apellidos");
                String direccion = rs.getString("emp_direccion");
                String telefono = rs.getString("emp_telefono");
                String celular = rs.getString("emp_telefono_movil");
                String correo = rs.getString("emp_correo_electronico");
                String user = rs.getString("emp_user");
                String pass = rs.getString("emp_password");
                String tipo = rs.getString("emp_tipo");
                Employee e1 = new Employee(id_empleado, nombre, apellido, direccion, telefono, celular, correo, user, pass, tipo);
                return e1;
            }
        } catch (SQLException ex) {
            Tools.mensajeError("Problema al intentar logearse.");
        } finally{
            Conexion.closeConnection();
        }
        return null;
    }
    
    /**
     * Lista de empleados
     * @return 
     */
    public static List<Employee> listEmployees(){
        String query = "SELECT * FROM empleados";
        ResultSet rs = Conexion.executeQuery(query);
        List<Employee> employeesList = new ArrayList<Employee>();
        try {
            while(rs.next()){
                int id = rs.getInt("emp_id");
                String nombre = rs.getString("emp_nombre");
                String apellidos = rs.getString("emp_apellidos");
                String direccion = rs.getString("emp_direccion");
                String telefono = rs.getString("emp_telefono");
                String celular = rs.getString("emp_telefono_movil");
                String correo = rs.getString("emp_correo_electronico");
                String tipo = rs.getString("emp_tipo");
                String user = rs.getString("emp_user");
                String pass = rs.getString("emp_password");
                
                Employee emp = new Employee(id, nombre, apellidos, direccion, telefono, celular, correo, user, pass, tipo);
                employeesList.add(emp);
            }
            return employeesList;
        }catch(SQLException ex){
            Tools.mensajeError("Error en la consulta. "+ex);
            return null;
        }
        finally{
            Conexion.closeConnection();
        }
    } 
    
    /**
     * Retorna la informacion del empleado sabiendo el id
     * @param id_doctor
     * @return 
     */
    public static Employee getEmployee(int id_doctor){
        String query = "SELECT * FROM empleados WHERE emp_id ="+id_doctor;
        ResultSet rs = Conexion.executeQuery(query);
        try{
            while(rs.next()){
                int id = rs.getInt("emp_id");
                String nombre = rs.getString("emp_nombre");
                String apellidos = rs.getString("emp_apellidos");
                String direccion = rs.getString("emp_direccion");
                String telefono = rs.getString("emp_telefono");
                String celular = rs.getString("emp_telefono_movil");
                String correo = rs.getString("emp_correo_electronico");
                String tipo = rs.getString("emp_tipo");
                String user = rs.getString("emp_user");
                String pass = rs.getString("emp_password");
                
                Employee emp = new Employee(id, nombre, apellidos, direccion, telefono, celular, correo, user, pass, tipo);
                return emp;
            }
        }catch(SQLException ex){
            Tools.mensajeError(ex.toString());
        }
        finally{
            Conexion.closeConnection();
        }
        return null;
    }
    
    /**
     * Nombre completo del empleado
     * @return 
     */
    public String nombreCompleto(){
        return this.name + " " + this.lastName;
    }
    
    /**
     * Guardar un empleado en la base de datos
     * @param employee
     * @return 
     */
    public static int saveEmpleado(Employee employee){
        String query = "INSERT INTO empleados (emp_nombre, emp_apellidos, emp_direccion, emp_telefono, emp_telefono_movil, emp_correo_electronico,"
                + "emp_tipo, emp_user, emp_password) VALUES ('"+employee.getName()+"', '"+employee.getLastName()+"', '"+employee.getDirection()+"',"
                + " '"+employee.getPhone()+"', '"+employee.getCellular()+"', '"+employee.getMail()+"', '"+employee.getType()+"', "
                + " '"+employee.getUsername()+"', '"+employee.getPassword()+"' )";
        return Conexion.executeUpdate(query);
    }
           
    /**
     * Eliminar empleado
     * @param employee
     * @return 
     */
    public static int deleteEmpleado(Employee employee){
        String query = "DELETE FROM empleados WHERE emp_id = "+employee.getId();
        return Conexion.executeUpdate(query);
    }
    
    /**
     * Modificar empleado
     * @param employee
     * @return 
     */
    public static int modifyEmpleado(Employee employee){
        String query = "UPDATE empleados SET emp_nombre = '"+employee.getName()+"', emp_apellidos = '"+employee.getLastName()+"', emp_direccion = '"+employee.getDirection()+"'"
                + "emp_telefono = "+employee.getPhone()+", emp_telefono_movil = "+employee.getCellular()+", emp_correo_electronico = '"+employee.getMail()+"',"
                + "emp_tipo = '"+employee.getType()+"', emp_user = '"+employee.getUsername()+"', emp_password = '"+employee.getPassword()+"' WHERE emp_id = "+employee.getId();
        return Conexion.executeUpdate(query);
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellular() {
        return cellular;
    }

    public void setCellular(String cellular) {
        this.cellular = cellular;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
