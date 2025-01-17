package Ej2;

public class Bombo {
    private Bola[] bolas;
    private int cantidadBolas;
    private int bolasExtraidas;

    public Bombo(int cantidadBolas, String color){
        this.cantidadBolas=cantidadBolas;
        bolas=new Bola[cantidadBolas];
        for (int i =0; i< cantidadBolas; i++){
            bolas[i]=new Bola(i+1,color);
        }
        bolasExtraidas=0;
    }

    public Bola extraerBola(){
        if (bolasExtraidas >= cantidadBolas){
            return null; //En caso de que no hay mas bolas
        }
        Bola bola=bolas[bolasExtraidas];
        bolasExtraidas++;
        if (bolasExtraidas % 5 == 0){
            girarBombo();
        }
        return bola;
    }

    private void girarBombo(){//Girar el bombo (es decir que se mezclan las bolas)
        for (int i = 0; i < cantidadBolas; i++) {
            int j =(int) (Math.random()*cantidadBolas);
            Bola x = bolas[i];
            bolas[i]=bolas[j];
            bolas[j]= x;
        }

    }

}
