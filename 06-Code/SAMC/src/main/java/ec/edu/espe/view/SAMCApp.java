/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espe.view;

import espe.edu.ec.model.Customer;
import espe.edu.ec.model.MenuItem;
import espe.edu.ec.model.Order;
import espe.edu.ec.utils.AdminPermissions;
import espe.edu.ec.utils.ManageFileJson;
import espe.edu.ec.utils.Validations;
import java.util.Scanner;

/**
 *
 * @author Camila Bohorquez
 */
public class SAMCApp {

    public static void main(String[] args) {
        new FrmMainMenu().setVisible(true);
    }
}
