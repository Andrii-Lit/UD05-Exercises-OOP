package Ej2;

public class JuegoBingo {
    private Jugador[] jugadores;
    private int cantidadJugadores;
    private Bombo bombo;

    public JuegoBingo(int cantidadBolas, String color, int maxNumero){
        jugadores = new Jugador[10]; //Cantidad maxima de 10 jugadores
        cantidadJugadores=0;
        bombo=new Bombo(cantidadBolas,color);
    }

    public void agregarJugador(Jugador jugador){
        if(cantidadJugadores<10){
            jugadores[cantidadJugadores]=jugador;
            cantidadJugadores++;
        }else {
            System.out.println("Ya hay suficientes jugadores.");
        }
    }

    public void jugar(){
        boolean juegoActivo =true; //Para que el juego sigue

        while (juegoActivo){
            Bola bola=bombo.extraerBola();
            if(bola == null){
                System.out.println("No hay mas bolas en el bombo.");
                juegoActivo=false;//EL juego termina si no hay mas bolas
            }else{
                System.out.println("Bola extraida: "+bola);
                for (int i = 0; i < cantidadJugadores; i++) {
                    Jugador jugador =jugadores[i];
                    if(jugador != null && jugador.getCarton().contieneNumero(bola.getNumero())){
                        jugador.eliminarNumeroDelCarton(bola.getNumero());
                        System.out.println(jugador.getNombre()+" ha eliminado el numero "+bola.getNumero()+" de su carton." );
                    }
                    if (jugador!=null&&jugador.getCarton().estaVacio()){
                        System.out.println(jugador.getNombre()+" ha ganado!");
                        juegoActivo=false;//Si hay un ganador el juego se termina
                    }

                }
            }
        }
    }
}
