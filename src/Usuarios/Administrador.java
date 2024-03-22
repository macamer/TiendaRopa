package Usuarios;

import java.time.LocalDate;

public class Administrador extends Usuario {

    // Atributo de clase para realizar un seguimiento del número total de administradores
    private static int totalAdministradores = 0;

    private String rol;
    private int nivelAcceso;
    private String departamento;
    private boolean tienePrivilegios;
    
    //todos los campos
    public Administrador(String nombre, String correoElectronico, LocalDate fechNac, String direccion, String telefono, String dni, String rol, int nivelAcceso, String departamento, boolean tienePrivilegios) {
        super(nombre, correoElectronico, fechNac, direccion, telefono, dni);
        this.rol = rol;
        this.nivelAcceso = nivelAcceso;
        this.departamento = departamento;
        this.tienePrivilegios = tienePrivilegios;
    }

    //sin tareas asingadas
    public Administrador(String nombre, String correoElectronico, LocalDate fechNac,
            String dni, String rol, int nivelAcceso, String departamento,
            boolean tienePrivilegios) {
        super(nombre, correoElectronico, fechNac, dni);
        this.rol = rol;
        this.nivelAcceso = nivelAcceso;
        this.departamento = departamento;
        this.tienePrivilegios = tienePrivilegios;
        totalAdministradores++;
    }

    public Administrador(String nombre, String correoElectronico, LocalDate fechNac,
            String dni, String rol, int nivelAcceso, String departamento,
            boolean tienePrivilegios, String[] tareasAsignadas) {
        super(nombre, correoElectronico, fechNac, dni);
        this.rol = rol;
        this.nivelAcceso = nivelAcceso;
        this.departamento = departamento;
        this.tienePrivilegios = tienePrivilegios;
        totalAdministradores++;
    }

    // Métodos abstractos implementados
    @Override
    public String info() {
        return "Administrador:"
                + "\n Nombre: " + getNombre()
                + "\n Email: " + getCorreoElectronico()
                + "\n Fecha nacimiento: " + getEdad()
                + "\n DNI: " + getDni()
                + "\n Rol: " + rol
                + "\n Nivel de acceso: " + nivelAcceso
                + "\n Departamento: " + departamento
                + "\n Privilegios: " + (tienePrivilegios ? "Sí" : "No");
    }

    // Getters y setters para los atributos de Administrador
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isTienePrivilegios() {
        return tienePrivilegios;
    }

    public void setTienePrivilegios(boolean tienePrivilegios) {
        this.tienePrivilegios = tienePrivilegios;
    }

    // Getter para el atributo de clase totalAdministradores
    public static int getTotalAdministradores() {
        return totalAdministradores;
    }
}
