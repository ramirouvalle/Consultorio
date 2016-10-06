package controllers;

import consultorio.Tools;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import models.Patient;

/**
 * FXML Controller class
 *
 * @author RAP4
 */
public class MainController implements Initializable {

    @FXML
    private ToggleGroup genero;
    @FXML
    private Button btnGuardarPaciente;
    @FXML
    private Button btnLimpiar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApePat;
    @FXML
    private TextField txtApeMat;
    @FXML
    private RadioButton rbMasculino;
    @FXML
    private RadioButton rbFemenino;
    @FXML
    private DatePicker dpFecNacimiento;
    @FXML
    private TextArea txtDireccion;
    @FXML
    private TextField txtTelefono;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    /**
     * Al guardar el paciente en la base de datos
     * @param event 
     */
    @FXML
    private void btnGuardarPaciente_onclick(ActionEvent event) {
        String nombre, apePat, apeMat, direccion, telefono, genero, fechaNacimiento;
        nombre = txtNombre.getText();
        apePat = txtApePat.getText();
        apeMat = txtApeMat.getText();
        direccion = txtDireccion.getText();
        telefono = txtTelefono.getText();        
        
        if (!nombre.equals("") && !apePat.equals("") && !apeMat.equals("") && !direccion.equals("") && !telefono.equals("")) {
            try{
                fechaNacimiento = dpFecNacimiento.getValue().toString();
            }catch(NullPointerException ex){
                Tools.mensajeInfo("Seleccione una fecha de nacimiento.");
                return;
            }

            try{
                Toggle toggle = rbMasculino.getToggleGroup().getSelectedToggle();
                RadioButton rbSelected = (RadioButton) toggle;
                genero = rbSelected.getText();
            }catch(NullPointerException ex){
                Tools.mensajeInfo("Seleccione un genero.");
                return;
            }
            
            Patient patient = new Patient(nombre, apePat, apeMat, genero, fechaNacimiento, direccion, telefono);
            patient.newPatient(patient);
        }else{
            Tools.mensajeInfo("Complete todo el formulario.");
        }
    }

    @FXML
    private void btnLimpiar_onclick(ActionEvent event) {
    }
    
}
