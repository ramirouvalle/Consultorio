package models;

import consultorio.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sql.Conexion;

/**
 *
 * @author RAP4
 */
public class Patient {
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero;
    private String fechaNacimiento;
    private String telefono;
    private String celular;
    private String RFC;
    private String correo;
    private String codigoPostal;
    private String direccion;
    private String responsable;
    private String responsableParentezco;
    private String referenciado;
    private String datosEspeciales;
    
    /**
     * Crear nuevo paciente
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param genero
     * @param fechaNacimiento
     * @param telefono
     * @param celular
     * @param RFC
     * @param correo
     * @param codigoPostal
     * @param direccion
     * @param responsable
     * @param referenciado
     * @param responsableParentezco
     * @param datosEspeciales 
     */
    public Patient(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String fechaNacimiento, String telefono, String celular, String RFC, String correo, String codigoPostal, String direccion, String responsable, String referenciado, String responsableParentezco, String datosEspeciales) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.celular = celular;
        this.RFC = RFC;
        this.correo = correo;
        this.codigoPostal = codigoPostal;
        this.direccion = direccion;
        this.responsable = responsable;
        this.referenciado = referenciado;
        this.responsableParentezco = responsableParentezco;
        this.datosEspeciales = datosEspeciales;
    }

    /**
     * Paciente existente
     * @param id
     * @param nombre
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param genero
     * @param fechaNacimiento
     * @param telefono
     * @param celular
     * @param RFC
     * @param correo
     * @param codigoPostal
     * @param direccion
     * @param responsable
     * @param responsableParentezco
     * @param referenciado
     * @param datosEspeciales 
     */
    public Patient(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String fechaNacimiento, String telefono, String celular, String RFC, String correo, String codigoPostal, String direccion, String responsable, String responsableParentezco, String referenciado, String datosEspeciales) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.celular = celular;
        this.RFC = RFC;
        this.correo = correo;
        this.codigoPostal = codigoPostal;
        this.direccion = direccion;
        this.responsable = responsable;
        this.responsableParentezco = responsableParentezco;
        this.referenciado = referenciado;
        this.datosEspeciales = datosEspeciales;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getReferenciado() {
        return referenciado;
    }

    public void setReferenciado(String referenciado) {
        this.referenciado = referenciado;
    }

    public String getResponsableParentezco() {
        return responsableParentezco;
    }

    public void setResponsableParentezco(String responsableParentezco) {
        this.responsableParentezco = responsableParentezco;
    }

    public String getDatosEspeciales() {
        return datosEspeciales;
    }

    public void setDatosEspeciales(String datosEspeciales) {
        this.datosEspeciales = datosEspeciales;
    }
  
    /**
     * Insertar un nuevo paciente en la base de datos.
     * @param patient
     * @return 
     */
    public int newPatient(Patient patient){
        String query = "INSERT INTO pacientes (pac_nombre, pac_apellidoPaterno, pac_apellidoMaterno, pac_fechaNacimiento, pac_genero, pac_telefono, pac_telefono_movil,"
                + "pac_rfc, pac_correo, pac_codigo_postal, pac_direccion, pac_responsable, pac_referenciado, pac_responsable_parentezco, pac_datos_especiales) "
                + "VALUES ('"+patient.getNombre()+"', '"+patient.getApellidoPaterno()+"', '"+patient.getApellidoMaterno()+"', "
                + " '"+patient.getFechaNacimiento()+"', '"+patient.getGenero()+"', '"+patient.getTelefono()+"', '"+patient.getCelular()+"', "
                + " '"+patient.getRFC()+"', '"+patient.getCorreo()+"', '"+patient.getCodigoPostal()+"', '"+patient.getDireccion()+"', "
                + " '"+patient.getResponsable()+"', '"+patient.getReferenciado()+"', '"+patient.getResponsableParentezco()+"', '"+patient.getDatosEspeciales()+"') ";
                
        return Conexion.executeUpdate(query);
    }   
    
    /**
     * Modificar un paciente.
     * @param patient
     * @return 
     */
    public int modifyPatient(Patient patient){
        String query = "UPDATE pacientes SET pac_nombre = '"+patient.getNombre()+"', pac_apellidoPaterno = '"+patient.getApellidoPaterno()+"', pac_apellidoMaterno = '"+patient.getApellidoMaterno()+"', "
                + " pac_fechaNacimiento = '"+patient.getFechaNacimiento()+"', pac_genero = '"+patient.getGenero()+"', pac_telefono = '"+patient.getTelefono()+"', pac_telefono_movil = '"+patient.getCelular()+"', "
                + " pac_rfc = '"+patient.getRFC()+"', pac_correo = '"+patient.getCorreo()+"', pac_codigo_postal = '"+patient.getCodigoPostal()+"', pac_direccion = '"+patient.getDireccion()+"', "
                + " pac_responsable = '"+patient.getResponsable()+"', pac_referenciado = '"+patient.getReferenciado()+"', pac_responsable_parentezco = '"+patient.getResponsableParentezco()+"', pac_datos_especiales = '"+patient.getDatosEspeciales()+"' WHERE pac_id = "+patient.getId();
                
        return Conexion.executeUpdate(query);
    } 
    
    /**
     * Lista de todos los pacientes.
     * @return 
     */
    public static List<Patient> listPatients(){
        String query = "SELECT * FROM pacientes";
        ResultSet rs = Conexion.executeQuery(query);
        List<Patient> patientsList = new ArrayList<Patient>();
        try {
            while(rs.next()){
                int id = rs.getInt("pac_id");
                String nombre = rs.getString("pac_nombre");
                String apePat = rs.getString("pac_apellidoPaterno");
                String apeMat = rs.getString("pac_apellidoMaterno");
                String fechaNac = rs.getString("pac_fechaNacimiento");
                String genero = rs.getString("pac_genero");
                String direccion = rs.getString("pac_direccion");
                String codPostal = rs.getString("pac_codigo_postal");
                String telefono = rs.getString("pac_telefono");
                String celular = rs.getString("pac_telefono_movil");
                String correo = rs.getString("pac_correo");
                String responsable = rs.getString("pac_responsable");
                String responsableParentezco = rs.getString("pac_responsable_parentezco");
                String referenciado = rs.getString("pac_referenciado");
                String rfc = rs.getString("pac_rfc");
                String datosEspeciales = rs.getString("pac_datos_especiales");
                
                Patient p1 = new Patient(id, nombre, apePat, apeMat, genero, fechaNac, telefono, celular, rfc, correo, codPostal, direccion, responsable, responsableParentezco, referenciado, datosEspeciales);
                patientsList.add(p1);
            }
            return patientsList;
        } catch (SQLException ex) {
            Tools.mensajeError("Error en la consulta. "+ex);
            return null;
        }catch (NullPointerException ex){
            System.out.println("elol "+ex);
            return null;
        } 
        finally{
            Conexion.closeConnection();
        }
    }
    
    /**
     * Eliminar un paciente de la base de datos.
     * @param patient
     * @return 
     */
    public int deletePatient(Patient patient){
        String query = "DELETE FROM pacientes WHERE pac_id = "+patient.getId();
        return Conexion.executeUpdate(query);
    }
    
    /**
     * Retorna el nombre completo del paciente
     * @return 
     */
    public String nombreCompleto(){
        return this.getNombre() + " " + this.getApellidoPaterno() + " " + this.getApellidoMaterno();
    }
}
