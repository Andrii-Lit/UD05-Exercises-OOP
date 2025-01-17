package Ej1;

import java.time.LocalDate;

public class Cliente {
    //Atributos
    private String nombre;
    private String apellidos;
    private LocalDate fechaDeNacimiento;
    private String DNI;
    private String sexo; // "H" para hombre, "M" para mujer
    private int altura;
    private Pesos[] historicoPesos; // Arreglo para almacenar el histórico de pesos
    private int contadorPesos;

    //Constructores
    public Cliente(String nombre,String apellidos, LocalDate fechaDeNacimiento, String DNI, String sexo, int altura){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.fechaDeNacimiento=fechaDeNacimiento;
        this.DNI=DNI;
        this.sexo=sexo;
        this.altura=altura;
        this.historicoPesos = new Pesos[100]; // Tamaño máximo del histórico de pesos
        this.contadorPesos = 0;

    }

    public Cliente(String nombre,String apellidos, LocalDate fechaDeNacimiento, String DNI, String sexo){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.fechaDeNacimiento=fechaDeNacimiento;
        this.DNI=DNI;
        this.sexo=sexo;


    }

    //Getters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getDNI() {
        return DNI;
    }

    public String getSexo() {
        return sexo;
    }

    public int getAltura() {
        return altura;
    }

    public Pesos[] getHistoricoPesos() {
        return historicoPesos;
    }

    public void agregarPeso(Pesos peso) {
        if (contadorPesos < historicoPesos.length) {
            historicoPesos[contadorPesos++] = peso;
        } else {
            System.out.println("Histórico de pesos lleno.");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", dni='" + DNI + '\'' +
                ", sexo='" + sexo + '\'' +
                ", altura=" + altura +
                '}';
    }

    public Pesos getUltimoPeso() {
        if (contadorPesos == 0) {
            return null;
        }
        return historicoPesos[contadorPesos - 1];
    }


}
