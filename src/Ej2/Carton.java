package Ej2;

public class Carton {
    private int[] numeros;
    private int cantidadNumeros;

    public Carton(int maxNumero){
        numeros=new int[10];
        cantidadNumeros=0;
        while(cantidadNumeros<10){
            int numero= (int) (Math.random()*maxNumero)+1;
            if(!contieneNumero(numero)){
                numeros[cantidadNumeros]=numero;
                cantidadNumeros++;
            }
        }
    }

    public  boolean contieneNumero(int numero){
        for (int i = 0; i < cantidadNumeros; i++) {
            if (numeros[i]== numero){
                return true;
            }
        }
        return  false;
    }

    public void eliminarNumero(int numero){
        for (int i = 0; i < cantidadNumeros; i++) {
            if(numeros[i]==numero){
                numeros[i]=numeros[cantidadNumeros-1];//Para Reemplazar con el último numero
                cantidadNumeros--;
            }else {
                i++;
            }

        }
    }

    public boolean estaVacio(){
        return cantidadNumeros==0;
    }

    @Override
    public String toString(){
        String resultado = "Carton numeros=";
        for (int i = 0; i < cantidadNumeros; i++) {
            resultado+=numeros[i];
            if (i < cantidadNumeros-1){
                resultado += ", ";
            }
        }
        return resultado;
    }

}
