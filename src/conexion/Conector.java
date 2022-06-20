/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucia
 */
public class Conector {

    public static Connection iniciarConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String serv = "jdbc:mysql://localhost:3306/proyecto";
            String user = "root";
            String pass = "";
            con = DriverManager.getConnection(serv, user, pass);
        } catch (ClassNotFoundException e) {
            System.out.println("Error BD");
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } catch (Exception e) {
            System.out.println("Error de capa 8");
        }
        return con;
    }

}
