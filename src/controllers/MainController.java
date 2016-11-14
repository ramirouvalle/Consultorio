package controllers;

import consultorio.Tools;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
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
import models.Appointment;
import models.Consult;
import models.Employee;
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
    private ObservableList<Appointment> listAppointments = FXCollections.observableArrayList();
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
    private TabPane tabPane_Pacientes;
    private int idPatientModified = 0;
    @FXML
    private Tab subTab2_1;
    @FXML
    private ComboBox<Patient> cbBuscarPaciente;
    @FXML
    private DatePicker dpFechaCita;
    @FXML
    private TextField txtHoraCita;
    @FXML
    private TextField txtNomCompPaciente;
    @FXML
    private ComboBox<Employee> cbxDoctor;
    @FXML
    private TextField txtDireccionCita;
    @FXML
    private TextField txtResponsableCita;
    private Patient patientCita;
    @FXML
    private Button btnGuardarCita;
    @FXML
    private TextField txtNombreDoctor;
    private Employee doctorCita;
    @FXML
    private TableView<Appointment> tbCitas;
    @FXML
    private TableColumn<Appointment, String> colDoctor;
    @FXML
    private TableColumn<Appointment, String> colFecha;
    @FXML
    private TableColumn<Appointment, String> colHora;
    @FXML
    private TableColumn<Appointment, String> colOpcionesCita;
    @FXML
    private Tab subTab2_2;
    @FXML
    private TableColumn<Appointment, String> colPacienteCita;
    @FXML
    private TabPane tabPane_Citas;
    @FXML
    private Tab subTab2_3;
    private int idAppointmentEdit = 0;
    @FXML
    private TextField txtNomPacConsulta;
    @FXML
    private TextField txtGeneroConsulta;
    @FXML
    private TextField txtFechaNacConsulta;
    @FXML
    private TextField txtDireccionConsulta;
    @FXML
    private TextField txtTelefonoConsulta;
    @FXML
    private TextField txtCelularConsulta;
    @FXML
    private TextField txtResponsableConsulta;
    @FXML
    private TextField txtDatosEspecialesConsulta;
    @FXML
    private TextField txtDoctorConsulta;
    @FXML
    private TextField txtFechaConsulta;
    @FXML
    private TextField txtHoraConsultar;
    @FXML
    private Button btnGuardarConsulta;
    @FXML
    private TextArea txtIndicacionesConsulta;
    private Appointment citaConsulta;
    @FXML
    private Button btnGuardarEmployee;
    @FXML
    private TextField txtNombreEmpleado;
    @FXML
    private TextField txtApellidosEmpleado;
    @FXML
    private TextField txtDireccionEmpleado;
    @FXML
    private TextField txtTelefonoEmpleado;
    @FXML
    private TextField txtCelularEmpleado;
    @FXML
    private TextField txtCorreoEmpleado;
    @FXML
    private TextField txtUsuarioEmpleado;
    @FXML
    private PasswordField pwClaveEmpleado;
    @FXML
    private PasswordField pwClave2Empleado;
    @FXML
    private ComboBox<String> cbEmpleado;
    @FXML
    private TableColumn<Employee, String> colEmpleado;
    @FXML
    private TableColumn<Employee, String> colDireccionEmpleado;
    @FXML
    private TableColumn<Employee, String> colTelefonoEmpleado;
    @FXML
    private TableColumn<Employee, String> colCelularEmpleado;
    @FXML
    private TableColumn<Employee, String> colCorreoEmpleado;
    @FXML
    private TableColumn<Employee, String> colOcupacionEmpleado;
    @FXML
    private TableColumn<Employee, String> colOpcionesEmpleado;
    @FXML
    private TableView<Employee> tbEmpleado;
    @FXML
    private Tab subTab3_1;
    @FXML
    private Tab subTab3_2;
    private Employee empleadoEditando;
    private ObservableList<Employee> listDoctorsx = FXCollections.observableArrayList();
    @FXML
    private TabPane tabPane_Empleados;
    @FXML
    private TabPane tabPaneGeneral;
    @FXML
    private Tab subTab1_3;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbEmpleado.setItems(FXCollections.observableArrayList("Asistente","Doctor"));
        getListDoctors();
        cbxDoctor.setCellFactory((ListView<Employee> param) -> new ListCell<Employee>(){
            @Override
            protected void updateItem(Employee item, boolean empty) {
                try{
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        setText(item.nombreCompleto());
                    }
                }catch(Exception ex){
                    System.out.println(ex);
                }
            }
        });        
    }    

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
     * Boton para limpiar los campos del paciente de la pestaña de agregar paciente
     * @param event 
     */
    @FXML
    private void btnLimpiar_onclick(ActionEvent event) {
        limpiarCampos();
    }

    /**
     * Limpia los campos de la tab de nuevo paciente de la pestaña de agregar paciente
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
                    btnEditar.getStyleClass().add("btnEdit");
                    btnEditar.setFocusTraversable(false);
                    btnEditar.setOnAction((ActionEvent event) -> {
                        //Modificar paciente
                        Patient patient = (Patient) this.getTableView().getItems().get(this.getIndex());
                        editPatient(patient);
                    });
                    
                    Button btnBorrar = new Button("Borrar");
                    btnBorrar.getStyleClass().add("btnDelete");
                    btnBorrar.setFocusTraversable(false);
                    btnBorrar.setOnAction((ActionEvent event) -> {
                        //Borrar paciente
                        if (Tools.mensajeConfirmacion("¿Desea eliminar el paciente?")) {
                            Patient patient = (Patient) this.getTableView().getItems().get(this.getIndex());
                            int guardado = patient.deletePatient(patient);
                            if (guardado > 0) {
                                Tools.mensajeInfo("El paciente se ha eliminado correctamente.");
                                listPatients.remove(patient);
                            }else{
                                Tools.mensajeInfo("No se ha podido eliminar el paciente.");
                            }
                        }
                    });
                    
                    Button btnCita = new Button("Cita");
                    btnCita.getStyleClass().add("btnCita");
                    btnCita.setFocusTraversable(false);
                    btnCita.setOnAction((ActionEvent event) -> {
                        //Agendar cita
                        Patient patient = (Patient) this.getTableView().getItems().get(this.getIndex());
                        agendarCitaAPaciente(patient);
                    });
                    
                    HBox hbox = new HBox(3);
                    hbox.getChildren().addAll(btnEditar, btnBorrar, btnCita);
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

    /**
     * Al seleccionar la pestaña de nueva cita
     * @param event 
     */
    @FXML
    private void subTab2_1_Select(Event event) {    
        if (subTab2_1.isSelected()) {
            getListPatients();
            ObservableList<Patient> list = FXCollections.observableArrayList();
            list.addAll(copyListPatients(listPatients));
            
            cbBuscarPaciente.setCellFactory((ListView<Patient> param) -> new ListCell<Patient>(){
                @Override
                protected void updateItem(Patient item, boolean empty) {
                    try{
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setGraphic(null);
                        } else {
                            setText(item.nombreCompleto());
                        }
                    }catch(Exception ex){
                        System.out.println(ex + "X");
                    }
                }
            });
            
            cbBuscarPaciente.setPromptText("Nombre del paciente");
            cbBuscarPaciente.getEditor().textProperty().addListener(new ChangeListener<String>(){
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    try{
                        if (newValue.contains("models") || newValue.equals("")) {
                            return;
                        }
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).nombreCompleto().contains(newValue)) {
                                if (!cbBuscarPaciente.getItems().contains(list.get(i))) {
                                    cbBuscarPaciente.getItems().add(list.get(i));
                                }
                            }else{
                                if (cbBuscarPaciente.getItems().contains(list.get(i))) {
                                    cbBuscarPaciente.getItems().remove(list.get(i));
                                }
                            }
                        }
                    }catch(Exception ex){
                        System.out.println(ex + "y");
                    }
                }
            });           
            //ObservableList<Employee> listDoctors = FXCollections.observableArrayList(Employee.listEmployees());
