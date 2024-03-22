/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

public abstract class Ropa extends Articulo {

    private int talla;
    private String color;

    public Ropa(String nombre, float precio, String descripcion, String marca, int talla, String color) {
        super(nombre, precio, descripcion, marca);
        this.talla = talla;
        this.color = color;
    }

    public Ropa(String nombre, float precio, String descripcion, String marca, String codigoProducto, int talla, String color) {
        super(nombre, precio, descripcion, marca, codigoProducto);
        this.talla = talla;
        this.color = color;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
