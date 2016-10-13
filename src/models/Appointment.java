package models;

public class Appointment {
    private int id;
    private int idPatient;
    private int idDoctor;
    private String houw;
    private String date;

    public Appointment(int id, int idPatient, int idDoctor, String houw, String date) {
        this.id = id;
        this.idPatient = idPatient;
        this.idDoctor = idDoctor;
        this.houw = houw;
        this.date = date;
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

    public String getHouw() {
        return houw;
    }

    public void setHouw(String houw) {
        this.houw = houw;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
