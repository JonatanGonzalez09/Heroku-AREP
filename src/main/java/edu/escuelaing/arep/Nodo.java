package edu.escuelaing.arep;

/**
 * Clase Nodo 
 * @param <T> Tipo de dato que sera el nodo
 */
public class Nodo<T> {
    private Nodo<T> next = null;
    private T dato;
    private int id;

    /**
     * Constructor de un nodo
     * @param dato El dato del nodo
     */
    public Nodo(T dato){
        this.dato = dato;
    }

    /**
     * Devuelve el nodo siguiente.
     * @return el nodo siguiente
     */
    public Nodo<T> nextNodo() {
        return next;
    }

    /**
     * Devuelve el Id.
     * @return el Id.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Devuelve los datos del nodo.
     * @return El dato que hay en el nodo.
     */
    public String getDatos() {
        return dato.toString();
    }

    /**
     * Modifica el nodo siguiente.
     * @param Nodo El nodo para reemplazar el existente.
     */
    public void setNextNodo(Nodo<T> nodo) {
        this.next= nodo;
    }

    /**
     * Modifica el id del nodo.
     * @param id el nuevo id que tendra el nodo.
     */
    public void setId(int id) {
        this.id= id;
    }

    /**
     * Imprime el nodo para observar los datos que tiene.
     * @return devuelve el id y los datos que tiene el nodo.
     */
    public String toString() {
        return "[id:"+this.id+", dato:"+this.dato +" ]";
    }
}

