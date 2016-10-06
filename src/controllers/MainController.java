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
    @FXML
    private TextField txtCelular;
    @FXML
    private TextField txtCodPostal;
    @FXML
    private TextField txtRFC;
    @FXML
    private TextField txtCorreo;
    @FXML
    private TextField txtResponsable;
    @FXML
    private TextField txtReferenciado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    /**
     * Al guardar el paciente en la base de datos
     * @param event 
     */
    @FXML
    private void btnGuardarPaciente_onclick(ActionEvent event) {
        String nombre, apePat, apeMat, genero, fechaNacimiento, telefono, celular, 
                RFC, correo, codPostal, direccion, responsable, referenciado;
        
        nombre = txtNombre.getText();
        apePat = txtApePat.getText();
        apeMat = txtApeMat.getText();
        telefono = txtTelefono.getText(); 
        celular = txtCelular.getText();
        RFC = txtRFC.getText();
        correo = txtCorreo.getText();
        codPostal = txtCodPostal.getText();
        direccion = txtDireccion.getText();
        responsable = txtResponsable.getText();
        referenciado = txtReferenciado.getText();
        
        if (!nombre.equals("") && !apePat.equals("") && !apeMat.equals("") && !direccion.equals("")) {
            try{
                fechaNacimiento = dpFecNacimiento.getValue().toString();
            }catch(NullPointerException ex){
                Tools.mensajeInfo("Seleccione una fecha de nacimiento.");
                return;
            }

            try{
                Toggle toggle = this.genero.getSelectedToggle();
                RadioButton rbSelected = (RadioButton) toggle;
                genero = rbSelected.getText();
            }catch(NullPointerException ex){
                Tools.mensajeInfo("Seleccione un genero.");
                return;
            }
            
            Patient patient = new Patient(nombre, apePat, apeMat, genero, fechaNacimiento, telefono, celular, RFC, correo, codPostal, direccion, responsable, referenciado);
            int guardado = patient.newPatient(patient);
            
            if(guardado > 0){
                Tools.mensajeInfo("El paciente se guardo correctamente.");
                limpiarCampos();
            }
        }else{
            Tools.mensajeInfo("Complete todo el formulario.");
        }
    }

    @FXML
    private void btnLimpiar_onclick(ActionEvent event) {
        limpiarCampos();
    }

    private void limpiarCampos(){
        txtNombre.setText("");
        txtApePat.setText("");
        txtApeMat.setText("");
        txtCelular.setText("");
        txtCodPostal.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtRFC.setText("");
        txtReferenciado.setText("");
        txtResponsable.setText("");
        txtTelefono.setText("");
        dpFecNacimiento.getEditor().clear();
        genero.selectToggle(null);
    }
}
