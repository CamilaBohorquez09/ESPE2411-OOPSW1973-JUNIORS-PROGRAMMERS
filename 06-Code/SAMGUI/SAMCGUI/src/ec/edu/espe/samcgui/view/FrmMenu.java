
package ec.edu.espe.samcgui.view;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import ec.edu.espe.samcgui.controller.MongoDBManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.bson.Document;

public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    private Order orden;
    
    public FrmMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        loadDataMongoDB();
        loadNamesInComboBox();
        orden = new Order("Nombre del Cliente", "Cédula del Cliente", "Correo del Cliente", "Teléfono del Cliente", "Dirección del Cliente");
    }
    
    private void loadNamesInComboBox() {
        MongoClient client = MongoDBManager.getMongoClient();
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
    
    private void loadDataMongoDB() {
        MongoClient client = MongoDBManager.getMongoClient();
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
            Number price = doc.get("Precio", Number.class);
            row[3] = price != null ? price.doubleValue() : null;
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
        String dishName = (String) jComboBox1.getSelectedItem();
        int quantity = (int) jSpinner1.getValue();

        if (dishName != null && quantity > 0) {
            MongoDatabase database = MongoDBManager.getDatabase();

            if (database == null) {
                JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            MongoCollection<Document> foodCollection = database.getCollection("comida");
            Document food = foodCollection.find(new Document("Nombre", dishName)).first();

            if (food != null) {
                int currentInventory = food.getInteger("Inventario");

                if (currentInventory >= quantity) {
                    int newInventory = currentInventory - quantity;
                    foodCollection.updateOne(new Document("Nombre", dishName), new Document("$set", new Document("Inventario", newInventory)));

                    boolean found = false;
                    for (Dish dish : orden.getDishes()) {
                        if (dish.getName().equals(dishName)) {
                            dish.setQuantity(dish.getQuantity() + quantity);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        Dish dish = new Dish(dishName, quantity);
                        orden.addDish(dish);
                    }

                    for (Dish dish : orden.getDishes()) {
                        System.out.println("Platillo: " + dish.getName() + ", Cantidad: " + dish.getQuantity());
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
        String customerName = jTextField3.getText();
        String customerId = jTextField4.getText();
        String customerEmail = jTextField5.getText();
        String customerContactNumber = jTextField6.getText();
        String customerAddress = jTextField7.getText();
   
        if (customerName.isEmpty() || customerId.isEmpty() || customerEmail.isEmpty() || customerContactNumber.isEmpty() || customerAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerName.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
            JOptionPane.showMessageDialog(this, "El nombre solo puede contener letras y espacios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerId.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "La cédula debe tener 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerEmail.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            JOptionPane.showMessageDialog(this, "El correo electrónico no es válido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!customerContactNumber.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (customerName.isEmpty() || customerId.isEmpty() || customerEmail.isEmpty() || customerContactNumber.isEmpty() || customerAddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos del cliente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        orden.setCustomerName(customerName);
        orden.setCustomerId(customerId);
        orden.setCustomerEmail(customerEmail);
        orden.setCustomerContactNumber(customerContactNumber);
        orden.setCustomerAddress(customerAddress);

        MongoClient mongoClient = MongoDBManager.getMongoClient();
        if (mongoClient == null) {
            JOptionPane.showMessageDialog(this, "No se pudo conectar a MongoDB", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        MongoDatabase database = mongoClient.getDatabase("bd_restaurante");
        MongoCollection<Document> collection = database.getCollection("ordenes");

        Document ordenDoc = new Document();
        ordenDoc.put("nombreCliente", orden.getCustomerName());
        ordenDoc.put("cedulaCliente", orden.getCustomerId());
        ordenDoc.put("correoCliente", orden.getCustomerEmail());
        ordenDoc.put("telefonoCliente", orden.getCustomerContactNumber());
        ordenDoc.put("direccionCliente", orden.getCustomerAddress());

        List<Dish> platillos = orden.getDishes();
        List<Document> platillosDocs = new ArrayList<>();
        for (Dish platillo : platillos) {
            Document platilloDoc = new Document();
            platilloDoc.put("nombre", platillo.getName());
            platilloDoc.put("cantidad", platillo.getQuantity());
            platillosDocs.add(platilloDoc);
        }
        ordenDoc.put("platillos", platillosDocs);

        System.out.println("Guardando orden: " + ordenDoc.toJson());

        try {
            collection.insertOne(ordenDoc);
            JOptionPane.showMessageDialog(this, "Orden guardada exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar la orden: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        orden = new Order("", "", "", "", "");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
    
        new FrmMethodOfPayment(customerId).setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new FrmMainMenu().setVisible(true);
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
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
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
