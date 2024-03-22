/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

public class Chaqueta extends Ropa {

    private String tipoCierre;
    private boolean impermeable;
    private String materialExterior;

    // Constructor con todos los atributos
    public Chaqueta(String nombre, float precio, String descripcion,
            String marca, int talla, String color, String tipoCierre, boolean impermeable, String materialExterior) {
        super(nombre, precio, descripcion, marca, talla, color);
        this.tipoCierre = tipoCierre;
        this.impermeable = impermeable;
        this.materialExterior = materialExterior;
    }
        // Constructor con todos los atributos CODIGO PRODUCTO
    public Chaqueta(String nombre, float precio, String descripcion,String marca, String codigoProducto,
            int talla, String color, String tipoCierre, boolean impermeable, String materialExterior) {
        super(nombre, precio, descripcion, marca, codigoProducto, talla, color);
        this.tipoCierre = tipoCierre;
        this.impermeable = impermeable;
        this.materialExterior = materialExterior;
    }

    // Constructor sin descripción ni marca
    public Chaqueta(String nombre, float precio, int talla, String color, String tipoCierre, boolean impermeable,
            String materialExterior) {
        super(nombre, precio, "", "", talla, color);
        this.tipoCierre = tipoCierre;
        this.impermeable = impermeable;
        this.materialExterior = materialExterior;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    public boolean isImpermeable() {
        return impermeable;
    }

    public void setImpermeable(boolean impermeable) {
        this.impermeable = impermeable;
    }

    public String getMaterialExterior() {
        return materialExterior;
    }

    public void setMaterialExterior(String materialExterior) {
        this.materialExterior = materialExterior;
    }

    @Override
    public String mostrarDetalles() {
        String detalle = "Chaqueta : \n "
                + " \n Nombre :" + getNombre()
                + "\n Precio :" + getPrecio()
                + "\n Descripcion :" + getDescripcion()
                + "\n Marca :" + getMarca()
                + "\n Código Producto :" + getCodigoProducto()
                + "\n Talla :" + getTalla()
                + "\n Color :" + getColor()
                + "\n Impermeable :" + isImpermeable()
                + "\n Tipo de cierre :" + getTipoCierre()
                + "\n Material exterior: " + getMaterialExterior();
        return detalle;
    }

    @Override
    // el descuento es un num entre 0 y 100, representa %
    public float precioDto(int dto) {
        float total;
        total = getPrecio() * (1 - (dto / 100));
        return total;

    }
}
