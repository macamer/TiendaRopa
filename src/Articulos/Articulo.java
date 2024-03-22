/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

public abstract class Articulo implements java.io.Serializable{

    private static int totalArticulos = 0;

    private String nombre;
    private float precio;
    private String descripcion;
    private String marca;
    private String codigoProducto;

    // Constructor principal
    public Articulo(String nombre, float precio, String descripcion, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
        this.codigoProducto = "AR_" + getTotalArticulos();
        totalArticulos++;
    }
    
      // Constructor principal con CODIGO PRODUCTO
    public Articulo(String nombre, float precio, String descripcion, String marca, String codigoProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.marca = marca;
        this.codigoProducto=codigoProducto;
        totalArticulos++;
    }

    // Constructor sin descripción
    public Articulo(String nombre, float precio, String marca) {
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.codigoProducto = "AR_" + getTotalArticulos();
        totalArticulos++;
    }

    // Constructor sin descripción ni marca
    public Articulo(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigoProducto = "AR_" + getTotalArticulos();
        totalArticulos++;
    }

    // Métodos abstractos que deben ser implementados por las subclases
    public abstract String mostrarDetalles();

    public abstract float precioDto(int dto);

    // Getters y setters
    public static int getTotalArticulos() {
        return totalArticulos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public static int getTotalArticulosVendidos() {
        return totalArticulos;
    }

}
