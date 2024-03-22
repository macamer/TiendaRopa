/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class Empleado extends Usuario {

    private static int totalEmpleados = 0;

    private String puesto;
    private float salario;
    private LocalDate fechaContratacion;

    public Empleado(String nombre, String correoElectronico, LocalDate fechNac, String direccion, String telefono, String dni, String puesto, float salario, LocalDate fechaContratacion) {
        super(nombre, correoElectronico, fechNac, direccion, telefono, dni);
        this.puesto = puesto;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;
    }

    // Constructor de la clase Empleado
    public Empleado(String nombre, String correoElectronico, LocalDate fechNac, String dni,
            String puesto, float salario, LocalDate fechaContratacion) {
        super(nombre, correoElectronico, fechNac, dni);
        this.puesto = puesto;
        this.salario = salario;
        this.fechaContratacion = fechaContratacion;

        totalEmpleados++;
    }

    //metodo abstracto -- MODIFICAR
    @Override
    public String info() {
        return "Empleado:"
                + "\n Nombre: " + getNombre()
                + "\n Email: " + getCorreoElectronico()
                + "\n Fecha nacimiento: " + getEdad()
                + "\n DNI: " + getDni()
                + "\n Puesto: " + puesto
                + "\n Salario: " + salario
                + "\n Fecha contratacion: " + fechaContratacion;
    }

    public static int getTotalEmpleados() {
        return totalEmpleados;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
