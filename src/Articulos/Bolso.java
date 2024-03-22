/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

public class Bolso extends Accesorio {

    private int capacidad;
    private String tipoCierre;

    // Constructor con todos los atributos
    public Bolso(String nombre, float precio, String descripcion, String marca,
            String tipo, String material, String estilo, boolean esPersonalizado, int capacidad, String tipoCierre) {
        super(nombre, precio, descripcion, marca, tipo, material, estilo, esPersonalizado);
        this.capacidad = capacidad;
        this.tipoCierre = tipoCierre;
    }

    // Constructor con todos los atributos CODIGO PRODUCTO
    public Bolso(String nombre, float precio, String descripcion, String marca, String codigoProducto,
            String tipo, String material, String estilo, boolean esPersonalizado, int capacidad, String tipoCierre) {
        super(nombre, precio, descripcion, marca, codigoProducto, tipo, material, estilo, esPersonalizado);
        this.capacidad = capacidad;
        this.tipoCierre = tipoCierre;
    }

    // Constructor con información básica
    public Bolso(String nombre, float precio, String tipo, int capacidad) {
        super(nombre, precio, "", "", tipo, "", "", false);
        this.capacidad = capacidad;
        // Se pueden asignar valores por defecto o dejar algunos atributos sin inicializar
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    @Override
    public String mostrarDetalles() {
        return "Bolso:\n"
                + "Código de Producto: " + getCodigoProducto() + "\n"
                + "Nombre: " + getNombre() + "\n"
                + "Precio: " + getPrecio() + "\n"
                + "Descripción: " + getDescripcion() + "\n"
                + "Marca: " + getMarca() + "\n"
                + "Tipo: " + getTipo() + "\n"
                + "Material: " + getMaterial() + "\n"
                + "Estilo: " + getEstilo() + "\n"
                + "Es Personalizado: " + isEsPersonalizado() + "\n"
                + "Capacidad: " + capacidad + "\n"
                + "Tipo de Cierre: " + tipoCierre;
    }

    @Override
    // el descuento es un num entre 0 y 100, representa %
    public float precioDto(int dto) {
        float total;
        total = getPrecio() * (1 - (dto / 100));
        return total;

    }
}
