package Usuarios;

import java.time.LocalDate;

public class Cliente extends Usuario {

    public Cliente(String nombre, String correoElectronico, LocalDate fechNac, String direccion, String telefono, String dni, String direccionEnvio, String metodoPago, float saldoCuenta, boolean tieneTarjetaFidelidad, int numeroPedidosRealizados) {
        super(nombre, correoElectronico, fechNac, direccion, telefono, dni);
        this.direccionEnvio = direccionEnvio;
        this.metodoPago = metodoPago;
        this.saldoCuenta = saldoCuenta;
        this.tieneTarjetaFidelidad = tieneTarjetaFidelidad;
        this.numeroPedidosRealizados = numeroPedidosRealizados;
    }

    // Atributo de clase para realizar un seguimiento del número total de clientes
    private static int totalClientes = 0;

    private String direccionEnvio;
    private String metodoPago;
    private float saldoCuenta;
    private boolean tieneTarjetaFidelidad;
    private int numeroPedidosRealizados;

    //constructor minimo
    public Cliente(String nombre, String correoElectronico, LocalDate fechNac, 
            String direccion, String telefono, String dni) {
        super(nombre, correoElectronico, fechNac, direccion, telefono, dni);
        totalClientes++;
    }

    public Cliente(String nombre, String correoElectronico, LocalDate fechNac,
            String dni, String direccionEnvio, String metodoPago,
            float saldoCuenta, boolean tieneTarjetaFidelidad,
            int numeroPedidosRealizados) {
        super(nombre, correoElectronico, fechNac, dni);
        this.direccionEnvio = direccionEnvio;
        this.metodoPago = metodoPago;
        this.saldoCuenta = saldoCuenta;
        this.tieneTarjetaFidelidad = tieneTarjetaFidelidad;
        this.numeroPedidosRealizados = numeroPedidosRealizados;

        totalClientes++;
    }

    // Métodos abstractos implementados
    @Override
    public String info() {
        return "\nCliente:" + 
                "\n Nombre: " + getNombre() + 
                "\n Email: " + getCorreoElectronico() + 
                "\n Fecha nacimiento: " + getEdad() +
                "\n DNI: " + getDni() +
                "\n Direccion de envio: " + direccionEnvio + 
                "\n Metodo Pago: " + metodoPago + 
                "\n Saldo Cuenta: " + saldoCuenta +
                "\n Tarjeta Fidelidad: " + (tieneTarjetaFidelidad ? "Sí" : "No") +
                "\n Número de Pedidos Realizados: " + numeroPedidosRealizados;
    }

    // Getters y setters para los atributos de Cliente
    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getSaldoCuenta() {
        return saldoCuenta;
    }

    public void setSaldoCuenta(float saldoCuenta) {
        this.saldoCuenta = saldoCuenta;
    }

    public boolean isTieneTarjetaFidelidad() {
        return tieneTarjetaFidelidad;
    }

    public void setTieneTarjetaFidelidad(boolean tieneTarjetaFidelidad) {
        this.tieneTarjetaFidelidad = tieneTarjetaFidelidad;
    }

    public int getNumeroPedidosRealizados() {
        return numeroPedidosRealizados;
    }

    public void setNumeroPedidosRealizados(int numeroPedidosRealizados) {
        this.numeroPedidosRealizados = numeroPedidosRealizados;
    }

    // Getter para el atributo de clase totalClientes
    public static int getTotalClientes() {
        return totalClientes;
    }

}
