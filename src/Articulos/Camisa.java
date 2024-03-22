/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

public class Camisa extends Ropa {

    private String tipoManga;
    private String tipoCierre;
    private boolean esEstampada;
    private String material;

    // Constructor con todos los atributos
    public Camisa(String nombre, float precio, String descripcion, String marca,
            int talla, String color, String tipoManga, String tipoCierre, boolean esEstampada, String material) {
        super(nombre, precio, descripcion, marca, talla, color);
        this.tipoManga = tipoManga;
        this.tipoCierre = tipoCierre;
        this.esEstampada = esEstampada;
        this.material = material;
    }
        // Constructor con todos los atributos CODIGO PRODUCTO
    public Camisa(String nombre, float precio, String descripcion, String marca,String codigoProducto,
            int talla, String color, String tipoManga, String tipoCierre, boolean esEstampada, String material) {
        super(nombre, precio, descripcion, marca, codigoProducto, talla, color);
        this.tipoManga = tipoManga;
        this.tipoCierre = tipoCierre;
        this.esEstampada = esEstampada;
        this.material = material;
    }

    // Constructor sin descripción ni marca
    public Camisa(String nombre, float precio, int talla, String color, String tipoManga, String tipoCierre,
            boolean esEstampada, String material) {
        super(nombre, precio, "", "", talla, color);
        this.tipoManga = tipoManga;
        this.tipoCierre = tipoCierre;
        this.esEstampada = esEstampada;
        this.material = material;
    }

    // Constructor con información mínima
    public Camisa(String nombre, float precio, int talla, String color) {
        super(nombre, precio, "", "", talla, color);
        // Se pueden asignar valores por defecto o dejar algunos atributos sin inicializar
    }

    public String getTipoManga() {
        return tipoManga;
    }

    public void setTipoManga(String tipoManga) {
        this.tipoManga = tipoManga;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    public boolean isEsEstampada() {
        return esEstampada;
    }

    public void setEsEstampada(boolean esEstampada) {
        this.esEstampada = esEstampada;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String mostrarDetalles() {
        String detalle = "Camisa :  "
                + " \n Nombre :" + getNombre()
                + "\n Precio :" + getPrecio()
                + "\n Descripcion :" + getDescripcion()
                + "\n Marca :" + getMarca()
                + "\n Código Producto :" + getCodigoProducto()
                + "\n Talla :" + getTalla()
                + "\n Color :" + getColor()
                + "\n Tipo de manga :" + tipoManga
                + "\n Tipo de cierre :" + tipoCierre
                + "\n Estampada :" + esEstampada
                + "\n Material :" + material;
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
