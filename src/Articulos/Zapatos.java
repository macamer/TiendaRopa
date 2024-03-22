/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

public class Zapatos extends Accesorio {

    private int tallaZapatos;
    private String tipoSuela;

    // Constructor con todos los atributos
    public Zapatos(String nombre, float precio, String descripcion, String marca,
            String tipo, String material, String estilo, boolean esPersonalizado, int tallaZapatos, String tipoSuela) {
        super(nombre, precio, descripcion, marca, tipo, material,
                estilo, esPersonalizado);
        this.tallaZapatos = tallaZapatos;
        this.tipoSuela = tipoSuela;
    }

    // Constructor con todos los atributos
    public Zapatos(String nombre, float precio, String descripcion, String marca, String codigoProducto,
            String tipo, String material, String estilo, boolean esPersonalizado, int tallaZapatos, String tipoSuela) {
        super(nombre, precio, descripcion, marca, codigoProducto, tipo, material, estilo, esPersonalizado);
        this.tallaZapatos = tallaZapatos;
        this.tipoSuela = tipoSuela;
    }

    // Constructor con información básica
    public Zapatos(String nombre, float precio, String tipo, int tallaZapatos) {
        super(nombre, precio, "", "", tipo, "", "", false);
        this.tallaZapatos = tallaZapatos;
        // Se pueden asignar valores por defecto o dejar algunos atributos sin inicializar
    }

    // Constructor con información mínima
    public Zapatos(String nombre, float precio, int tallaZapatos) {
        super(nombre, precio, "", "", "", "", "", false);
        this.tallaZapatos = tallaZapatos;
        // Se pueden asignar valores por defecto o dejar algunos atributos sin inicializar
    }

    public int getTallaZapatos() {
        return tallaZapatos;
    }

    public void setTallaZapatos(int tallaZapatos) {
        this.tallaZapatos = tallaZapatos;
    }

    public String getTipoSuela() {
        return tipoSuela;
    }

    public void setTipoSuela(String tipoSuela) {
        this.tipoSuela = tipoSuela;
    }

    @Override
    public String mostrarDetalles() {
        return "Zapatos:\n"
                + "Nombre: " + getNombre() + "\n"
                + "Precio: " + getPrecio() + "\n"
                + "Descripción: " + getDescripcion() + "\n"
                + "Marca: " + getMarca() + "\n"
                + "Código de Producto: " + getCodigoProducto() + "\n"
                + "Tipo: " + getTipo() + "\n"
                + "Material: " + getMaterial() + "\n"
                + "Estilo: " + getEstilo() + "\n"
                + "Es Personalizado: " + isEsPersonalizado() + "\n"
                + "Talla de Zapatos: " + tallaZapatos + "\n"
                + "Tipo de Suela: " + tipoSuela;
    }

    @Override
    // el descuento es un num entre 0 y 100, representa %
    public float precioDto(int dto) {
        float total;
        total = getPrecio() * (1 - (dto / 100));
        return total;

    }
}
