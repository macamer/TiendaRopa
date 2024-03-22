/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pedidos;

import Articulos.Articulo;

public class LineaPedido {

    private int cantidad;
    private Articulo articulo;

    public LineaPedido(int cantidad, Articulo articulo) {
        this.cantidad = cantidad;
        this.articulo = articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public double getSubtotal() {
        return cantidad * articulo.getPrecio();
    }
    
    public String mostrarPedido(){
        return "\nArtículo: \nCantidad:" + cantidad + "\n"+articulo.mostrarDetalles();
    }
    @Override
    public String toString() {
        return "LineaPedido{" + "cantidad=" + cantidad + ", articulo=" + articulo.mostrarDetalles() + '}';
    }
}
