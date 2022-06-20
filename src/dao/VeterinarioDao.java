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
import modelo.Veterinario;

/**
 *
 * @author lucia
 */
public class VeterinarioDao {
    //Atributos que establecen conexión y ejecución de query sql

    private static Connection con = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public VeterinarioDao() {
    }

    public boolean insertarDatos(String nombre, String ciudad, int precio, String correo, String telefono, String especialidad) {
        boolean resp = false; //Resultado de la transaccion
        try {
            con = Conector.iniciarConexion(); //inicio la conexion con la BD
            statement = con.createStatement(); //Abro la query
            String sql = "INSERT INTO veterinario VALUES (null, '" + nombre + "', '" + ciudad + "', '" + precio + "', '" + correo + "', '" + telefono + "', '" + especialidad + "')"; //Escribo la consulta en lenguaje SQL
            statement.executeUpdate(sql); //Ejecutando la query
            resp = true; //entrego el valor verdadero cuando se ejecuta correctamente
            statement.close(); //cierro la conexion
        } catch (SQLException e) {
            System.out.println("Error SQL"); //en caso de error de la query
        }
        return resp; //entrego true o false dependiendo del resultado
    }

    public boolean eliminarDatos(String nombreVeterinarioActual) {
        boolean resp = false;
        try {
            con = Conector.iniciarConexion();//inicio la conexion con la BD
            statement = con.createStatement();//Abro la query
            String sql = "DELETE FROM veterinario WHERE nombre='" + nombreVeterinarioActual + "'"; //Query para elminar
            if (statement.executeUpdate(sql) == 1) { //if utilizado para validar la eliminacion de un veterinario
                resp = true;
            }
            statement.close();//cierro la conexion
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return resp;//entrego true o false dependiendo del resultado
    }

    public boolean actualizarDatos(String nombre, String ciudad, int precio, String correo, String telefono, String especialidad, String nombreVeterinarioActual) {
        boolean resp = false;
        try {
            con = Conector.iniciarConexion();//inicio la conexion con la BD
            statement = con.createStatement();//Abro la query
            String sql = "UPDATE veterinario "
                    + " SET nombre = '" + nombre + "', ciudad = '" + ciudad + "', precio='" + precio + "', correo = '" + correo + "', telefono='" + telefono + "', especialidad = '" + especialidad
                    + "' WHERE nombre='" + nombreVeterinarioActual + "'";//Query para modificar
            if (statement.executeUpdate(sql) == 1) { //if utilizado para validar la actualizacion de un veterinario
                resp = true;
            }
            statement.close();//cierro la conexion
        } catch (SQLException e) {
            System.out.println("Error SQL");//en caso de error de la query
        }
        return resp;//entrego true o false dependiendo del resultado
    }

    public ArrayList<Veterinario> listarDatos() {
        ArrayList<Veterinario> veterinarios = new ArrayList<>(); //Creo un ArrayList para almacenar los veterinarios
        try {
            con = Conector.iniciarConexion();//inicio la conexion con la BD
            statement = con.createStatement();//Abro la query
            String sql = "SELECT * FROM veterinario"; //Query para obtener toda la informacion de la tabla
            resultSet = statement.executeQuery(sql); //Se obtienen los datos de la BD
            while (resultSet.next()) { //Recorriendo los datos obtenidos y almacenados en resultSet
                Veterinario veterinario = new Veterinario(); //Creo el veterinario
                veterinario.setId(resultSet.getInt("id"));//asigno el id
                veterinario.setNombre(resultSet.getString("nombre")); //asigno el nombre
                veterinario.setCiudad(resultSet.getString("ciudad")); //asigno el ciudad
                veterinario.setPrecio(resultSet.getInt("precio")); //asigno el precio
                veterinario.setCorreo(resultSet.getString("correo")); //asigno el correo
                veterinario.setTelefono(resultSet.getString("telefono")); //asigno el telefono
                veterinario.setEspecialidad(resultSet.getString("especialidad")); //asigno el especialidad
                veterinarios.add(veterinario); //Agrego el producto al ArrayList de tipo Veterinario
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error SQL");
        }
        return veterinarios; //Entrego una lista completa con la informacion de los veterinarios
    }
}
