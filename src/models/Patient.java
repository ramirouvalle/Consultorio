package models;

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
    private String referenciado;
    
    /**
     * Nuevo paciente
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
     */
    public Patient(String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String fechaNacimiento, String telefono, String celular, String RFC, String correo, String codigoPostal, String direccion, String responsable, String referenciado) {
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
  
    public int newPatient(Patient patient){
        String query = "INSERT INTO pacientes (nombre, apePaterno, apeMaterno, genero, fechaNacimiento, telefono, celular,"
                + "rfc, correo, codigoPostal, direccion, responsable, referenciado) "
                + "VALUES ('"+patient.getNombre()+"', '"+patient.getApellidoPaterno()+"', '"+patient.getApellidoMaterno()+"', "
                + " '"+patient.getGenero()+"', '"+patient.getFechaNacimiento()+"', '"+patient.getTelefono()+"', '"+patient.getCelular()+"', "
                + " '"+patient.getRFC()+"', '"+patient.getCorreo()+"', '"+patient.getCodigoPostal()+"', '"+patient.getDireccion()+"', "
                + " '"+patient.getResponsable()+"', '"+patient.getReferenciado()+"')";
                
        return Conexion.executeUpdate(query);
    }   
}
