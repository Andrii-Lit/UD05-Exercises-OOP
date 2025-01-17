package Ej2;

public class Bola {
    private int numero;
    private String color;

    public Bola(int numero, String color){
        this.numero=numero;
        this.color=color;
    }

    public int getNumero() {
        return numero;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString(){
        return "Bola numero="+numero+", color= "+color;
    }
}
