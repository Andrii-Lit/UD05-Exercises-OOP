package Ej2;

public class Jugador {
    private String nombre;
    private double saldo;
    private Carton carton;

    public Jugador (String nombre, int maxNumero){
        this.nombre=nombre;
        this.saldo=20.0;
        this.carton =new Carton(maxNumero);
    }

    public String getNombre() {
        return nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public Carton getCarton() {
        return carton;
    }
    public void eliminarNumeroDelCarton(int numero){
        carton.eliminarNumero(numero);
    }

    @Override
    public String toString(){
        return "Jugador con el nombre: "+nombre+" Con saldo="+saldo+"| Y su carton= "+carton;
    }
}
