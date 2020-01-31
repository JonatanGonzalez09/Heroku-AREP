package edu.escuelaing.arep.designprimer;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    private Nodo head= null;

    /**
     * Constructor de LinkedList
     */
    public LinkedList(){

    }
    
    /**
     * Agrega un nodo a la LinkedList
     * @param id La posicion donde se quiere insertar el nodo.
     * @param node El nodo que va ha ser agragado.
     * @return El nodo agregado a la LinkedList
     */
    public Nodo add(int id, Nodo nodo) {
        if(head==null) {
            nodo.setId(1);
            head= nodo;
            return nodo;
        }
        Nodo actualNode = setNextNodo(id, nodo);
        return actualNode.nextNodo();
    }

    /**
     * Modifica el nodo siguiente de un nodo especificado con el id
     * @param id El identificador del nodo.
     * @param node El nodo que va ha ser remplazado por el nextNode.
     * @return El nextNode modificado.
     */
    private Nodo setNextNodo(int id, Nodo node) {
        Nodo actualNode = getNodo(id);
        Nodo nextNode = actualNode.nextNodo();
        actualNode.setNextNodo(node);
        node.setNextNodo(nextNode);
        node.setId(id+1);
        if(nextNode!=null){
            nextNode.setId(id+2);
            reubicarNodos();
        } 
        return actualNode;
    }

    /**
     * Reubica los id de los nodos cuando han sido cambiados.
     */
    private void reubicarNodos() {
        Nodo next= getNodo(1);
        Nodo prev= null;
        while(next != null) {
            if (prev != null) {
                next.setId(prev.getId() + 1);
            } else {
                head= next;
                next.setId(1);
            }
            prev = next;
            next= next.nextNodo();
        }
    }

    /**
     *  Elimina un nodo especifico teniendo el id
     * @param id El identificador del nodo.
     * @throws Exception Lanza la excepcion si el id del nodo no existe.
     */
    public void removerNodo(int id) throws Exception {
        if(head.nextNodo() == null) {
            head= null;
            return;
        }
        if(id == 1) {
            head.nextNodo().setId(1);
            head= head.nextNodo();
            reubicarNodos();
            return;
        }
        getNodo(id-1).setNextNodo(getNodo(id).nextNodo());
        reubicarNodos();
    }

    /**
     * Retornar el siguiente nodo al especificado.
     * @param id El identificador del nodo .
     * @return El nodo siguiente al nodo del id.
     * @throws Exception Lanza la excepcion si el nodo no existe.
     */
    public Nodo nextNodo(int id) throws Exception {
        return getNodo(id).nextNodo();
    }
    /**
     * Retorna el nodo anterior de un nodo especificado.
     * @param id El identificador del nodo.
     * @return el nodo anterior de un nodo especificado con el id.
     * @throws Exception Lanza la excepcion si el nodo no existe. 
     */
    public Nodo priorNodo(int id) throws Exception {
        return getNodo(id-1);
    }

    /**
     * Busca el nodo especificado por toda la LinkedList.
     * @param id el id del nodo a buscar.
     * @return retorna el nodo encontrado.
     * @throws IllegalArgumentException Lanza la excepcion si el nodo no existe.
     */
    private Nodo getNodo(int id) throws IllegalArgumentException{
        Nodo node = head;
        while(node != null) {
            if(node.getId()==id) {
                return node;
            }
            node= node.nextNodo();
        }
        throw new IllegalArgumentException("No existe nodo con el id: " + id);
    }

    /**
     * Devuelve la LinkedList
     * @return La lista con sus respectivos nodos.
     */
    public List getLinkedList() {
        Nodo node= head;
        ArrayList<Nodo> linkedList = new ArrayList<Nodo>();
        while (node!=null) {
            linkedList.add(node);
            node= node.nextNodo();
        }
        return linkedList;
    }

    /**
     * Devuelve la cabeza de la lista.
     * @return El primer elemento de la lista.
     */
    public Nodo getHead() {
        return head;
    }
}