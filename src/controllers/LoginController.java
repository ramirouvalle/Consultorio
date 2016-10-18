package controllers;

import consultorio.Tools;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import models.Employee;

/**
 *
 * @author RAP4
 */
public class LoginController implements Initializable {
    private Label label;
    @FXML
    private AnchorPane pnlBg;
    @FXML
    private TextField txtUser;
    @FXML
    private PasswordField pwPassword;
    @FXML
    private Button btnAccept;
    @FXML
    private Button btnCancel;
    @FXML
    private GridPane gridPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void btnAccept_onClick(ActionEvent event) throws IOException {
        String username = txtUser.getText();
        String password = pwPassword.getText();
        
        if (!username.equals("") && !password.equals("")) {
            Employee employee = new Employee(username, password);
            Employee e1 = employee.loginEmployee(employee);
            if (e1 != null) {
                //Cerrar el login
                Stage stageLogin = (Stage) btnAccept.getScene().getWindow();
                stageLogin.close();
                
                //Crear la ventana principal
                Parent root = FXMLLoader.load(getClass().getResource("/views/Main.fxml"),
                        ResourceBundle.getBundle("resources/languages/main_es"));
                
                Stage stageMain = new Stage();
                stageMain.initModality(Modality.APPLICATION_MODAL);
                stageMain.setTitle("Medical Center Express");
                stageMain.setScene(new Scene(root)); 
                stageMain.show();

                /** Este codigo hace una vista nueva pero en la misma ventana 
                Parent root = FXMLLoader.load(getClass().getResource("/views/Main.fxml"),
                ResourceBundle.getBundle("resources/languages/login_es"));
                ((Node) event.getSource()).getScene().setRoot(root);
                 **/
            }else{
                Tools.mensajeInfo("Usuario o contraseña incorrecta. Intente de nuevo.");
            }
        }else{
            Tools.mensajeInfo("Ingrese el usuario y la contraseña.");
        }
    }

    @FXML
    private void btnCancel_onClick(ActionEvent event) {
        txtUser.setText("");
        pwPassword.setText("");
        txtUser.requestFocus();
    }
}
