/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author lucia
 */
public class ClienteDao {

    //Atributos que establecen conexión y ejecución de query sql
    private static Connection con = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public ClienteDao() {
    }

    public boolean insertarDatos(String nombreCliente, String passwordCliente) {
        boolean resp = false; //Resultado de la transaccion
        try {
            con = Conector.iniciarConexion(); //inicio la conexion con la BD
            statement = con.createStatement(); //Abro la query
            String sql = "INSERT INTO cliente VALUES (null, '" + nombreCliente + "', '" + passwordCliente + "', ')"; //Escribo la consulta en lenguaje SQL
            statement.executeUpdate(sql); //Ejecutando la query
            resp = true; //entrego el valor verdadero cuando se ejecuta correctamente
            statement.close(); //cierro la conexion
        } catch (SQLException e) {
            System.out.println("Error SQL"); //en caso de error de la query
        }
        return resp; //entrego true o false dependiendo del resultado
    }

    public ArrayList<Cliente> listarDatos() {
        ArrayList<Cliente> usuarios = new ArrayList<>(); //Creo un ArrayList para almacenar los clientes
        try {
            con = Conector.iniciarConexion();//inicio la conexion con la BD
            statement = con.createStatement();//Abro la query
            String sql = "SELECT * FROM cliente"; //Query para obtener toda la informacion de la tabla
            resultSet = statement.executeQuery(sql); //Se obtienen los datos de la BD
            while (resultSet.next()) { //Recorriendo los datos obtenidos y almacenados en resultSet
                Cliente usuario = new Cliente(); //Creo el veterinario
                usuario.setId(resultSet.getInt("id"));//asigno el id
                usuario.setNombreCliente(resultSet.getString("nombreCliente")); //asigno el nombre
                usuario.setPasswordCliente(resultSet.getString("passwordCliente")); //asigno el ciudad
                usuarios.add(usuario); //Agrego el producto al ArrayList de tipo Veterinario
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return usuarios; //Entrego una lista completa con la informacion de los veterinarios
    }

}
