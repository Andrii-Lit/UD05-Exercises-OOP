package Ej1;

public class MaquinaDePesar {
    public void pesarCliente(Cliente cliente, double peso) {
        Pesos nuevoPeso = new Pesos(peso, cliente);
        cliente.agregarPeso(nuevoPeso);
        System.out.println("Pesaje registrado: " + nuevoPeso);
    }

    public void mostrarDatosCliente(Cliente cliente) {
        System.out.println(cliente);
        Pesos ultimoPeso = cliente.getUltimoPeso();
        if (ultimoPeso != null) {
            System.out.println("Último peso registrado: " + ultimoPeso);
        } else {
            System.out.println("No hay registros de peso para este cliente.");
        }
    }

    public void mostrarHistoricoPesos(Cliente cliente) {
        System.out.println("Histórico de pesos de " + cliente.getNombre() + " " + cliente.getApellidos() + ":");
        for (int i = 0; i < cliente.getHistoricoPesos().length; i++) {
            if (cliente.getHistoricoPesos()[i] != null) {
                System.out.println(cliente.getHistoricoPesos()[i]);
            }
        }
    }
}
