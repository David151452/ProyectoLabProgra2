/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author lucia
 */
public class Cliente {

    //atributos cliente
    private int id;
    private String nombreCliente;
    private String passwordCliente;

    //constructor vacio
    public Cliente() {
    }

    //constructo lleno
    public Cliente(int id, String nombreCliente, String passwordCliente) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.passwordCliente = passwordCliente;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getPasswordCliente() {
        return passwordCliente;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setPasswordCliente(String passwordCliente) {
        this.passwordCliente = passwordCliente;
    }

    //to string
    @Override
    public String toString() {
        return "Id=" + id + " Nombre=" + nombreCliente + " Password=" + passwordCliente;
    }

}
