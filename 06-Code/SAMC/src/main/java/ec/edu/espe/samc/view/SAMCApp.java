
package ec.edu.espe.samc.view;

import com.mongodb.client.MongoDatabase;
import ec.edu.espe.samc.controller.MongoDBManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila Bohorquez
 */
public class SAMCApp {

    private static void initializeDatabaseConnection() {
        MongoDBManager mongoDBConnection = MongoDBManager.getInstance();
        MongoDatabase database = mongoDBConnection.getDatabase();

        if (database == null) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar a MongoDB", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            System.out.println("Conexión a la base de datos MongoDB inicializada correctamente.");
        }
    }

    public static void main(String[] args) {
 
        initializeDatabaseConnection();

        new FrmLogin().setVisible(true);
    }
}
