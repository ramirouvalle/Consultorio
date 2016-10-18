package consultorio;

import javax.swing.JOptionPane;

/**
 *
 * @author RAP4
 */
public class Tools {
    public static void mensajeError(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje,"Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mensajeInfo(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static boolean mensajeConfirmacion(String mensaje){
        int option = JOptionPane.showConfirmDialog(null, mensaje, "Confirmación", JOptionPane.YES_NO_OPTION);
        if (option == 0) {
            return true;
        }else{
            return false;
        }
    }
}
