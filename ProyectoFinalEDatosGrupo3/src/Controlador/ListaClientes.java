package Controlador;

import Modelo.NodoCliente;
import Modelo.Cliente;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class ListaClientes {

    private NodoCliente cabeza;

    public ListaClientes() {
        this.cabeza = null;
    }

    public void ingresarDatos() {
        inserta(new Cliente("Esteban", "Sanarrucia Molina", 1, "esteban@gmail.com", 71047034));
        inserta(new Cliente("Jorge", "Ramirez Brenes", 2, "jorge@gmail.com", 89437436));
        inserta(new Cliente("Michael", "Perez Amador", 3, "michael@gmail.com", 21449850));
        inserta(new Cliente("Francisco", "Sanarrucia Zeledon", 4, "francisco@gmail.com", 81048934));
    }

    public void inserta(Cliente cDato) {
        //verificar ID cliente
        if (existeClienteID(cDato.getCedulaCliente())) {
            System.out.println("Ya existe un cliente con esta cedula");
            return;
        }
        //Crear el nuevo nodo a insertar
        NodoCliente nuevo = new NodoCliente(cDato);

        if (cabeza == null) {
            //Lista es vacia
            cabeza = nuevo;

        } else if (cDato.getIdCliente() <= cabeza.getDato().getIdCliente()) {
            //Lista el dato menor o igual a la cabeza
            nuevo.setSiguiente(cabeza);
            cabeza = nuevo;

        } else if (cabeza.getSiguiente() == null) {
            //La lista solo tiene un elemento
            cabeza.setSiguiente(nuevo);

        } else {
            //para todos los casos que no se cumpla el if y else if
            NodoCliente aux = this.cabeza;
            while (aux.getSiguiente() != null
                    && aux.getSiguiente().getDato().getIdCliente() < cDato.getIdCliente()) {

                aux = aux.getSiguiente();
            }

            nuevo.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nuevo);

        }
    }

    public boolean existe(int cId) {
        if (cabeza == null) {
            return false;
        } else if (cabeza.getDato().getCedulaCliente() == cId) {
            return true;
        } else {
            NodoCliente aux = cabeza;
            while (aux.getSiguiente() != null && aux.getDato().getCedulaCliente() != cId) {
                aux = aux.getSiguiente();
            }
            return aux.getDato().getCedulaCliente() == cId;
        }
    }

    public Cliente extrae(int id) {
        Cliente cliente = null;
        if (cabeza.getDato().getCedulaCliente() == id) {
            cliente = cabeza.getDato();
            return cliente;
        } else {
            NodoCliente aux = cabeza;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato().getCedulaCliente() != id) {
                aux = aux.getSiguiente();
            }
            if (aux.getSiguiente() != null) {
                cliente = aux.getSiguiente().getDato();
                return cliente;
            } else {
                System.out.println("No existe un cliente registrado con este ID");
                return null;
            }
        }
    }

    public void modificar(int id) {
        int opcion = 0;
        if (cabeza == null) {
            System.out.println("La lista se encuentra vacía");
        } else if (cabeza.getDato().getCedulaCliente() == id) {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué desea modificar?\n"
                        + " 1 = Primer Nombre del Cliente\n "
                        + " 2 = Apellidos del Cliente\n "
                        + " 3 = Cedula del Cliente\n "
                        + " 4 = Correo del Cliente\n "
                        + " 5 = Numero del Cliente\n "));
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingreso opcion incorrecta");
            }
            switch (opcion) {
                case 1 -> {
                    String nombre = JOptionPane.showInputDialog("Ingrese nuevo nombre");
                    cabeza.getDato().setNombreCliente(nombre);
                    JOptionPane.showMessageDialog(null, "Cambiado con exito");
                }
                case 2 -> {
                    String apellidos = JOptionPane.showInputDialog("Ingrese nuevos apellidos");
                    cabeza.getDato().setApellidosCliente(apellidos);
                    JOptionPane.showMessageDialog(null, "Cambiado con exito");
                }
                case 3 -> {
                    int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva cedula"));
                    cabeza.getDato().setCedulaCliente(cedula);
                    JOptionPane.showMessageDialog(null, "Cambiado con exito");
                }
                case 4 -> {
                    String correo = JOptionPane.showInputDialog("Ingrese nuevo correo");
                    cabeza.getDato().setCorreoCliente(correo);
                    JOptionPane.showMessageDialog(null, "Cambiado con exito");
                }
                case 5 -> {
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo numero"));
                    cabeza.getDato().setNumCliente(numero);
                    JOptionPane.showMessageDialog(null, "Cambiado con exito");
                }
            }
        } else {
            NodoCliente aux = cabeza;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato().getIdCliente() <= id) {
                aux = aux.getSiguiente();
            }
            if (aux.getDato().getCedulaCliente() == id) {
                try {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog("¿Qué desea modificar?\n"
                            + " 1 = Primer Nombre del Cliente\n "
                            + " 2 = Apellidos del Cliente\n "
                            + " 3 = Cedula del Cliente\n "
                            + " 4 = Correo del Cliente\n "
                            + " 5 = Numero del Cliente\n "));
                } catch (HeadlessException | NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingreso opcion incorrecta");
                }
                switch (opcion) {
                    case 1 -> {
                        String nombre = JOptionPane.showInputDialog("Ingrese nuevo nombre");
                        if (nombre.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Texto vacio");
                        } else {
                            aux.getDato().setNombreCliente(nombre);
                            JOptionPane.showMessageDialog(null, "Cambiado con exito");
                        }
                    }
                    case 2 -> {
                        String apellidos = JOptionPane.showInputDialog("Ingrese nuevos apellidos");
                        if (apellidos.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Texto vacio");
                        } else {
                            aux.getDato().setApellidosCliente(apellidos);
                            JOptionPane.showMessageDialog(null, "Cambiado con exito");
                        }
                    }
                    case 3 -> {
                        int cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nueva cedula"));
                        aux.getDato().setCedulaCliente(cedula);
                        JOptionPane.showMessageDialog(null, "Cambiado con exito");
                        JOptionPane.showMessageDialog(null, "Texto vacio");
                    }
                    case 4 -> {
                        String correo = JOptionPane.showInputDialog("Ingrese nuevo correo");
                        if (correo.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Texto vacio");
                        } else {
                            aux.getDato().setCorreoCliente(correo);
                            JOptionPane.showMessageDialog(null, "Cambiado con exito");
                        }
                    }
                    case 5 -> {
                        int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevo numero"));
                        aux.getDato().setNumCliente(numero);
                        JOptionPane.showMessageDialog(null, "Texto vacio");
                    }
                }
            } else {
                System.out.println("No existe");
            }
        }
    }

    public void elimina(int id) {
        if (cabeza.getDato().getIdCliente() == id) {
            cabeza = cabeza.getSiguiente();
        } else {
            NodoCliente aux = cabeza;
            while (aux.getSiguiente().getDato().getIdCliente() != id) {
                aux = aux.getSiguiente();
            }
            NodoCliente siguiente = aux.getSiguiente().getSiguiente();
            aux.setSiguiente(siguiente);
        }
    }

    public boolean existeClienteID(int idCliente) {
        NodoCliente aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getCedulaCliente() == idCliente) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    public void comprasRealizadas() {
        String r = "Clientes con compras: \n";
        NodoCliente aux = cabeza;
        while (aux != null) {
            Cliente cliente = aux.getDato();
            if (tieneVentas(cliente)) {
                r += cliente.toString() + "\n";
            }
            aux = aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, r);
    }

    private boolean tieneVentas(Cliente cliente) {
        return cliente.getTotalComprados() != 0;
    }

    public void reservasRealizadas() {
        String r = "Clientes con reservas: \n";
        NodoCliente aux = cabeza;
        while (aux != null) {
            Cliente cliente = aux.getDato();
            if (tieneReservas(cliente)) {
                r += cliente.toString() + "\n";
            }
            aux = aux.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, r);
    }

    private boolean tieneReservas(Cliente cliente) {
        return cliente.getTotalReservados() != 0;
    }

    public void listarClientes() {
        NodoCliente aux = cabeza;
        int i = 0;
        while (aux != null) {
            aux = aux.getSiguiente();
            i++;
        }
        JOptionPane.showMessageDialog(null, "Hay " + i + " clientes registrados");
    }

    @Override
    public String toString() {
        String r = "";
        NodoCliente aux = cabeza;
        while (aux != null) {
            r += aux.toString() + "\n";
            aux = aux.getSiguiente();
        }
        return r;
    }
}
