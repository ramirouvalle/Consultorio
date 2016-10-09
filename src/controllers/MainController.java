package controllers;

import consultorio.Tools;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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
    @FXML
    private TextField txtRespParentezco;
    @FXML
    private TextArea txtDatosEspeciales;
    @FXML
    private TableColumn<Patient, Integer> colID;
    @FXML
    private TableColumn<Patient, String> colNombre;
    @FXML
    private TableColumn<Patient, String> colDireccion;
    @FXML
    private TableColumn<Patient, String> colTelefono;
    @FXML
    private TableColumn<Patient, String> colCelular;
    @FXML
    private TableColumn<Patient, String> colRFC;
    @FXML
    private Tab subTab1_2;
    @FXML
    private TableColumn<Patient, String> colCorreo;
    private ObservableList<Patient> listPatients = FXCollections.observableArrayList();
    @FXML
    private TableView<Patient> tbPacientes;
    @FXML
    private TableColumn<Patient, String> colApellidos;
    @FXML
    private TableColumn<Patient, String> colOpciones;
    @FXML
    private Tab tab1;
    @FXML
    private Tab subTab1_1;
    @FXML
    private Tab tab2;
    @FXML
    private Tab tab3;
    @FXML
    private TabPane tabPane_Pacientes;
    private int idPatientModified = 0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    

    /**
     * Boton que guarda un nuevo paciente en la base de datos
     * @param event 
     */
    @FXML
    private void btnGuardarPaciente_onclick(ActionEvent event) {
        String nombre, apePat, apeMat, genero, fechaNacimiento, telefono, celular, 
                RFC, correo, codPostal, direccion, responsable, referenciado, responsableParentezco, datosEspeciales;
        
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
        responsableParentezco = txtRespParentezco.getText();
        datosEspeciales = txtDatosEspeciales.getText();
        
        if (!nombre.equals("") && !apePat.equals("") && !apeMat.equals("") && !direccion.equals("") && !direccion.equals("") && !codPostal.equals("")) {
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
            
            int guardado;
            if (idPatientModified == 0) {
                //Paciente nuevo
                Patient patient = new Patient(nombre, apePat, apeMat, genero, fechaNacimiento, telefono, celular, RFC, correo, codPostal, direccion, responsable, referenciado, responsableParentezco, datosEspeciales);
                guardado = patient.newPatient(patient);
            }else{
                //Paciente existente
                Patient patient = new Patient(idPatientModified, nombre, apePat, apeMat, genero, fechaNacimiento, telefono, celular, RFC, correo, codPostal, direccion, responsable, referenciado, responsableParentezco, datosEspeciales);
                guardado = patient.modifyPatient(patient);
            }
            
            if(guardado > 0){
                Tools.mensajeInfo("El paciente se guardo correctamente.");
                limpiarCampos();
            }else{
                Tools.mensajeInfo("Problema al guardar el paciente.");
            }
            idPatientModified = 0;
        }else{
            Tools.mensajeInfo("Complete todo el formulario.");
        }
    }

    /**
     * Boton para limpiar los campos del paciente
     * @param event 
     */
    @FXML
    private void btnLimpiar_onclick(ActionEvent event) {
        limpiarCampos();
    }

    /**
     * Limpia los campos de la tab de nuevo paciente
     */
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
        txtRespParentezco.setText("");
        txtDatosEspeciales.setText("");
        dpFecNacimiento.getEditor().clear();
        genero.selectToggle(null);        
        idPatientModified = 0;
    }

    /**
     * Cada que se selecciona la tab de ver pacientes
     * @param event 
     */
    @FXML
    private void subTab1_2_Select(Event event) {
        if (subTab1_2.isSelected()) {
            getListPatients();
            setColumns();
            tbPacientes.setItems(listPatients);
        }
    }
    
    /**
     * Configura las columnas de la tabla de los pacientes
     */
    private void setColumns(){
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellidos.setCellValueFactory((TableColumn.CellDataFeatures<Patient, String> p) -> 
                new SimpleStringProperty(p.getValue().getApellidoPaterno() + " " + p.getValue().getApellidoMaterno()));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        colRFC.setCellValueFactory(new PropertyValueFactory<>("RFC"));
        colOpciones.setCellFactory((TableColumn<Patient, String> param) -> {
            TableCell<Patient, String> tc = new TableCell(){
                @Override
                protected void updateItem(Object item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        this.setGraphic(null);
                        return;
                    }
                    Button btnEditar = new Button("Editar");
                    btnEditar.setFocusTraversable(false);
                    btnEditar.setOnAction((ActionEvent event) -> {
                        Patient patient = (Patient) this.getTableView().getItems().get(this.getIndex());
                        editPatient(patient);
                    });
                    
                    Button btnBorrar = new Button("Borrar");
                    btnBorrar.setFocusTraversable(false);
                    btnBorrar.setOnAction((ActionEvent event) -> {
                        //Borrar paciente
                    });
                    
                    HBox hbox = new HBox(3);
                    hbox.getChildren().addAll(btnEditar, btnBorrar);
                    this.setGraphic(hbox);
                }
            };
            return tc;
        });
    }
    
    /**
     * Obtiene una lista de pacientes y la almacena en un observablelist
     */
    private void getListPatients(){
        listPatients.clear();
        List<Patient> patients = Patient.listPatients();
        for (Patient patient : patients) {
            listPatients.add(patient);
        }
    }
    
    /**
     * Editar los datos del paciente
     * @param patient 
     */
    private void editPatient(Patient patient){
        txtNombre.setText(patient.getNombre());
        txtApePat.setText(patient.getApellidoPaterno());
        txtApeMat.setText(patient.getApellidoMaterno());
        if (patient.getGenero().equals(rbMasculino.getText())) {
            genero.selectToggle(rbMasculino);
        }else{
            genero.selectToggle(rbFemenino);
        }
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(patient.getFechaNacimiento(), formatter);
            dpFecNacimiento.setValue(localDate);
        }catch(Exception ex){
            System.out.println(ex);
        }
        txtCelular.setText(patient.getCelular());
        txtCodPostal.setText(patient.getCodigoPostal());
        txtCorreo.setText(patient.getCorreo());
        txtDatosEspeciales.setText(patient.getDatosEspeciales());
        txtDireccion.setText(patient.getDireccion());
        txtRFC.setText(patient.getRFC());
        txtReferenciado.setText(patient.getReferenciado());
        txtRespParentezco.setText(patient.getResponsableParentezco());
        txtResponsable.setText(patient.getResponsable());
        txtTelefono.setText(patient.getTelefono());
        tabPane_Pacientes.getSelectionModel().select(subTab1_1);
        idPatientModified = patient.getId();
    }
}
