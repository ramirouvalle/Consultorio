package models;

import consultorio.Tools;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sql.Conexion;

public class Appointment {
    private int id;
    private int idPatient;
    private int idDoctor;
    private String hour;
    private String date;

    /**
     * 
     * @param idPatient
     * @param idDoctor
     * @param hour
     * @param date 
     */
    public Appointment(int idPatient, int idDoctor, String hour, String date) {
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
        this.hour = hour;
        this.date = date;
    }
    
    /**
     * 
     * @param id
     * @param idPatient
     * @param idDoctor
     * @param hour
     * @param date 
     */
    public Appointment(int id, int idPatient, int idDoctor, String hour, String date) {
        this.id = id;
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
        this.hour = hour;
        this.date = date;
    }

    /**
     * Guardar nueva cita
     * @param ap
     * @return 
     */
    public static int newAppointment(Appointment ap){
        String query = "INSERT INTO citas (pac_id, emp_id, cit_fecha, cit_hora)"
                + "VALUES ("+ap.getIdPatient()+", "+ap.getIdDoctor()+", '"+ap.getDate()+"', '"+ap.getHour()+"')";
        return Conexion.executeUpdate(query);
    }   
    
    /**
     * Lista de todas las citas
     * @return 
     */
    public static List<Appointment> listAppointments() {
        String query = "SELECT * FROM citas ORDER BY cit_fecha, cit_hora";
        ResultSet rs = Conexion.executeQuery(query);
        List<Appointment> appointmentsList = new ArrayList<Appointment>();
        try{
            while(rs.next()){
                Appointment appointment = new Appointment(rs.getInt("cit_id"), rs.getInt("pac_id"), rs.getInt("emp_id"), rs.getString("cit_hora"), rs.getString("cit_fecha"));
                appointmentsList.add(appointment);
            }
            return appointmentsList;
        }catch(SQLException ex){
            Tools.mensajeError("Error en la consulta. "+ex);
            return null;
        }finally{
            Conexion.closeConnection();
        }
    }
    
    /**
     * Elimina la cita que se indique
     * @param id_cita
     */
    public static int deleteAppointment(int id_cita){
        String query = "DELETE FROM citas WHERE cit_id = " + id_cita;
        return Conexion.executeUpdate(query);
    }
    
    public static int modifyAppointment(Appointment cita){
        String query = "UPDATE citas SET pac_id = "+cita.getIdPatient()+", emp_id = "+cita.getIdDoctor()+", cit_hora = '"+cita.getHour()+"', cit_fecha = '"+cita.getDate()+"' "
                + "WHERE cit_id = "+cita.getId();
        return Conexion.executeUpdate(query);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String houw) {
        this.hour = houw;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }    
}
