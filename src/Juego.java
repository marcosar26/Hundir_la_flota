import java.util.Random;
import java.util.Scanner;

public class Juego {
    private final int filas, columnas;
    private final Player player1;
    private final Player player2;

    public Juego(int filas, int columnas, Player player1, Player player2) {
        this.filas = filas;
        this.columnas = columnas;
        this.player1 = player1;
        this.player2 = player2;
        this.setupTablero();
        this.empezarJuego();
    }

    private void empezarJuego() {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("MENU");

            System.out.println("1. Atacar.");
            System.out.println("2. Ver tu tablero.");
            System.out.println("3. Salir.");
            System.out.println("4. (CHEAT) Ver tablero rival.");

            System.out.print("Selecciona opción:\s");
            int op = sc.nextInt();

            switch (op) {
                default -> System.out.println("Has introducido una opción incorrecta.");
                case 1 -> this.atacar();
                case 2 -> this.player1.imprimirTablero();
                case 3 -> System.exit(0);
                case 4 -> this.player2.imprimirTablero();
            }

        } while (!this.finJuego());

        System.out.println("El ganador del juego es: " + this.ganador());
    }

    private void atacar() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Introduce una fila:\s");
        int fila = sc.nextInt();

        System.out.print("Introduce una columna:\s");
        int columna = sc.nextInt();

        if (this.player2.atacar(fila, columna)) {
            System.out.println("¡HAS ALCANZADO UN BARCO ENEMIGO! TOCADO Y HUNDIDO.");
        } else {
            System.out.println("No has alcanzado ningún barco :(");
        }
        System.out.println();
        if (this.player1.atacar(random.nextInt(0, filas), random.nextInt(0, columnas))) {
            System.out.println("HAN HUNDIDO UN BARCO ALIADO.");
        } else {
            System.out.println("El enemigo no ha alcanzado nigún barco tuyo.");
        }
    }

    private boolean finJuego() {
        return this.player1.getBarcosRestantes() == 0 || this.player2.getBarcosRestantes() == 0;
    }

    private String ganador() {
        if (this.player1.getBarcosRestantes() > this.player2.getBarcosRestantes()) return this.player1.getNombre();
        else return this.player2.getNombre();
    }

    private void setupTablero() {
        this.player1.setTablero(new Tablero(new int[filas][columnas]));
        this.player2.setTablero(new Tablero(new int[filas][columnas]));

        this.player1.updateBarcos();
        this.player2.updateBarcos();
    }
}
