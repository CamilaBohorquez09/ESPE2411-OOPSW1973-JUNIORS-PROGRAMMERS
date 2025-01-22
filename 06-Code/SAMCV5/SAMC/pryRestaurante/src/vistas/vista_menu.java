/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import controladores.ConexionMongo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;
/**
 *
 * @author antho
 */
public class vista_menu extends javax.swing.JFrame {

    /**
     * Creates new form vista_menu
     */
    private Orden orden;
    
    public vista_menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarDatosMongoDB();
        cargarNombresEnComboBox();
        orden = new Orden("Nombre del Cliente", "Cédula del Cliente", "Correo del Cliente", "Teléfono del Cliente", "Dirección del Cliente");
    }
    
    private void cargarNombresEnComboBox() {
        MongoClient client = ConexionMongo.getMongoClient();
        if (client == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a MongoDB", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MongoDatabase database = client.getDatabase("bd_restaurante");
        MongoCollection<Document> collection = database.getCollection("comida");
        FindIterable<Document> documents = collection.find();
        jComboBox1.removeAllItems();
        for (Document doc : documents) {
            String nombre = doc.getString("Nombre");
            if (nombre != null) {
                jComboBox1.addItem(nombre);
            }
        }
    }
    
    private void cargarDatosMongoDB() {
        MongoClient client = ConexionMongo.getMongoClient();
        if (client == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a MongoDB", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MongoDatabase database = client.getDatabase("bd_restaurante");
        MongoCollection<Document> collection = database.getCollection("comida");
        FindIterable<Document> documents = collection.find();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Descripción");
        model.addColumn("Precio");
        model.addColumn("Inventario");
        for (Document doc : documents) {
            Object[] row = new Object[5];
            row[0] = doc.getInteger("ID");
            row[1] = doc.getString("Nombre");
            row[2] = doc.getString("Descripcion");
            Number precio = doc.get("Precio", Number.class);
            row[3] = precio != null ? precio.doubleValue() : null;
            row[4] = doc.getInteger("Inventario");
            model.addRow(row);
        }
        jTable1.setModel(model);
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setBackground(new java.awt.Color(0, 102, 102));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 51, 396, 363));

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Ordenar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 385, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Platillo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 6, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 60, -1, -1));

        jComboBox1.setBackground(new java.awt.Color(0, 51, 51));
        jComboBox1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 28, 244, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 115, -1, -1));

        jTextField3.setBackground(new java.awt.Color(0, 102, 102));
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 137, 244, -1));
        getContentPane().add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 82, 100, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cedula");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 169, -1, -1));

        jTextField4.setBackground(new java.awt.Color(0, 102, 102));
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 191, 244, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Correo Electronico");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 223, -1, -1));

        jTextField5.setBackground(new java.awt.Color(0, 102, 102));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 245, 244, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Teléfono");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 277, -1, -1));

        jTextField6.setBackground(new java.awt.Color(0, 102, 102));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 299, 244, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Añadir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 82, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Direccion");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 331, -1, -1));

        jTextField7.setBackground(new java.awt.Color(0, 102, 102));
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 353, 244, -1));

        jButton3.setBackground(new java.awt.Color(0, 51, 51));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Atras");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 12, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nombrePlatillo = (String) jComboBox1.getSelectedItem();
        int cantidad = (int) jSpinner1.getValue();

        if (nombrePlatillo != null && cantidad > 0) {
            MongoDatabase database = ConexionMongo.getDatabase();

            if (database == null) {
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            MongoCollection<Document> comidaCollection = database.getCollection("comida");
            Document comida = comidaCollection.find(new Document("Nombre", nombrePlatillo)).first();

            if (comida != null) {
                int inventarioActual = comida.getInteger("Inventario");

                if (inventarioActual >= cantidad) {
                    // Restar la cantidad del inventario y actualizar la base de datos
                    int nuevoInventario = inventarioActual - cantidad;
                    comidaCollection.updateOne(new Document("Nombre", nombrePlatillo), new Document("$set", new Document("Inventario", nuevoInventario)));

                    // Verificar si el platillo ya existe en la lista de platillos
                    boolean found = false;
                    for (Platillo platillo : orden.getPlatillos()) {
                        if (platillo.getNombre().equals(nombrePlatillo)) {
                            platillo.setCantidad(platillo.getCantidad() + cantidad); // Incrementar la cantidad si ya existe
                            found = true;
                            break;
                        }
                    }

                    // Si no se encontró, añadir un nuevo platillo
                    if (!found) {
                        Platillo platillo = new Platillo(nombrePlatillo, cantidad);
                        orden.agregarPlatillo(platillo);
                    }

                    // Imprimir los platillos para depuración
                    for (Platillo platillo : orden.getPlatillos()) {
                        System.out.println("Platillo: " + platillo.getNombre() + ", Cantidad: " + platillo.getCantidad());
                    }

                    JOptionPane.showMessageDialog(this, "Platillo añadido a la orden", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "No hay suficiente inventario para el platillo seleccionado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Platillo no encontrado en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un platillo y una cantidad válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreCliente = jTextField3.getText();
        String cedulaCliente = jTextField4.getText();
        String correoCliente = jTextField5.getText();
        String telefonoCliente = jTextField6.getText();
        String direccionCliente = jTextField7.getText();
        
        // Validar campos vacíos
        if (nombreCliente.isEmpty() || cedulaCliente.isEmpty() || correoCliente.isEmpty() || telefonoCliente.isEmpty() || direccionCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que el nombre solo contenga letras
        if (!nombreCliente.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras y espacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar cédula con 10 dígitos
        if (!cedulaCliente.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "La cédula debe tener 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar formato de correo electrónico
        if (!correoCliente.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            JOptionPane.showMessageDialog(this, "El correo electrónico no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar teléfono con 10 dígitos
        if (!telefonoCliente.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (nombreCliente.isEmpty() || cedulaCliente.isEmpty() || correoCliente.isEmpty() || telefonoCliente.isEmpty() || direccionCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        orden.setNombreCliente(nombreCliente);
        orden.setCedulaCliente(cedulaCliente);
        orden.setCorreoCliente(correoCliente);
        orden.setTelefonoCliente(telefonoCliente);
        orden.setDireccionCliente(direccionCliente);

        // Conectar a MongoDB usando tu clase ConexionMongo
        MongoClient mongoClient = ConexionMongo.getMongoClient();
        if (mongoClient == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a MongoDB", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MongoDatabase database = mongoClient.getDatabase("bd_restaurante");
        MongoCollection<Document> collection = database.getCollection("ordenes");

        Document ordenDoc = new Document();
        ordenDoc.put("nombreCliente", orden.getNombreCliente());
        ordenDoc.put("cedulaCliente", orden.getCedulaCliente());
        ordenDoc.put("correoCliente", orden.getCorreoCliente());
        ordenDoc.put("telefonoCliente", orden.getTelefonoCliente());
        ordenDoc.put("direccionCliente", orden.getDireccionCliente());

        // Crear una lista de documentos para los platillos
        List<Platillo> platillos = orden.getPlatillos();
        List<Document> platillosDocs = new ArrayList<>();
        for (Platillo platillo : platillos) {
            Document platilloDoc = new Document();
            platilloDoc.put("nombre", platillo.getNombre());
            platilloDoc.put("cantidad", platillo.getCantidad());
            platillosDocs.add(platilloDoc);
        }
        ordenDoc.put("platillos", platillosDocs);

        // Imprimir documento de la orden en formato JSON
        System.out.println("Guardando orden: " + ordenDoc.toJson());

        try {
            collection.insertOne(ordenDoc);
            JOptionPane.showMessageDialog(this, "Orden guardada exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Limpiar la orden y los campos de entrada
        orden = new Orden("", "", "", "", "");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        
        // Enviar la cédula a la siguiente pantalla
        new vista_metodopago(cedulaCliente).setVisible(true);  // Pasar la cédula
        dispose();  // Cerrar la ventana actual
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new vista_principal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vista_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vista_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vista_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vista_menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vista_menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
