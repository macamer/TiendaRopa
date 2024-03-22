package Ficheros;

import Articulos.Articulo;
import MisListas.ListaArticulos;
import MisListas.ListaUsuarios;
import Usuarios.Usuario;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Maria Cavaller
 */
public class Ficheros {

    public static boolean guardaArticulos(ListaArticulos miLista) {
        boolean guardado;
        Articulo art;
        FileOutputStream fs;
        ObjectOutputStream oos;
        try {
            fs = new FileOutputStream("src/Archivos/articulos.txt");
            oos = new ObjectOutputStream(fs);
            for (int i = 0; i < miLista.numArticulos(); i++) {
                art = miLista.getArticulo(i);
                oos.writeObject(art);//escribe el objeto en el flujo de salida
            }
            //cerramos los flujos abiertos una vez utilizados
            oos.close();
            fs.close();
            guardado = true;
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            guardado = false;
        }
        return guardado;
    }
    //devuelve 0 si no hay nada, 1 si se han cargado, 2 si no se ha cargado
    public static int cargaArticulos(ListaArticulos miLista) {
        boolean disponible = false;
        int result = 2;
        Articulo art;
        FileInputStream fe = null;
        DataInputStream d = null;
        ObjectInputStream ois;
        File f;

        //lectura del fichero (de manera analogo a la escritura)
        try {
            try {
                f = new File("src/Archivos/articulos.txt");
                if (f.exists()) {
                    fe = new FileInputStream(f);
                    ois = new ObjectInputStream(fe);
                    while (fe.available() > 0) {
                        art = null;
                        art = (Articulo) ois.readObject();
                        miLista.añadirArticulo(art);
                        result = 1;
                        disponible = true;
                    }
                    if (!disponible) {
                        result = 0;
                    }
                }
            } catch (EOFException eof) {
                System.err.println("Fin de Fichero encontrado. No se han cargado datos");
            } catch (FileNotFoundException fnf) {
                System.err.println("Fichero no encontrado " + fnf);
            } catch (IOException e) {
                System.err.println("Se ha producido un error IOException. No se han cargado datos");
            } catch (ClassNotFoundException e) {
                System.err.println("Error de programa " + e);
            } finally {
                if (d != null) {
                    d.close();
                    fe.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static boolean guardaUsuarios(ListaUsuarios miLista) {
        boolean guardado;
        Usuario usu;
        FileOutputStream fs;
        ObjectOutputStream oos;
        try {
            fs = new FileOutputStream("src/Archivos/usuarios.txt");
            oos = new ObjectOutputStream(fs);
            for (int i = 0; i < miLista.numUsuarios(); i++) {
                usu = miLista.getUsuario(i);
                oos.writeObject(usu);//escribe el objeto en el flujo de salida
            }
            oos.close();
            fs.close();
            guardado = true;
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
            guardado = false;
        }
        return guardado;
    }

    public static boolean cargaUsuarios(ListaUsuarios miLista) {
        boolean cargado = false, disponible = false;
        Usuario usu;
        FileInputStream fe = null;
        DataInputStream d = null;
        ObjectInputStream ois;
        File f;

        //lectura del fichero (de manera analogo a la escritura)
        try {
            try {
                f = new File("src/Archivos/usuarios.txt");
                if (f.exists()) {
                    fe = new FileInputStream(f);
                    ois = new ObjectInputStream(fe);
                    while (fe.available() > 0) {
                        usu = null;
                        usu = (Usuario) ois.readObject();
                        miLista.añadirUsuario(usu);
                        cargado = true;
                        disponible = true;
                    }
                    if (!disponible) {
                        System.err.println("No hay usuarios guardados en el archivo");
                    }
                }
            } catch (EOFException eof) {
                //Excepcion de fin de fichero atrapada por el bloque catch
                System.err.println("Fin de Fichero encontrado");
                cargado = false;
            } catch (FileNotFoundException fnf) {
                System.err.println("Fichero no encontrado " + fnf);
                cargado = false;
            } catch (IOException e) {
                System.err.println("Se ha producido un error IOException");
                e.printStackTrace();
                cargado = false;
            } catch (ClassNotFoundException e) {
                System.err.println("Error de programa " + e);
                cargado = false;
            } finally {
                if (d != null) {
                    d.close();
                    fe.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            cargado = false;
        }
        return cargado;
    }
}
/*
Crea una clase llamada Ficheros con 4 métodos estáticos para el manejo de los ficheros, 
su parámetro será la lista de objetos a almacenar/leer.
public static boolean guardaArticulos(ListaArticulos miLista)
public static boolean cargaArticulos( ListaArticulos miLista)
public static boolean guardaUsuarios(ListaUsuarios miLista)
public static boolean cargaUsuarios( ListaUsuarios miLista)
 */
