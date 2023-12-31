package Modelo;

public class NodoCliente {

    private Cliente dato;
    private NodoCliente siguiente;

    public NodoCliente(Cliente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public NodoCliente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCliente siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "Cliente: {" + dato;
    }
}
