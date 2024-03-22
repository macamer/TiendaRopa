package MisListas;

import Articulos.Articulo;
import Articulos.Bolso;
import Articulos.Camisa;
import Articulos.Chaqueta;
import Articulos.Pantalon;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Maria Cavaller
 */
public class ListaArticulos {

    private ArrayList<Articulo> listaArticulos;

    //constructor por defecto
    public ListaArticulos() {
        this.listaArticulos = new ArrayList<>();
    }

    //constructor a partir de una arrayList
    public ListaArticulos(ArrayList<Articulo> listaArticulos) {
        this.listaArticulos = listaArticulos;
    }

    //constructor para añadir una lista añadiendo ya un articulo
    public ListaArticulos(Articulo articulo) {
        listaArticulos = new ArrayList<>();
        this.listaArticulos.add(articulo);
    }

    public boolean añadirArticulo(Articulo art) {
        boolean añadido = false;
        if (art != null) {
            añadido = listaArticulos.add(art);
        }
        return añadido;
    }

    public Articulo buscaArticulo(String codArt) {
        Articulo art = null, enc = null;
        boolean encontrado = false;
        Iterator <Articulo> iter = listaArticulos.iterator();
        while (iter.hasNext() && encontrado == false) {
            art = iter.next();
            if (art.getCodigoProducto().equalsIgnoreCase(codArt)) {
                enc = art;
                encontrado = true;
            }
        }
        return enc;
    }

    //borrado por objeto articulo
    public boolean borrarArticulo(Articulo art) {
        boolean borrado = false;
        if (art != null) {
            borrado = listaArticulos.remove(art);
        }
        return borrado;
    }

    //borrado por codigo articulo
    public boolean borrarArticulo(String codArt) {
        boolean eliminado = false;
        Articulo art;
        art = buscaArticulo(codArt);
        if (art != null) {
            listaArticulos.remove(art);
            eliminado = true;
        }
        return eliminado;
    }

    public boolean modifArticulo(Articulo artM) {
        boolean modificado = false;
        Articulo a;
        int i;
        a = buscaArticulo(artM.getCodigoProducto());
        i = listaArticulos.indexOf(a);
        if (i != -1) {
            listaArticulos.set(i, artM);
            modificado = true;
        }
        return modificado;
    }

    public void mostrarArticulos() {
        for (Articulo art : listaArticulos) {
            System.out.println(art.mostrarDetalles());
            System.out.println("");
        }
        System.out.println();
    }

    public void mostrarCamisas() {
        for (Articulo art : listaArticulos) {
            if (art instanceof Camisa) {
                System.out.println(art.mostrarDetalles());
                System.out.println("");
            }
        }
        System.out.println();
    }

    public boolean existeArticulo(String codArt) {
        Articulo art;
        boolean existe = false;
        art = buscaArticulo(codArt);
        if (art != null) {
            existe = true;
        }
        return existe;
    }

    //metodo que devuelve un String segun el tipo de Articulo, por si solo tienes el codigo ---puede que no lo vaya a usar
    public String tipoArticulo(String codArt) {
        String tipo;
        Articulo art;
        art = buscaArticulo(codArt);
        if (art instanceof Camisa) {
            tipo = "Camisa";
        } else if (art instanceof Chaqueta) {
            tipo = "Chaqueta";
        } else if (art instanceof Pantalon) {
            tipo = "Pantalon";
        } else if (art instanceof Bolso) {
            tipo = "Bolso";
        } else {
            tipo = "Zapatos";
        }
        return tipo;
    }

    public int numArticulos() {
        int num = 0;
        num = listaArticulos.size();
        return num;
    }

    public boolean vaciaLista() {
        boolean vacia = false;
        if (listaArticulos != null) {
            vacia = true;
        }
        return vacia;
    }

    public boolean vaciarLista() {
        boolean vacia = false;
        if (listaArticulos != null) {
            vacia = true;
            listaArticulos.clear();
        }
        return vacia;
    }

    //obtener articulo a partir de indice
    public Articulo getArticulo(int i) {
        Articulo art = null;
        if (i >= 0 && i <= numArticulos() - 1) {
            art = listaArticulos.get(i);
        }
        return art;
    }

    public void muestraTipo(String tipo) {
        //ejemplo: miLista.muestraTipo("Articulos.Camisa"); --> no olvidar poner el package
        for (Articulo art : listaArticulos) {
            try {
                if (Class.forName(tipo).isInstance(art)) {
                    System.out.println(art.mostrarDetalles());
                    System.out.println("");
                }
            } catch (ClassNotFoundException ex) {
                System.out.println("Error");
            }
        }
        System.out.println("");
    }

    public String ultimoArticuloCod() {
        String cod = null;
        Articulo ultimoArticulo;
        if (!listaArticulos.isEmpty()) { // Verificar si la lista no está vacía
            ultimoArticulo = listaArticulos.get(listaArticulos.size() - 1); //suponiendo que esta ordenado
            cod = ultimoArticulo.getCodigoProducto(); 
        }
        return cod;
    }
    
    public void ordenarArticuloCod(){
        for (int i = 0; i < listaArticulos.size(); i++) {
            
        }
    }
}

/*
2-3 constructores
public boolean anadirArticulo(Articulo art) --
public Articulo buscaArticulo(String codArt) --
public boolean borrarArticulo(Articulo art) --
public boolean borrarArticulo(String codArt) --
public boolean modifArticulo(Articulo artM) --
public void mostrarArticulos() -- 
public void mostrarCamisas() --
public boolean existeArticulo(String codArt) --
public int numArticulos() --
public boolean vaciaLista() -- 
public boolean vaciarLista() --
public Articulo getArticulo(int i) ---
public void muestraTipo(String tipo) -> Para saber si a es de tipo es el objeto if (Class.forName(tipo).isInstance(a))--
 */
