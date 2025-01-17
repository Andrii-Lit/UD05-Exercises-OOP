package Ej1;

import java.time.LocalDate;

public class Pesos {
    private Cliente cliente;
    private double peso; // en kilogramos
    private LocalDate fechaPesaje;
    private double imc;
    private String rangoIMC;
    private double porcentajeGrasa;
    private String rangoGrasa;
    private double tmb;
    private double pesoAjustado;

    public Pesos(double peso, Cliente cliente) {
        this.cliente=cliente;
        this.peso = peso;
        this.fechaPesaje = LocalDate.now();
        calcularDatos(cliente);
    }

    public Pesos(double peso, LocalDate fechaPesaje, Cliente cliente) {
        this.peso = peso;
        this.fechaPesaje = fechaPesaje;
        calcularDatos(cliente);
    }

    private void calcularDatos(Cliente cliente) {
        double alturaMetros = cliente.getAltura() / 100.0;
        this.imc = peso / (alturaMetros * alturaMetros);
        this.rangoIMC = calcularRangoIMC(imc);
        int edad = (int) java.time.temporal.ChronoUnit.YEARS.between(cliente.getFechaDeNacimiento(), LocalDate.now());
        this.rangoGrasa = calcularRangoGrasa(porcentajeGrasa, cliente.getSexo());
        this.tmb = calcularTMB(edad, peso, cliente.getAltura(), cliente.getSexo());
        this.pesoAjustado = calcularPesoAjustado(cliente.getSexo(), peso, cliente.getAltura());
    }

    private String calcularRangoIMC(double imc) {
        if (imc < 18.5) return "Bajo peso";
        else if (imc < 25) return "Rango normal";
        else if (imc < 30) return "Sobrepeso";
        else return "Obeso";
    }

    private double calcularPorcentajeGrasa(int edad, String sexo, double imc) {
        int sexoValor = sexo.equals("H") ? 0 : 1; // 0 para hombres, 1 para mujeres
        return -44.988 + (0.503 * edad) + (10.689 * sexoValor) + (3.172 * imc)
                - (0.026 * imc * imc) + (0.181 * imc * sexoValor)
                - (0.02 * imc * edad) - (0.005 * imc * imc * sexoValor)
                + (0.00021 * imc * imc * edad);
    }

    private String calcularRangoGrasa(double porcentajeGrasa, String sexo) {
        if (sexo.equals("H")) {
            if (porcentajeGrasa < 2) return "Grasa escasa";
            else if (porcentajeGrasa < 6) return "Grasa esencial";
            else if (porcentajeGrasa < 14) return "Deportistas";
            else if (porcentajeGrasa < 18) return "Fitness";
            else if (porcentajeGrasa < 25) return "Promedio";
            else return "Obesos";
        } else { // Para mujeres
            if (porcentajeGrasa < 10) return "Grasa escasa";
            else if (porcentajeGrasa < 14) return "Grasa esencial";
            else if (porcentajeGrasa < 20) return "Deportistas";
            else if (porcentajeGrasa < 25) return "Fitness";
            else if (porcentajeGrasa < 32) return "Promedio";
            else return "Obesos";
        }
    }

    private double calcularTMB(int edad, double peso, int altura, String sexo) {
        if (sexo.equals("H")) {
            return 10 * peso + 6.25 * altura - 5 * edad + 5;
        } else { // Para mujeres
            return 10 * peso + 6.25 * altura - 5 * edad - 161;
        }
    }

    private double calcularPesoAjustado(String sexo, double peso, int altura) {
        double pi;
        if (sexo.equals("H")) {
            pi = 52 + 0.75 * (altura - 152);
        } else { // Para mujeres
            pi = 49 + 0.67 * (altura - 152);
        }
        return peso + 0.4 * (pi - peso);
    }

    @Override
    public String toString() {
        return "Peso{" +
                "peso=" + peso +
                ", fechaPesaje=" + fechaPesaje +
                ", imc=" + imc +
                ", rangoIMC='" + rangoIMC + '\'' +
                ", porcentajeGrasa=" + porcentajeGrasa +
                ", rangoGrasa='" + rangoGrasa + '\'' +
                ", tmb=" + tmb +
                ", pesoAjustado=" + pesoAjustado +
                '}';
    }
}
