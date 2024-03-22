/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Articulos;

public class Pantalon extends Ropa {

    private String tipoCierre;
    private boolean tieneBolsillos;
    private String material;
    private String tipoPantalon;

    // Constructor con todos los atributos
    public Pantalon(String nombre, float precio, String descripcion, String marca, int talla, 
            String color, String tipoCierre, boolean tieneBolsillos, String material, String tipoPantalon) {
        super(nombre, precio, descripcion, marca, talla, color);
        this.tipoCierre = tipoCierre;
        this.tieneBolsillos = tieneBolsillos;
        this.material = material;
        this.tipoPantalon = tipoPantalon;
    }
    
        // Constructor con todos los atributos CODIGO PRODUCTO
    public Pantalon(String nombre, float precio, String descripcion, String marca, String codigoProducto,
            int talla,String color, String tipoCierre, boolean tieneBolsillos, String material, String tipoPantalon) {
        super(nombre, precio, descripcion, marca, codigoProducto, talla, color);
        this.tipoCierre = tipoCierre;
        this.tieneBolsillos = tieneBolsillos;
        this.material = material;
        this.tipoPantalon = tipoPantalon;
    }

    // Constructor con información básica
    public Pantalon(String nombre, float precio, int talla, String color, String tipoPantalon) {
        super(nombre, precio, "", "", talla, color);
        this.tipoPantalon = tipoPantalon;
        // Se pueden asignar valores por defecto o dejar algunos atributos sin inicializar
    }

    // Constructor con información mínima
    public Pantalon(String nombre, float precio, int talla) {
        super(nombre, precio, "", "", talla, "");
        // Se pueden asignar valores por defecto o dejar algunos atributos sin inicializar
    }

    public boolean isTieneBolsillos() {
        return tieneBolsillos;
    }

    public void setTieneBolsillos(boolean tieneBolsillos) {
        this.tieneBolsillos = tieneBolsillos;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTipoPantalon() {
        return tipoPantalon;
    }

    public void setTipoPantalon(String tipoPantalon) {
        this.tipoPantalon = tipoPantalon;
    }

    public String getTipoCierre() {
        return tipoCierre;
    }

    public void setTipoCierre(String tipoCierre) {
        this.tipoCierre = tipoCierre;
    }

    @Override
    public String mostrarDetalles() {
        String detalle = "Pantalón : "
                + " \n Nombre :" + getNombre()
                + "\n Precio :" + getPrecio()
                + "\n Descripcion :" + getDescripcion()
                + "\n Marca :" + getMarca()
                + "\n Código Producto :" + getCodigoProducto()
                + "\n Talla :" + getTalla()
                + "\n Color :" + getColor()
                + "\n Tipo de cierre :" + tipoCierre
                + "\n Material :" + material
                + "\n Tiene bolsillos :" + tieneBolsillos
                + "\n Tipo de pantalón :" + tipoPantalon;
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
