
package MisListas;

import Usuarios.Cliente;
import Usuarios.Usuario;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Maria Cavaller
 */
public class ListaUsuarios {

    private ArrayList<Usuario> listaUsuarios;

    // Constructor por defecto
    public ListaUsuarios() {
        this.listaUsuarios = new ArrayList<>();
    }

    // Constructor que recibe una lista de usuarios
    public ListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = new ArrayList<>(listaUsuarios);
    }

    // Constructor que recibe un usuario y lo agrega a la lista
    public ListaUsuarios(Usuario usuario) {
        this.listaUsuarios = new ArrayList<>();
        this.listaUsuarios.add(usuario);
    }

    // Método para agregar un usuario a la lista
    public boolean añadirUsuario(Usuario usuario) {
        boolean insertado = false;
        if (usuario != null) {
            insertado = listaUsuarios.add(usuario);
        }
        return insertado;
    }

    public boolean borrarUsuario(Usuario usu) {
        boolean insertado = false;
        if (usu != null) {
            insertado = listaUsuarios.remove(usu);
        }
        return insertado;
    }

    public boolean borrarUsuario(String dni) {
        boolean insertado = false;
        Usuario a;
        a = buscaUsuario(dni);
        if (a != null) {
            insertado = listaUsuarios.remove(a);
        }
        return insertado;
    }

    public Usuario buscaUsuario(String dni) {
        Usuario usu = null, enc = null;
        boolean encontrado = false;
        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext() && encontrado == false) {
            usu = iterator.next();
            if (usu.getDni().equalsIgnoreCase(dni)) {
                enc = usu;
                encontrado = true;
            }
        }
        return enc;
    }

    public int buscaUsuarioPos(String dni) {
        Usuario usu = null;
        boolean encontrado = false;
        int pos = -1;

        Iterator<Usuario> iterator = listaUsuarios.iterator();
        while (iterator.hasNext() && encontrado == false) {
            usu = iterator.next();
            pos++;
            if (usu.getDni().equalsIgnoreCase(dni)) {
                encontrado = true;
            }
        }
        if (!encontrado) {
            pos = -1;
        }
        return pos;
    }
    
    public boolean existeUsuario(String dni) {
        Usuario usu;
        boolean existe = false;
        usu = buscaUsuario(dni);
        if (usu != null) {
            existe = true;
        }
        return existe;
    }

    public boolean modificaUsuario(Usuario uM) {
        boolean ok = false;
        Usuario u;
        int i;
        u = buscaUsuario(uM.getDni());
        i = listaUsuarios.indexOf(u);
        if (i != -1) {
            listaUsuarios.set(i, uM);
            ok = true;
        }
        return ok;
    }

    public int numUsuarios() {
        int num = 0;
        num = listaUsuarios.size();
        return num;
    }

    // Comprobar si la lista está vacía
    public boolean vaciaLista() {
        boolean vacia = false;
        if (listaUsuarios == null) {
            vacia = true;
        }
        return vacia;
    }

    public boolean vaciarLista() {
        boolean vacia = false;
        if (listaUsuarios == null) {
            vacia = true;
            listaUsuarios.clear();
        }
        return vacia;
    }

    public Usuario getUsuario(int i) {
        Usuario a = null;
        if (i >= 0 && i <= numUsuarios() - 1) {
            a = listaUsuarios.get(i);
        }
        return a;
    }

    // mostrar todos los precios
    public void mostrarUsuarios() {

        for (Usuario usu : listaUsuarios) {
            System.out.println(usu.info());
            System.out.println("");
        }
        System.out.println();
    }

    public void muestraClientes() {
        for (Usuario usu : listaUsuarios) {
            if (usu instanceof Cliente) {
                System.out.println(usu.info());
                System.out.println("");
            }
        }
        System.out.println();

    }
    
    public void muestraUsuTipo(String tipo) {
        for (Usuario usu : listaUsuarios) {
            try {
                if (Class.forName(tipo).isInstance(usu)) {
                    System.out.println(usu.info());
                    System.out.println("");
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Error");
            }
        }
        System.out.println();
    }
    
    public boolean añadirPedidoUsu (Cliente usu){
        boolean añadido = false;
        int num;
        if (usu != null){
            num = usu.getNumeroPedidosRealizados();
            usu.setNumeroPedidosRealizados(num+1);
            añadido = true;
        }
        return añadido;
    }
    
}