//            cbxDoctor.setCellFactory((ListView<Employee> param) -> new ListCell<Employee>(){
//                @Override
//                protected void updateItem(Employee item, boolean empty) {
//                    try{
//                        super.updateItem(item, empty);
//                        if (item == null || empty) {
//                            setGraphic(null);
//                        } else {
//                            setText(item.nombreCompleto());
//                        }
//                    }catch(Exception ex){
//                        System.out.println(ex);
//                    }
//                }
//            });
//            cbxDoctor.setItems(listDoctorsx);
        }else{
            limpiarTabCitas();
        }
    }

    /**
     * Al seleccionar un paciente del combobox
     * @param event 
     */
    @FXML
    private void cbBuscarPaciente_onAction(ActionEvent event) {
        try{
            patientCita = cbBuscarPaciente.getSelectionModel().getSelectedItem();
            if (patientCita != null) {
                txtNomCompPaciente.setText(patientCita.nombreCompleto());
                txtDireccionCita.setText(patientCita.getDireccion());
                txtResponsableCita.setText(patientCita.getResponsable());
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    /**
     * Copia la lista de pacientes y devuelve una nueva
     * @param listPatients
     * @return 
     */
    private ObservableList<Patient> copyListPatients(ObservableList<Patient> listPatients){
        ObservableList<Patient> listTemp = FXCollections.observableArrayList();
        for (int i = 0; i < listPatients.size(); i++) {
            Patient p = new Patient(listPatients.get(i).getId(), listPatients.get(i).getNombre(), listPatients.get(i).getApellidoPaterno(), listPatients.get(i).getApellidoMaterno(), listPatients.get(i).getGenero(), listPatients.get(i).getFechaNacimiento(), listPatients.get(i).getTelefono(), listPatients.get(i).getCelular(), listPatients.get(i).getRFC(), listPatients.get(i).getCorreo(), listPatients.get(i).getCodigoPostal(), listPatients.get(i).getDireccion(), listPatients.get(i).getResponsable(), listPatients.get(i).getResponsableParentezco(), listPatients.get(i).getReferenciado(), listPatients.get(i).getDatosEspeciales());
            listTemp.add(p);
        } 
        return listTemp;
    }

    /**
     * Al presionar el boton de guardar cita
     * @param event 
     */
    @FXML
    private void btnGuardarCita_onclick(ActionEvent event) {
        if (patientCita != null && doctorCita != null && !txtHoraCita.getText().equals("")) {
            int idPaciente = patientCita.getId();
            int idDoctor = doctorCita.getId();
            String fechaCita;
            try{
                fechaCita = dpFechaCita.getValue().toString();
            }catch(NullPointerException ex){
                Tools.mensajeInfo("Seleccione una fecha de nacimiento.");
                return;
            }
            String horaCita = txtHoraCita.getText();
            int guardado;
            if (idAppointmentEdit == 0) {
                Appointment cita = new Appointment(idPaciente, idDoctor, horaCita, fechaCita);
                guardado = Appointment.newAppointment(cita);
            }else{
                Appointment cita = new Appointment(idAppointmentEdit, idPaciente, idDoctor, horaCita, fechaCita);
                guardado = Appointment.modifyAppointment(cita);
            }
            
            if (guardado > 0) {
                Tools.mensajeInfo("La cita se guardo correctamente.");
                limpiarTabCitas();
            }else{
                Tools.mensajeError("No se a podido guardar la cita.");
            }
            idAppointmentEdit = 0;
        }
    }

    /**
     * Al seleccionar un doctor del combobox
     * @param event 
     */
    @FXML
    private void cbxDoctor_onAction(ActionEvent event) {
        doctorCita = cbxDoctor.getSelectionModel().getSelectedItem();
        if (doctorCita != null) {
            txtNombreDoctor.setText(doctorCita.nombreCompleto());
        }
    }
    /**
     * Limpiar los campos de la tab agendar cita
     */
    private void limpiarTabCitas(){
        patientCita = null;
        doctorCita = null;
        txtNomCompPaciente.setText("");
        txtDireccionCita.setText("");
        txtResponsableCita.setText("");
        txtNombreDoctor.setText("");     
        cbxDoctor.getItems().clear();
        cbBuscarPaciente.getItems().clear();
        cbxDoctor.getSelectionModel().clearSelection();
        cbBuscarPaciente.getSelectionModel().clearSelection();
        dpFechaCita.getEditor().clear();
        txtHoraCita.setText("");
    }

    /**
     * Al seleccionar la tab de ver todas las citas
     * @param event 
     */
    @FXML
    private void subTab2_2_Select(Event event) {
        if (subTab2_2.isSelected()) {
            getListAppointments();
            setColumnsAppointments();
            tbCitas.setItems(listAppointments);
        }
    }

    /**
     * Crea una lista con las citas
     */
    private void getListAppointments() {
        listAppointments.clear();
        List<Appointment> appointments = Appointment.listAppointments();
        for (Appointment appointment : appointments) {
            listAppointments.add(appointment);
        }
    }
    
    /**
     * Setea todas las columnas de la tabla de citas
     */
    private void setColumnsAppointments(){
        colPacienteCita.setCellValueFactory((TableColumn.CellDataFeatures<Appointment, String> a) -> 
                new SimpleStringProperty(Patient.getPatientByID(a.getValue().getIdPatient()).nombreCompleto()));    
        colDoctor.setCellValueFactory((TableColumn.CellDataFeatures<Appointment, String> a) ->
                new SimpleStringProperty(Employee.getEmployee(a.getValue().getIdDoctor()).nombreCompleto()));        
        colFecha.setCellValueFactory(new PropertyValueFactory<>("date"));        
        colHora.setCellValueFactory(new PropertyValueFactory<>("hour"));
        
        colOpcionesCita.setCellFactory((TableColumn<Appointment, String> param) -> {
            TableCell<Appointment, String> tc = new TableCell(){
                @Override
                protected void updateItem(Object item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        this.setGraphic(null);
                        return;
                    }
                    
                    Button btnConsultar = new Button("Consultar");
                    btnConsultar.getStyleClass().add("btnConsultar");
                    btnConsultar.setFocusTraversable(false);
                    btnConsultar.setOnAction((ActionEvent event) -> {
                        Appointment cita = (Appointment) this.getTableView().getItems().get(this.getIndex());
                        consultarCita(cita);
                    });
                    
                    Button btnModificarCita = new Button("Modificar");
                    btnModificarCita.getStyleClass().add("btnEdit");
                    btnModificarCita.setFocusTraversable(false);
                    btnModificarCita.setOnAction((ActionEvent event) -> {
                        Appointment cita = (Appointment) this.getTableView().getItems().get(this.getIndex());
                        editAppointment(cita);
                    });
                    
                    Button btnEliminarCita = new Button("Eliminar");
                    btnEliminarCita.getStyleClass().add("btnDelete");
                    btnEliminarCita.setFocusTraversable(false);
                    btnEliminarCita.setOnAction((ActionEvent event) -> {
                        Appointment cita = (Appointment) this.getTableView().getItems().get(this.getIndex());
                        int result = Appointment.deleteAppointment(cita.getId());
                        if (result > 0) {
                            Tools.mensajeInfo("La cita se elimino correctamente.");
                            listAppointments.remove(cita);
                        }else{
                            Tools.mensajeInfo("La cita no se pudo eliminar.");
                        }
                    });
                    
                    HBox hbox = new HBox(3);
                    hbox.getChildren().addAll(btnConsultar, btnModificarCita, btnEliminarCita);        
                    this.setGraphic(hbox);
                }
            }; 
            return tc;
        });
    }
    

    /**
     * Setea los datos de la cita en la ventana de agendar citas
     * @param cita 
     */
    public void editAppointment(Appointment cita){
        patientCita = Patient.getPatientByID(cita.getIdPatient());
        doctorCita = Employee.getEmployee(cita.getIdDoctor());
        txtNomCompPaciente.setText(patientCita.nombreCompleto());
        txtDireccionCita.setText(patientCita.getDireccion());
        txtResponsableCita.setText(patientCita.getResponsable());
        txtNombreDoctor.setText(doctorCita.nombreCompleto());
        txtHoraCita.setText(cita.getHour());
        
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(cita.getDate(), formatter);
            dpFechaCita.setValue(localDate);
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        tabPane_Citas.getSelectionModel().select(subTab2_1);
        cbxDoctor.getItems().clear();
        cbBuscarPaciente.getItems().clear();
        cbxDoctor.getSelectionModel().clearSelection();
        cbBuscarPaciente.getSelectionModel().clearSelection();     
        idAppointmentEdit = patientCita.getId();
    }
    
    /**
     * Se consulta una cita pasando los datos ala pestaña de consultar
     * @param cita 
     */
    public void consultarCita(Appointment cita){
        Patient patientConsult = Patient.getPatientByID(cita.getIdPatient());
        Employee doctorConsult = Employee.getEmployee(cita.getIdDoctor());
        citaConsulta = cita;
        txtNomPacConsulta.setText(patientConsult.nombreCompleto());
        txtGeneroConsulta.setText(patientConsult.getGenero());
        txtFechaNacConsulta.setText(patientConsult.getFechaNacimiento());
        txtDireccionConsulta.setText(patientConsult.getDireccion());
        txtTelefonoConsulta.setText(patientConsult.getTelefono());
        txtCelularConsulta.setText(patientConsult.getCelular());
        txtResponsableConsulta.setText(patientConsult.getResponsable());
        txtDatosEspecialesConsulta.setText(patientConsult.getDatosEspeciales());
        txtDoctorConsulta.setText(doctorConsult.nombreCompleto());
        txtFechaConsulta.setText(cita.getDate());
        txtHoraConsultar.setText(cita.getHour());        
        tabPane_Citas.getSelectionModel().select(subTab2_3);     
    }

    /**
     * Al dar clic en el boton de guardar consulta
     * @param event 
     */
    @FXML
    private void btnGuardarConsulta_onclick(ActionEvent event) {
        if (!txtIndicacionesConsulta.getText().equals("")) {
            String indicaciones = txtIndicacionesConsulta.getText();
            int id_cita = citaConsulta.getId();
            Consult consulta = new Consult(id_cita, indicaciones);
            int result = Consult.saveConsult(consulta);
            if (result > 0) {
                Tools.mensajeInfo("La consulta se a guardado correctamente.");
            }else{
                Tools.mensajeInfo("La consulta no se a podido guardar.");
            }
        }
        
    }

    /**
     * Al dar click en el boton de guardar empleado
     * @param event 
     */
    @FXML
    private void btnGuardarEmployee_onclick(ActionEvent event) {
        if (!txtNombreEmpleado.getText().equals("") && !txtApellidosEmpleado.getText().equals("") && !txtDireccionEmpleado.getText().equals("")
                && !txtTelefonoEmpleado.getText().equals("") && !txtCelularEmpleado.getText().equals("") && !txtCorreoEmpleado.getText().equals("")
                && !txtUsuarioEmpleado.getText().equals("") && !pwClaveEmpleado.getText().equals("") && !pwClave2Empleado.getText().equals("")
                && cbEmpleado.getSelectionModel().getSelectedIndex() != 0) {
            
            String name = txtNombreEmpleado.getText();
            String lastName = txtApellidosEmpleado.getText();
            String direction = txtDireccionEmpleado.getText();
            String phone = txtTelefonoEmpleado.getText();
            String cellular = txtCelularEmpleado.getText();
            String mail = txtCorreoEmpleado.getText();
            String username = txtUsuarioEmpleado.getText();
            String password1 = pwClaveEmpleado.getText();
            String password2 = pwClave2Empleado.getText();
            String password;
            String type = cbEmpleado.getSelectionModel().getSelectedItem();
            
            if (password1.equals(password2)) {
                password = pwClaveEmpleado.getText();
                
                int resultado;
                if (empleadoEditando == null) {
                    Employee employee = new Employee(name, lastName, direction, phone, cellular, mail, username, password, type);
                    resultado = Employee.saveEmpleado(employee);
                }else{
                    Employee employee = new Employee(empleadoEditando.getId(), name, lastName, direction, phone, cellular, mail, username, password, type);
                    resultado = Employee.modifyEmpleado(employee);
                }                
                
                if (resultado > 0) {
                    Tools.mensajeInfo("El empleado se ha guardado correctamente");
                    limpiarEmpleados();
                }else{
                    Tools.mensajeInfo("El empleado no se ha podido guardar correctamente");
                }
            }else{
                Tools.mensajeInfo("Verifique que las contraseñas coincidan");              
            }      
            empleadoEditando = null;
        }else{
            Tools.mensajeInfo("Complete todos los campos");
        }
    }

    /**
     * Al seleccionar la tab de ver empleados
     * @param event 
     */
    @FXML
    private void subTab3_2_onselect(Event event) {
        if (subTab3_2.isSelected()) {
            getListDoctors();
            setColumnsEmployees();
            tbEmpleado.setItems(listDoctorsx);
        }
    }

    /**
     * Setea las columnas de la tabla empleados
     */
    private void setColumnsEmployees() {
        colEmpleado.setCellValueFactory((TableColumn.CellDataFeatures<Employee, String> employee) -> 
                new SimpleStringProperty(employee.getValue().nombreCompleto())); 
        colDireccionEmpleado.setCellValueFactory(new PropertyValueFactory<>("direction"));
        colTelefonoEmpleado.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colCelularEmpleado.setCellValueFactory(new PropertyValueFactory<>("cellular"));
        colCorreoEmpleado.setCellValueFactory(new PropertyValueFactory<>("mail"));
        colOcupacionEmpleado.setCellValueFactory(new PropertyValueFactory<>("type"));
        colOpcionesEmpleado.setCellFactory((TableColumn<Employee, String> param) -> {
            TableCell<Employee, String> tc = new TableCell(){
                @Override
                protected void updateItem(Object item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        this.setGraphic(null);
                        return;
                    }
                    
                    Button btnEditar = new Button();
                    btnEditar.getStyleClass().add("btnEdit");
                    btnEditar.setFocusTraversable(false);
                    btnEditar.setOnAction((ActionEvent event) -> {
                        Employee employee = (Employee) this.getTableView().getItems().get(this.getIndex());
                        editEmployee(employee);
                    });   
                    
                    Button btnDelete = new Button();
                    btnDelete.getStyleClass().add("btnDelete");
                    btnDelete.setFocusTraversable(false);
                    btnDelete.setOnAction((ActionEvent event) -> {
                        Employee employee = (Employee) this.getTableView().getItems().get(this.getIndex());
                        int result = Employee.deleteEmpleado(employee);
                        if (result > 0) {
                            Tools.mensajeInfo("El empleado se a eliminado correctamente");
                            listDoctorsx.remove(employee);
                        }
                    }); 
                    
                    HBox hbox = new HBox(3);
                    hbox.getChildren().addAll(btnEditar, btnDelete);        
                    this.setGraphic(hbox);
                }
            }; 
            return tc;
        });
    }
    
    /**
     * Pasa los datos a la pestaña de agregar empleado pero para EDITARLO
     * @param empleado 
     */
    private void editEmployee(Employee empleado){
        empleadoEditando = empleado;
        txtNombreEmpleado.setText(empleado.getName());
        txtApellidosEmpleado.setText(empleado.getLastName());
        txtDireccionEmpleado.setText(empleado.getDirection());
        txtTelefonoEmpleado.setText(empleado.getPhone());
        txtCelularEmpleado.setText(empleado.getCellular());
        txtCorreoEmpleado.setText(empleado.getMail());
        txtUsuarioEmpleado.setText(empleado.getUsername());
        cbEmpleado.getSelectionModel().select(empleado.getType());
        tabPane_Empleados.getSelectionModel().select(subTab3_1);
    }
    
    /**
     * Obtiene una lista de doctores
     */
    private void getListDoctors() {
        listDoctorsx.clear();
        List<Employee> employees = Employee.listEmployees();
        for (Employee employee : employees) {
            listDoctorsx.add(employee);
        }
    }
    
    /**
     * Limpia los campos de la pestaña de nuevo empleado
     */
    private void limpiarEmpleados(){
        txtNombreEmpleado.setText("");
        txtApellidosEmpleado.setText("");
        txtDireccionEmpleado.setText("");
        txtTelefonoEmpleado.setText("");
        txtCelularEmpleado.setText("");
        txtCorreoEmpleado.setText("");
        txtUsuarioEmpleado.setText("");
        pwClaveEmpleado.setText("");
        pwClave2Empleado.setText("");
        cbEmpleado.getSelectionModel().clearSelection();
        empleadoEditando = null;
    }
    
    /**
     * Pasar los datos del paciente a la pestaña de cita
     * @param patient 
     */
    private void agendarCitaAPaciente(Patient patient) {
        patientCita = patient;
        txtNomCompPaciente.setText(patient.nombreCompleto());
        txtDireccionCita.setText(patient.getDireccion());
        txtResponsableCita.setText(patient.getResponsable());
        tabPaneGeneral.getSelectionModel().select(tab2);
        tabPane_Citas.getSelectionModel().select(subTab2_1);
        tabPane_Citas.getSelectionModel().select(subTab2_1);
        cbxDoctor.getItems().clear();
        cbBuscarPaciente.getItems().clear();
        cbxDoctor.getSelectionModel().clearSelection();
        cbBuscarPaciente.getSelectionModel().clearSelection();   
        cbxDoctor.setItems(listDoctorsx);
    }
}
