/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pedidos;

import Usuarios.Cliente;
import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

    private int numeroPedido;
    private LocalDate fechaPedido;
    private Cliente cliente;
    private ArrayList<LineaPedido> items;
    private String estado;

    public Pedido(int numeroPedido, LocalDate fechaPedido, Cliente cliente,String estado) {
        this.numeroPedido = numeroPedido;
        this.fechaPedido = fechaPedido;
        this.cliente = cliente;
        this.estado = estado;
        items = new ArrayList<>();
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float calcularTotal() {
        float total = 0;
        for (LineaPedido item : items) {
            total += item.getSubtotal();
        }
        return total;
    }
    
    // gestión de lineas de depido
    // Anadir linea a la lista
    public boolean anadirLinea(LineaPedido l) {
        boolean insertado = false;
        if (l != null) {
            insertado = items.add(l);
        }
        return insertado;

    }

    // borrar linea de la lista
    // a partir de su posición
    public boolean borrarLinea(int i) {
        boolean insertado = false;
        LineaPedido l;
        if (i>=0 && i<items.size() && items.get(i) != null) {
            l = items.get(i);
            insertado = items.remove(l);
        }
        return insertado;
    }

    // mostrar todos los artículos de la lista
    public void mostrarPedido() {
        System.out.println("Listado del pedido.");
        System.out.println("Número pedido : "+getNumeroPedido());
        System.out.println("Fecha : "+getFechaPedido());
        System.out.println(cliente.info());
        System.out.println("\nLineas del pedido:");
        for (LineaPedido l : items) {
            System.out.println(l.mostrarPedido());
            System.out.println("");
        }
        System.out.println();
    }

    // devuelve la cantidad de lienas en la lista
    public int numLineas() {
        int num = 0;
        num = items.size();
        return num;
    }

    // Comprobar si la lista está vacía
    public boolean vaciaLista() {
        boolean vacia = false;
        if (items.isEmpty()) {
            vacia = true;
        }
        return vacia;
    }

    // Vaciar la lista
    public boolean vaciarLista() {
        boolean vacia = false;
        if (items != null) {
            vacia = true;
            items.clear();
        }
        return vacia;
    }

    // devuelve la linea de la posición i
    // null si no es posible
    public LineaPedido getLinea(int i) {
        LineaPedido a = null;
        if (i >= 0 && i <= numLineas()- 1) {
            a = items.get(i);
        }
        return a;
    }
    
}