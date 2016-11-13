package models;

import sql.Conexion;

public class Consult {
    private int idConsult;
    private int idAppointment;
    private String indicaciones;

    public Consult(int idConsult, int idAppointment, String indicaciones) {
        this.idConsult = idConsult;
        this.idAppointment = idAppointment;
        this.indicaciones = indicaciones;
    }

    public Consult(int idAppointment, String indicaciones) {
        this.idAppointment = idAppointment;
        this.indicaciones = indicaciones;
    }

    public int getIdConsult() {
        return idConsult;
    }

    public void setIdConsult(int idConsult) {
        this.idConsult = idConsult;
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }
    
    public static int saveConsult(Consult consulta){
        String query = "INSERT INTO consultas (cit_id, con_indicaciones) VALUES ("+consulta.getIdAppointment()+", '"+consulta.getIndicaciones()+"')";
        return Conexion.executeUpdate(query);        
    }
}
