package Ej1;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creamos un cliente
        Cliente cliente = new Cliente("Juan", "Pérez", LocalDate.of(1990, 1, 1), "12345678A", "H", 180);

        // Creamos la máquina de pesar
        MaquinaDePesar maquina = new MaquinaDePesar();

        // Pesamos al cliente
        maquina.pesarCliente(cliente, 75.0);
        maquina.pesarCliente(cliente, 76.5);
        maquina.pesarCliente(cliente, 74.0);

        // Mostramos los datos del cliente
        maquina.mostrarDatosCliente(cliente);

        // Mostramos el histórico de pesos
        maquina.mostrarHistoricoPesos(cliente);
    }
}
