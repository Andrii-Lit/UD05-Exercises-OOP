package Ej2;

public class Main {
    public static void main(String[] args) {
        JuegoBingo juego = new JuegoBingo(75, "Rojo", 75);
        juego.agregarJugador(new Jugador("Alice", 75));
        juego.agregarJugador(new Jugador("Bob", 75));
        juego.agregarJugador(new Jugador("Charlie", 75));
        juego.agregarJugador(new Jugador("Diana", 75));

        // Iniciar el juego
        juego.jugar();
    }
}
