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
public class Veterinario {

    //atributos de veterinario
    private int id;
    private String nombre;
    private String ciudad;
    private int precio;
    private String correo;
    private String telefono;
    private String especialidad;

    //constructor vacio
    public Veterinario() {
    }

    //constructor lleno
    public Veterinario(int id, String nombre, String ciudad, int precio, String correo, String telefono, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.precio = precio;
        this.correo = correo;
        this.telefono = telefono;
        this.especialidad = especialidad;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getPrecio() {
        return precio;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //to string
    @Override
    public String toString() {
        return "Id=" + id + " Nombre=" + nombre + " Ciudad=" + ciudad + "Precio=" + precio + " Correo=" + correo + " Telefono=" + telefono + " Especialidad=" + especialidad;
    }

}
