package tiendaropa;

import Articulos.*;
import MisListas.*;
import static Libreria.Libreria.*;
import Libreria.ExceptionPropia;
import Usuarios.*;
import Pedidos.*;
import java.io.*;
import java.time.LocalDate;


/**
 *
 * @author Maria Cavaller
 */
public class TiendaRopa {

    public static void main(String[] args) throws IOException, ExceptionPropia {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // objetos
        Articulo art = null;
        Usuario usu = null;
        Pedido pedido;
        ListaArticulos listaArt = new ListaArticulos();
        // ListaEmpCli regLista = new ListaEmpCli();
        ListaUsuarios listaUsu = new ListaUsuarios();
        ListaPedidos listaPed = new ListaPedidos();
        LineaPedido lineaPed;
        // EmpAtiendeCli rel;

        // para intanciar
        // articulos
        String nombre, descr, marca, color, tipoManga, tipoCierre, material, tipoP, tipoSuela, tipo, estilo, cod;
        boolean impermeable, estampada, bolsillos, personalizado;
        int talla, capacidad;
        float precio;
        // usuarios
        String email, codProd, metodoPago, dir, dni, telf, dirEnvio, rol, departamento;
        boolean fidel, privilegios;
        int nivelAcceso;
        float saldo;
        LocalDate fechNac;
        // pedido
        String estado;
        int cantidad, numPed;
        LocalDate fechaPedido;

        // bucles
        String tipoArticulo;
        int menu, menu1, tipoArt, modificar, tipoUsu, cargar;
        boolean guardado = true, cargado = false, correcto, existe;

        mostrarMenu();
        do {
            System.out.println("****************************************************");
            menu = dameIntEntreMen(0, 8, "Elige una opción del menú principal: ");

            switch (menu) {

                // **********************************************************************************
                // GESTION ARTICULOS -------- añadir, borrar, modificar ---------
                case 1:
                    guardado = false; // avisar para guardar listas
                    if (!cargado) {
                        System.err.println("No se han cargado los datos con anterioridad");
                        // si no se cargan se duplican los codProd
                    } else {
                        System.out.println("\n***************** GESTIÓN ARTÍCULOS *****************");
                        menuGestionArticulos();
                        menu1 = dameIntEntreMen(1, 4, "Elige una opción del menú: ");
                        switch (menu1) {

                            // AÑADIR ARTICULO-----------------------------------
                            case 1:
                                System.out.println("\n***************** AÑADIR ARTÍCULO *****************");
                                System.out.println("1.-Camisa");
                                System.out.println("2.-Chaqueta");
                                System.out.println("3.-Pantalon");
                                System.out.println("4.-Bolso");
                                System.out.println("5.-Zapatos");
                                System.out.println("****************************************************");
                                tipoArt = dameIntEntreMen(1, 5, "Elige una opción: ");
                                // ARTICULO -->
                                System.out.println("****************************************************");
                                codProd = aplicarCod(listaArt);
                                nombre = pideStringNoVacio("Introduce el nombre del Artículo: ");
                                precio = pidePositivoFloat("Introduce el precio: ");
                                descr = pideStringNoVacio("Introduce la descripción: ");
                                marca = pideStringNoVacio("Introduce la marca: ");
                                // ROPA-->
                                if (tipoArt >= 1 && tipoArt <= 3) {
                                    talla = pidePositivoInt("Introduce la talla: ");
                                    color = pideStringNoVacio("Introduce el color: ");
                                    switch (tipoArt) {
                                        // CAMISA -->
                                        case 1:
                                            tipoManga = pideStringNoVacio("Introduce tipo de manga: ");
                                            tipoCierre = pideStringNoVacio("Introduce tipo de cierre: ");
                                            material = pideStringNoVacio("Introduce tipo de material: ");
                                            estampada = preguntaTrueFalse("Es estampada? S/N ");
                                            art = new Camisa(nombre, precio, descr, marca, codProd, talla, color,
                                                    tipoManga, tipoCierre, estampada, material);
                                            break;
                                        // CHAQUETA -->
                                        case 2:
                                            tipoCierre = pideStringNoVacio("Introduce tipo de cierre: ");
                                            material = pideStringNoVacio("Introduce tipo de material exterior: ");
                                            impermeable = preguntaTrueFalse("Es impermeable? S/N ");
                                            art = new Chaqueta(nombre, precio, descr, marca, codProd, talla, color,
                                                    tipoCierre, impermeable, material);
                                            break;
                                        // PANTALON -->
                                        case 3:
                                            tipoCierre = pideStringNoVacio("Introduce tipo de cierre: ");
                                            tipoP = pideStringNoVacio("Introduce tipo de Pantalón: ");
                                            bolsillos = preguntaTrueFalse("Tiene bolsillos? S/N ");
                                            material = pideStringNoVacio("Introduce tipo de material: ");
                                            art = new Pantalon(nombre, precio, descr, marca, codProd, talla, color,
                                                    tipoCierre, bolsillos, material, tipoP);
                                            break;
                                    }
                                    // ACCESORIOS -->
                                } else {
                                    tipo = pideStringNoVacio("Introduce el tipo: ");
                                    material = pideStringNoVacio("Introduce tipo de material: ");
                                    estilo = pideStringNoVacio("Introduce el estilo: ");
                                    personalizado = preguntaTrueFalse("Está Personalizado? S/N ");
                                    switch (tipoArt) {
                                        // BOLSO -->
                                        case 4:
                                            capacidad = pidePositivoInt("Introduce la capacidad: ");
                                            tipoCierre = pideStringNoVacio("Introduce tipo de cierre: ");
                                            art = new Bolso(nombre, precio, descr, marca, codProd, tipo, material,
                                                    estilo, personalizado, capacidad, tipoCierre);
                                            break;
                                        // ZAPATOS -->
                                        case 5:
                                            talla = pidePositivoInt("Introduce la talla: ");
                                            tipoSuela = pideStringNoVacio("Introduce el tipo de suela: ");
                                            art = new Zapatos(nombre, precio, descr, marca, codProd, tipo, material,
                                                    estilo, personalizado, talla, tipoSuela);
                                            break;
                                    }
                                }
                                if (listaArt.añadirArticulo(art)) {
                                    System.out.println("****************************************************");
                                    System.out.println(art.mostrarDetalles());
                                } else {
                                    System.err.println("***Ha habido un error al añadir el Artículo***");
                                }
                                break;

                            // BORRAR UN ARTÍCULO -----------------------------------------
                            case 2:
                                System.out.println("\n***************** BORRAR ARTÍCULO *****************");
                                System.out.print("Introduce el códido del artículo a borrar: ");
                                cod = reader.readLine();
                                if (listaArt.borrarArticulo(cod)) {
                                    System.out.println("*** El artículo ha sido borrado ***");
                                } else {
                                    System.err.println("****No se ha encontrado el artículo a borrar****");
                                }
                                break;

                            // MODIFICAR ARTICULO -----------------------------------
                            case 3:
                                System.out.println("\n*************** MODIFICAR DATO ARTÍCULO ***************");
                                System.out.print("Introduce el códido del artículo: ");
                                cod = reader.readLine();
                                art = listaArt.buscaArticulo(cod);
                                if (art != null) {
                                    do {
                                        System.out.println("****************************************************");
                                        System.out.println("0.-SALIR");
                                        System.out.println("1.-Nombre");
                                        System.out.println("2.-Precio");
                                        System.out.println("3.-Descripcion");
                                        System.out.println("4.-Marca");
                                        if (art instanceof Ropa) {
                                            System.out.println("5.-Talla");
                                            System.out.println("6.-Color");
                                            if (art instanceof Camisa) {
                                                System.out.println("7.-Tipo Manga");
                                                System.out.println("8.-Tipo Cierre");
                                                System.out.println("9.-Es estampada");
                                                System.out.println("10.-Material");
                                                System.out.println(
                                                        "****************************************************");
                                                modificar = dameIntEntreMen(0, 10, "Elige que deseas modificar:  ");
                                                switch (modificar) {
                                                    case 1:
                                                        nombre = pideStringNoVacio(
                                                                "Introduce el nombre del Artículo: ");
                                                        art.setNombre(nombre);
                                                        break;
                                                    case 2:
                                                        precio = pidePositivoFloat("Introduce el precio:");
                                                        art.setPrecio(precio);
                                                        break;
                                                    case 3:
                                                        descr = pideStringNoVacio("Introduce la descripción: ");
                                                        art.setDescripcion(descr);
                                                        break;
                                                    case 4:
                                                        marca = pideStringNoVacio("Introduce la marca: ");
                                                        art.setMarca(marca);
                                                        break;
                                                    case 5:
                                                        talla = pidePositivoInt("Introduce la talla: ");
                                                        ((Ropa) art).setTalla(talla);
                                                        break;
                                                    case 6:
                                                        color = pideStringNoVacio("Introduce el color: ");
                                                        ((Ropa) art).setColor(color);
                                                        break;
                                                    case 7:
                                                        tipoManga = pideStringNoVacio("Introduce el tipo de manga: ");
                                                        ((Camisa) art).setTipoManga(tipoManga);
                                                        break;
                                                    case 8:
                                                        tipoCierre = pideStringNoVacio("Introduce el tipo de cierre: ");
                                                        ((Camisa) art).setTipoCierre(tipoCierre);
                                                        break;
                                                    case 9:
                                                        estampada = preguntaTrueFalse("Es estampada? S/N ");
                                                        ((Camisa) art).setEsEstampada(estampada);
                                                        break;
                                                    case 10:
                                                        material = pideStringNoVacio("Introduce el material: ");
                                                        ((Camisa) art).setMaterial(material);
                                                        break;
                                                }
                                            } else if (art instanceof Chaqueta) {
                                                System.out.println("7.-Tipo Cierre");
                                                System.out.println("8.-Es o no impermeable");
                                                System.out.println("9.-Material Exterior");
                                                System.out.println(
                                                        "****************************************************");
                                                modificar = dameIntEntreMen(0, 9, "Elige que deseas modificar:  ");
                                                switch (modificar) {
                                                    case 1:
                                                        nombre = pideStringNoVacio(
                                                                "Introduce el nombre del Artículo: ");
                                                        art.setNombre(nombre);
                                                        break;
                                                    case 2:
                                                        precio = pidePositivoFloat("Introduce el precio:");
                                                        art.setPrecio(precio);
                                                        break;
                                                    case 3:
                                                        descr = pideStringNoVacio("Introduce la descripción: ");
                                                        art.setDescripcion(descr);
                                                        break;
                                                    case 4:
                                                        marca = pideStringNoVacio("Introduce la marca: ");
                                                        art.setMarca(marca);
                                                        break;
                                                    case 5:
                                                        talla = pidePositivoInt("Introduce la talla: ");
                                                        ((Ropa) art).setTalla(talla);
                                                        break;
                                                    case 6:
                                                        color = pideStringNoVacio("Introduce el color: ");
                                                        ((Ropa) art).setColor(color);
                                                        break;
                                                    case 7:
                                                        tipoCierre = pideStringNoVacio("Introduce el tipo de cierre: ");
                                                        ((Chaqueta) art).setTipoCierre(tipoCierre);
                                                        break;
                                                    case 8:
                                                        impermeable = preguntaTrueFalse("Es impermeable? S/N ");
                                                        ((Chaqueta) art).setImpermeable(impermeable);
                                                        break;
                                                    case 9:
                                                        material = pideStringNoVacio("Introduce el material: ");
                                                        ((Chaqueta) art).setMaterialExterior(material);
                                                        break;
                                                }
                                            } else {
                                                System.out.println("7.-Tipo Cierre");
                                                System.out.println("8.-Tiene Bolsillos");
                                                System.out.println("9.-Material");
                                                System.out.println("10.-Tipo de Pantalón");
                                                System.out.println(
                                                        "****************************************************");
                                                modificar = dameIntEntreMen(0, 10, "Elige que deseas modificar:  ");
                                                switch (modificar) {
                                                    case 1:
                                                        nombre = pideStringNoVacio(
                                                                "Introduce el nombre del Artículo: ");
                                                        art.setNombre(nombre);
                                                        break;
                                                    case 2:
                                                        precio = pidePositivoFloat("Introduce el precio:");
                                                        art.setPrecio(precio);
                                                        break;
                                                    case 3:
                                                        descr = pideStringNoVacio("Introduce la descripción: ");
                                                        art.setDescripcion(descr);
                                                        break;
                                                    case 4:
                                                        marca = pideStringNoVacio("Introduce la marca: ");
                                                        art.setMarca(marca);
                                                        break;
                                                    case 5:
                                                        talla = pidePositivoInt("Introduce la talla: ");
                                                        ((Ropa) art).setTalla(talla);
                                                        break;
                                                    case 6:
                                                        color = pideStringNoVacio("Introduce el color: ");
                                                        ((Ropa) art).setColor(color);
                                                        break;
                                                    case 7:
                                                        tipoCierre = pideStringNoVacio("Introduce el tipo de cierre: ");
                                                        ((Chaqueta) art).setTipoCierre(tipoCierre);
                                                        break;
                                                    case 8:
                                                        bolsillos = preguntaTrueFalse("Tiene Bolsillos? S/N ");
                                                        ((Chaqueta) art).setImpermeable(bolsillos);
                                                        break;
                                                    case 9:
                                                        material = pideStringNoVacio("Introduce el material: ");
                                                        ((Chaqueta) art).setMaterialExterior(material);
                                                        break;
                                                    case 10:
                                                        tipoP = pideStringNoVacio("Introduce tipo de Pantalón: ");
                                                        ((Pantalon) art).setTipoPantalon(tipoP);
                                                }
                                            }
                                        } else {
                                            // ACCESORIOS
                                            System.out.println("5.-Tipo");
                                            System.out.println("6.-Estilo");
                                            System.out.println("7.-Es personalizado");
                                            System.out.println("8.-Material");
                                            // BOLSO
                                            if (art instanceof Bolso) {
                                                System.out.println("9.-Capacidad");
                                                System.out.println("10.-Tipo de cierre");
                                                System.out.println(
                                                        "****************************************************");
                                                modificar = dameIntEntreMen(0, 10, "Elige que deseas modificar:  ");
                                                switch (modificar) {
                                                    case 1:
                                                        nombre = pideStringNoVacio(
                                                                "Introduce el nombre del Artículo: ");
                                                        art.setNombre(nombre);
                                                        break;
                                                    case 2:
                                                        precio = pidePositivoFloat("Introduce el precio:");
                                                        art.setPrecio(precio);
                                                        break;
                                                    case 3:
                                                        descr = pideStringNoVacio("Introduce la descripción: ");
                                                        art.setDescripcion(descr);
                                                        break;
                                                    case 4:
                                                        marca = pideStringNoVacio("Introduce la marca: ");
                                                        art.setMarca(marca);
                                                        break;
                                                    case 5:
                                                        tipoManga = pideStringNoVacio("Introduce tipo de accesorio: ");
                                                        ((Accesorio) art).setTipo(tipoManga);
                                                        break;
                                                    case 6:
                                                        tipoCierre = pideStringNoVacio("Introduce el estilo: ");
                                                        ((Accesorio) art).setEstilo(tipoCierre);
                                                        break;
                                                    case 7:
                                                        personalizado = preguntaTrueFalse("Es personalizado S/N ");
                                                        ((Accesorio) art).setEsPersonalizado(personalizado);
                                                        break;
                                                    case 8:
                                                        material = pideStringNoVacio("Introduce tipo de material: ");
                                                        ((Accesorio) art).setMaterial(material);
                                                        break;
                                                    case 9:
                                                        capacidad = pidePositivoInt("Introduce la capacidad: ");
                                                        ((Bolso) art).setCapacidad(capacidad);
                                                        break;
                                                    case 10:
                                                        tipoCierre = pideStringNoVacio("Introduce tipo de cierre: ");
                                                        ((Bolso) art).setTipoCierre(tipoCierre);
                                                        break;
                                                }
                                            } else {
                                                // ZAPATOS -->
                                                System.out.println("9.-Capacidad");
                                                System.out.println("10.-Tipo de cierre");
                                                System.out.println(
                                                        "****************************************************");
                                                modificar = dameIntEntreMen(0, 10, "Elige que deseas modificar:  ");
                                                switch (modificar) {
                                                    case 1:
                                                        nombre = pideStringNoVacio(
                                                                "Introduce el nombre del Artículo: ");
                                                        art.setNombre(nombre);
                                                        break;
                                                    case 2:
                                                        precio = pidePositivoFloat("Introduce el precio:");
                                                        art.setPrecio(precio);
                                                        break;
                                                    case 3:
                                                        descr = pideStringNoVacio("Introduce la descripción: ");
                                                        art.setDescripcion(descr);
                                                        break;
                                                    case 4:
                                                        marca = pideStringNoVacio("Introduce la marca: ");
                                                        art.setMarca(marca);
                                                        break;
                                                    case 5:
                                                        tipoManga = pideStringNoVacio("Introduce tipo de accesorio: ");
                                                        ((Accesorio) art).setTipo(tipoManga);
                                                        break;
                                                    case 6:
                                                        tipoCierre = pideStringNoVacio("Introduce el estilo: ");
                                                        ((Accesorio) art).setEstilo(tipoCierre);
                                                        break;
                                                    case 7:
                                                        personalizado = preguntaTrueFalse("Es personalizado S/N ");
                                                        ((Accesorio) art).setEsPersonalizado(personalizado);
                                                        break;
                                                    case 8:
                                                        material = pideStringNoVacio("Introduce tipo de material: ");
                                                        ((Accesorio) art).setMaterial(material);
                                                        break;
                                                    case 9:
                                                        talla = pidePositivoInt("Introduce la talla: ");
                                                        ((Zapatos) art).setTallaZapatos(talla);
                                                        break;
                                                    case 10:
                                                        tipoSuela = pideStringNoVacio("Introduce el tipo de suela: ");
                                                        ((Zapatos) art).setTipoSuela(tipoSuela);
                                                        break;
                                                }
                                            }
                                        }
                                    } while (modificar != 0);
                                    System.out.println(art.mostrarDetalles());
                                } else {
                                    System.err.println("No se ha encontrado artículo");
                                }
                                break;

                            // MODIFICAR TODOS LOS CAMPOS ----------------------------------------------
                            case 4:
                                System.out.println("\n***************** MODIFICAR ARTÍCULO *****************");
                                // probando instanciado nuevo objeto y despues metodo modiArticulo
                                System.out.print("Introduce el códido del artículo: ");
                                cod = reader.readLine().toUpperCase();
                                if (listaArt.existeArticulo(cod)) {
                                    tipoArticulo = listaArt.tipoArticulo(cod); // metodo que pasa string con tipo de
                                                                               // Articulo
                                    nombre = pideStringNoVacio("Introduce el nombre del Artículo: ");
                                    precio = pidePositivoFloat("Introduce el precio: ");
                                    descr = pideStringNoVacio("Introduce la descripción: ");
                                    marca = pideStringNoVacio("Introduce la marca: ");
                                    if (tipoArticulo.equals("Camisa") || tipoArticulo.equals("Chaqueta")
                                            || tipoArticulo.equals("Pantalon")) {
                                        talla = pidePositivoInt("Introduce la talla: ");
                                        color = pideStringNoVacio("Introduce el color: ");
                                        if (tipoArticulo.equals("Camisa")) {
                                            tipoManga = pideStringNoVacio("Introduce tipo de manga: ");
                                            tipoCierre = pideStringNoVacio("Introduce tipo de cierre: ");
                                            material = pideStringNoVacio("Introduce tipo de material: ");
                                            estampada = preguntaTrueFalse("Es estampada? S/N ");
                                            art = new Camisa(nombre, precio, descr, marca, cod, talla, color, tipoManga,
                                                    tipoCierre, estampada, material);
                                        } else if (tipoArticulo.equals("Chaqueta")) {
                                            tipoCierre = pideStringNoVacio("Introduce tipo de cierre: ");
                                            material = pideStringNoVacio("Introduce tipo de material: ");
                                            impermeable = preguntaTrueFalse("Es impermeable? S/N ");
                                            art = new Chaqueta(nombre, precio, descr, marca, cod, talla, color,
                                                    tipoCierre, impermeable, material);
                                        } else {
                                            tipoCierre = pideStringNoVacio("Introduce tipo de cierre: ");
                                            tipoP = pideStringNoVacio("Introduce tipo de Pantalón: ");
                                            bolsillos = preguntaTrueFalse("Tiene bolsillos? S/N ");
                                            material = pideStringNoVacio("Introduce tipo de material: ");
                                            art = new Pantalon(nombre, precio, descr, marca, cod.toUpperCase(), talla,
                                                    color, tipoCierre, bolsillos, material, tipoP);
                                        }
                                    } else {
                                        tipo = pideStringNoVacio("Introduce el tipo: ");
                                        material = pideStringNoVacio("Introduce tipo de material: ");
                                        estilo = pideStringNoVacio("Introduce el estilo: ");
                                        personalizado = preguntaTrueFalse("Está Personalizado? S/N ");
                                        if (tipoArticulo.equals("Bolso")) {
                                            capacidad = pidePositivoInt("Introduce la capacidad: ");
                                            tipoCierre = pideStringNoVacio("Introduce tipo de cierre: ");
                                            art = new Bolso(nombre, precio, descr, marca, cod.toUpperCase(), tipo,
                                                    material, estilo, personalizado, capacidad, tipoCierre);
                                        } else {
                                            talla = pidePositivoInt("Introduce la talla: ");
                                            tipoSuela = pideStringNoVacio("Introduce el tipo de suela: ");
                                            art = new Zapatos(nombre, precio, descr, marca, cod.toUpperCase(), tipo,
                                                    material, estilo, personalizado, talla, tipoSuela);
                                        }
                                    }
                                    if (listaArt.modifArticulo(art)) {
                                        System.out.println("\n****Articulo modificado****");
                                        System.out.println(art.mostrarDetalles());
                                    } else {
                                        System.err.println("****Ha habido un error al añadir el Artículo****");
                                    }
                                } else {
                                    System.err.println("****No se ha encontrado el artículo****");
                                }
                                break;
                        }
                    }
                    break;

                // **********************************************************************************
                // GESTION USUARIOS -------- añadir, borrar, modificar ----------
                case 2:
                    guardado = false; // se han modificado las listas
                    if (!cargado) {
                        System.err.println("No se han cargado los datos con anterioridad");
                        // si no se cargan se duplican los ids
                    } else {
                        System.out.println("\n***************** GESTIONAR USUARIOS *****************");
                        menuGestionUsuarios();
                        menu1 = dameIntEntreMen(1, 3, "Elige una opción del menú: ");
                        switch (menu1) {

                            // CREAR USUARIO ----------------------------------------------
                            case 1:
                                System.out.println("******* REGISTRAR USUARIO ********");
                                do {
                                    dni = validaDni();
                                    if (listaUsu.existeUsuario(dni)) {
                                        System.err.println("Este dni ya ha sido registrado");
                                        existe = true;
                                    } else {
                                        existe = false;
                                    }
                                } while (existe);
                                nombre = pedirNombre("Introduzca nombre: ");
                                email = pideStringNoVacio("Introduce correo: ");
                                fechNac = validaFecha("Introduce una fecha (yyyy-MM-dd): ");
                                dir = pideStringNoVacio("Introduce la dirección: ");
                                telf = pideTelefono("Introduce el teléfono: ");
                                System.out.println("*******************");
                                System.out.println("1.- Cliente");
                                System.out.println("2.- Administrador");
                                // System.out.println("3.- Empleado");
                                tipoUsu = dameIntEntreMen(0, 2, "Elige el tipo de usuario: ");
                                switch (tipoUsu) {
                                    // CLIENTE ----->
                                    case 1:
                                        System.out.println("*** CLIENTE ***");
                                        dirEnvio = pideStringNoVacio("Introduce la dirección de envío: ");
                                        metodoPago = pideStringNoVacio("Introduce que método pago usas: ");
                                        saldo = pidePositivoFloatSin0("Introduce saldo: ");
                                        fidel = preguntaTrueFalse("Tiene tarjeta de Fidelización? S/N ");
                                        usu = new Cliente(nombre, email, fechNac, dir, telf, dni, dirEnvio, metodoPago,
                                                saldo, fidel, 0);
                                        break;
                                    case 2:
                                        System.out.println("*** ADMINISTRADOR ***");
                                        rol = pideStringNoVacio("Introduce el rol: ");
                                        nivelAcceso = pidePositivoInt("Introduce el nivel de acceso(numero): ");
                                        departamento = pideStringNoVacio("Introduce el departamento: ");
                                        privilegios = preguntaTrueFalse("Tiene Privilegios? S/N");
                                        usu = new Administrador(nombre, email, fechNac, dir, telf, dni, rol,
                                                nivelAcceso, departamento, privilegios);
                                        break;
                                    /*
                                     * case 3:
                                     * //EMPLEADO --->
                                     * System.out.println("*** EMPLEADO ***");
                                     * salario = pidePositivoFloatSin0("Introduce salario: ");
                                     * puesto = pideStringNoVacio("Introduce puesto: ");
                                     * fechaCon = validaFecha("Introduce fecha contratación: ");
                                     * usu = new Empleado(nombre, email, fechN, dir, telf, dni, puesto, salario,
                                     * fechaCon);
                                     * break;
                                     */
                                }
                                if (listaUsu.añadirUsuario(usu)) {
                                    System.out.println("****************************************************");
                                    System.out.println(usu.info());
                                } else {
                                    System.err.println("***Ha habido un error al añadir el Usuario***");
                                }
                                break;

                            // BORRAR USUARIOS --------------------------------------------------
                            case 2:
                                System.out.println("\n***************** BORRAR USUARIO *****************");
                                dni = validaDni();
                                if (listaUsu.borrarUsuario(dni)) {
                                    System.out.println("*** El Usuario ha sido borrado ***");
                                } else {
                                    System.err.println("****No se ha encontrado elUsuario a borrar****");
                                }
                                break;
                            // MODIFICAR USUARIOS -----------------------------------------------
                            case 3:
                                System.out.println("\n***************** MODIFICA USUARIO *****************");
                                dni = validaDni();
                                usu = listaUsu.buscaUsuario(dni);
                                nombre = pedirNombre("Introduzca nombre: ");
                                email = pideStringNoVacio("Introduce correo: ");
                                fechNac = validaFecha("Introduce una fecha (yyyy-MM-dd): ");
                                dir = pideStringNoVacio("Introduce la dirección: ");
                                telf = pideTelefono("Introduce el teléfono: ");
                                if (usu instanceof Cliente) {
                                    dirEnvio = pideStringNoVacio("Introduce la dirección de envío: ");
                                    metodoPago = pideStringNoVacio("Introduce que método pago usas: ");
                                    saldo = pidePositivoFloatSin0("Introduce saldo: ");
                                    fidel = preguntaTrueFalse("Tiene tarjeta de Fidelización? S/N ");
                                    usu = new Cliente(nombre, email, fechNac, dir, telf, dni, dirEnvio, metodoPago,
                                            saldo, fidel, 0);
                                } else {
                                    rol = pideStringNoVacio("Introduce el rol: ");
                                    nivelAcceso = pidePositivoInt("Introduce el nivel de acceso(numero): ");
                                    departamento = pideStringNoVacio("Introduce el departamento: ");
                                    privilegios = preguntaTrueFalse("Tiene Privilegios? S/N");
                                    usu = new Administrador(nombre, email, fechNac, dir, telf, dni, rol, nivelAcceso,
                                            departamento, privilegios);
                                }
                                if (listaUsu.modificaUsuario(usu)) {
                                    System.out.println("*** El usuario ha sido modificado");
                                    usu.info();
                                } else {
                                    System.err.println("Ha habido un error al modificar");
                                }
                                break;

                        }
                    }
                    break;

                // **********************************************************************************
                // CONSULTAR ARTICULOS ------- Consulta, Listar ----------------
                case 3:
                    System.out.println("\n***************** CONSULTAR ARTÍCULO *****************");
                    System.out.println("1.-Consulta un Artículo");
                    System.out.println("2.-Lista todos los Artículos");
                    menu1 = dameIntEntreMen(1, 2, "Elige una opción del menú: ");
                    switch (menu1) {

                        // CONSULTAR UN ARTÍCULO -----------------------------
                        case 1:
                            System.out.println("\n***************** CONSULTAR ARTÍCULO *****************");
                            cod = validaCodigo("Introduce el códido del artículo: ");
                            art = listaArt.buscaArticulo(cod);
                            if (art != null) {
                                System.out.println(art.mostrarDetalles());
                            } else {
                                System.err.println("**** No se ha encontrado artículo ****");
                            }
                            break;

                        // LISTAR TODOS LOS ARTICULOS -------------------------
                        case 2:
                            System.out.println("\n***************** LISTAR ARTÍCULOS *****************");
                            if (listaArt.numArticulos() != 0) {
                                listaArt.mostrarArticulos();
                            } else {
                                System.err.println("****No hay artículos en la lista****");
                            }
                            break;
                    }
                    break;

                // **********************************************************************************
                // CONSULTAR USUARIOS ------- Consultar, Listar -----------------
                case 4:
                    System.out.println("\n***************** CONSULTAR USUARIO *****************");
                    System.out.println("1.-Consulta un Usuario");
                    System.out.println("2.-Lista todos los Usuarios");
                    menu1 = dameIntEntreMen(1, 2, "Elige una opción del menú: ");
                    switch (menu1) {
                        // CONSULTAR UN USUARIO -----------------------------
                        case 1:
                            System.out.println("\n***************** CONSULTAR USUARIO *****************");
                            dni = validaDni();
                            usu = listaUsu.buscaUsuario(dni);
                            if (usu != null) {
                                System.out.println(usu.info());
                            } else {
                                System.err.println("**** No se ha encontrado usuario ****");
                            }
                            break;

                        // LISTAR TODOS LOS USUARIOS -------------------------
                        case 2:
                            System.out.println("\n***************** LISTAR USUARIOS *****************");
                            if (listaUsu.numUsuarios() != 0) {
                                listaUsu.mostrarUsuarios();
                            } else {
                                System.err.println("****No hay usuarios en la lista****");
                            }
                            break;
                    }
                    break;

                // **********************************************************************************
                // DAR DE ALTA UN PEDIDO --------------------------------------
                case 5:
                    System.out.println("\n***************** REALIZAR PEDIDO *****************");
                    System.out.println("");
                    // sin clientes no se puede hacer un pedido
                    if (listaUsu.numUsuarios() == 0) {
                        System.err.println("No hay Clientes registrados");
                    } else {
                        do {
                            System.out.println("Cliente:");
                            dni = validaDni();
                            usu = listaUsu.buscaUsuario(dni);
                            // comprobar que existe y si es un Cliente
                            if (usu == null || !(usu instanceof Cliente)) {
                                System.err.println("No existe el Cliente");
                                correcto = false;
                            } else {
                                correcto = true;
                            }
                        } while (!correcto);
                        fechaPedido = validaFecha("Introduce fecha del pedido (yyyy-mm-dd): ");
                        estado = pideStringNoVacio("Introduce el estado del pedido: ");
                        try {
                            numPed = listaPed.proxNumPedido();
                            pedido = new Pedido(numPed, fechaPedido, (Cliente) usu, estado);
                            do {
                                do {
                                    System.out.println("Artículo:");
                                    cod = validaCodigo("Introduce el códido del artículo: ");
                                    art = listaArt.buscaArticulo(cod);
                                    if (art != null) {
                                        correcto = true;
                                    } else {
                                        System.err.println("**** No se ha encontrado artículo ****");
                                        correcto = false;
                                    }
                                } while (!correcto);
                                cantidad = pidePositivoInt("Introduce la cantidad: ");
                                lineaPed = new LineaPedido(cantidad, art);
                                pedido.anadirLinea(lineaPed);
                            } while (preguntaTrueFalse("Desea introducir otro artículo?"));
                            // agregar el pedido a la Lista de Pedidos -- solo avisar si ha habido un error
                            if (!listaPed.agregarPedido(pedido)) {
                                System.err.println("No se ha podido agregar el pedido a la lista");
                            }
                            // actualizar NumeroPedidosRealizados Cliente -- si funciona no necesitamos
                            // mensaje
                            if (!listaUsu.añadirPedidoUsu((Cliente) usu)) {
                                System.err.println("No se ha podido actualizar el número de pedidos del Usuario");
                            }
                        } catch (NullPointerException e) {
                            System.err.println("Lista de Pedidos no se ha creado");
                        } catch (IOException exc) {
                            System.err.println("Error en el input de los datos (IOException)");
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    break;

                // **********************************************************************************
                // MOSTRAR UN PEDIDO ------------------------------------------
                case 6:
                    numPed = pidePositivoInt("Introduce el Número del Pedido: ");
                    pedido = listaPed.buscaPedido(numPed);
                    if (pedido != null) {
                        pedido.mostrarPedido();
                    } else {
                        System.err.println("No se ha encontrado el pedido");
                    }
                    break;

                // **********************************************************************************
                // CARGAR LOS DATOS DE UN FICHERO ----------------------------
                case 7:
                    System.out.println("\n***************** CARGAR DATOS *****************");
                    if (!cargado) {
                        try {
                            // devuelve 1 si se ha cargado, 0 si no hay artículos y 2 si hay un error
                            // (aunque va a saltar la excepcion de todas formas)
                            cargar = Ficheros.Ficheros.cargaArticulos(listaArt);
                            if (cargar == 1) {
                                System.out.println("Artículos cargados ********");
                                // listaArt.mostrarArticulos();
                            } else if (cargar == 0) {
                                System.err.println("No hay archivos guardados en el fichero");
                            }
                            // cargaUsuarios devuelve un boolean según si ha cargado o no
                            if (Ficheros.Ficheros.cargaUsuarios(listaUsu)) {
                                System.out.println("Usuarios cargados ********");
                                // listaUsu.mostrarUsuarios();
                            }
                            cargado = true;
                        } catch (Exception e) {
                            // System.out.println("Error " + e.getMessage());
                            e.printStackTrace();
                            cargado = false;
                        }
                    } else {
                        // evitar duplicados
                        System.err.println("Ya se han cargado los datos con anterioridad");
                    }
                    break;

                // **********************************************************************************
                // GUARDAR LOS DATOS DE UN FICHERO ----------------------------
                case 8:
                    System.out.println("\n***************** GUARDAR DATOS *******************");
                    if (cargado) {
                        guardarDatos(listaArt, listaUsu);
                        guardado = true;
                    } else {
                        // por si no se ha cargado anteriormente -- no deberia ocurrir porque se avisa
                        // que no se ha cargado
                        System.err.println("No se han cargado los datos con anteriores");
                        if (preguntaTrueFalse("¿Desea guardar de todas formas? S/N")) {
                            if (guardarDatos(listaArt, listaUsu)) {
                                guardado = true;
                            }
                        } else {
                            System.out.println("\n****Datos NO guardados.");
                            guardado = false;
                        }
                    }
                    break;
                case 0:
                    if (!guardado) {
                        System.err.println("***No se han guardado los datos***");
                        if (!preguntaTrueFalse("¿Desea salir sin guardar? S/N")) {
                            menu = 13; // menu con cualquier número que no sea 0 para que no salga del programa
                        } else {
                            System.out.println("\n****Saliendo del programa.");
                        }
                    } else {
                        System.out.println("\n****Saliendo del programa.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (menu != 0);
    }

    // **********************************************************************************
    // **********************************************************************************
    // MENUS -->
    public static void mostrarMenu() {
        System.out.println("***************************************************");
        System.out.println("                    TIENDA DE ROPA                 ");
        System.out.println("***************************************************");
        System.out.println("1.-Gestión de Articulos (Añadir, Borrar, Modificar)");
        System.out.println("2.-Gestión de Usuarios (Añadir, Borrar, Modificar)");
        System.out.println("3.-Consultas de artículos");
        System.out.println("4.-Consultas de usuarios");
        // System.out.println("5.-Guardar una atención");
        System.out.println("5.-Dar de alta un pedido");
        System.out.println("6.-Mostrar un pedido");
        System.out.println("7.-Cargar Ficheros");
        System.out.println("8.-Guardar Ficheros");
        System.out.println("0.-SALIR");
    }

    public static void menuGestionArticulos() {
        System.out.println("1.-Añadir un artículo");
        System.out.println("2.-Borrar un Artículo");
        System.out.println("3.-Modificar algunos campos del Artículo");
        System.out.println("4.-Modificar todos los campos del Artículo");
    }

    public static void menuGestionUsuarios() {
        System.out.println("1.-Añadir un Usuario");
        System.out.println("2.-Borrar un Usuario");
        System.out.println("3.-Modificar un Usuario");
    }

    // Metodos -->
    public static boolean guardarDatos(ListaArticulos listaArt, ListaUsuarios listaUsu) {
        boolean guardado;
        try {
            if (Ficheros.Ficheros.guardaArticulos(listaArt)) {
                System.out.println("Se han guardado los Artículos de la lista");
            }
            if (Ficheros.Ficheros.guardaUsuarios(listaUsu)) {
                System.out.println("Se han guardado los Usuarios de la lista");
            }
            guardado = true;
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            guardado = false;
        }
        return guardado;
    }

    public static String aplicarCod(ListaArticulos listaArt) {
        String cod, ultimoCod;
        int ultimoNum, num;
        ultimoCod = listaArt.ultimoArticuloCod();
        // Extraer el número del último código
        ultimoNum = Integer.parseInt(ultimoCod.split("_")[1]);
        // Incrementar el número
        num = ultimoNum + 1;
        cod = "AR_" + num;
        return cod;
    }

    public static String validaCodigo(String texto) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String cod = null;
        do {
            try {
                System.out.print(texto);
                cod = reader.readLine();
                cod.toUpperCase();
                if (!cod.matches("[A][R][_][0-9]{1,}")) {
                    System.err.println("Formato de codigo no aceptado, debe empezar por AR_ .");
                }
            } catch (IOException ex) {
                System.err.println("Ha habido un error tipo IOException");
            }
        } while (!cod.matches("[A][R][_][0-9]{1,}"));
        return cod;
    }
}
/*
 * Alta de un pedido.
 * Mostrar un pedido.
 * Cargar datos desde ficheros.
 * Guardar datos en ficheros.
 */
/*
 * //MOSTRAR EMPLEADOS DE UN CLIENTE --------------------------
 * case 9:
 * dni = validaDni();
 * if (listaUsu.buscaUsuario(dni) != null) {
 * regLista.buscarEmpleados(dni);
 * } else {
 * System.err.println("No encontrado");
 * }
 * break;
 * 
 * //MOSTRAR CLIENTES SEGUN LA FECHA --------------------------
 * case 10:
 * dni = validaDni();
 * System.out.println();
 * fecha = pideStringVacio("Introduce la fecha :");
 * System.out.println("Ha atendido :" + regLista.atiendeCliente(dni, fecha));
 * break;
 */
/*
 * //GUARDAR ATENCIÓN -------------------------------------
 * case 5:
 * System.out.println("\n***************** GUARDAR ATENCIÓN *****************");
 * do {
 * System.out.println("Cliente.");
 * dni = validaDni();
 * usu = listaUsu.buscaUsuario(dni);
 * if (usu == null || !(usu instanceof Cliente)) {
 * correcto = false;
 * System.err.println("No existe el Cliente");
 * } else {
 * correcto = true;
 * }
 * } while (!correcto);
 * System.out.println("Empleado.");
 * do {
 * dni = validaDni();
 * usu1 = listaUsu.buscaUsuario(dni);
 * if (usu1 == null || !(usu1 instanceof Empleado)) {
 * correcto = false;
 * System.err.println("No existe el Empleado");
 * } else {
 * correcto = true;
 * }
 * 
 * } while (!correcto);
 * //RELACION EMPLEADO CLIENTE -->
 * rel = new EmpAtiendeCli((Cliente) usu, (Empleado) usu1);
 * guardado = regLista.agregarRelacion(rel);
 * if (guardado) {
 * regLista.mostrarRelaciones();
 * } else {
 * System.err.println("No se ha podido añadir");
 * }
 * break;
 */
