package models;

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
    public int newAppointment(Appointment ap){
        String query = "INSERT INTO citas (pac_id, emp_id, cit_fecha, cit_hora)"
                + "VALUES ("+ap.getIdPatient()+", "+ap.getIdDoctor()+", '"+ap.getDate()+"', '"+ap.getHour()+"')";
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
