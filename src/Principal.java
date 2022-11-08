import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //System.out.print("Introduce el nombre del primer jugador:\s");
        //String nombreP1 = sc.nextLine();

        String nombreP1 = "a";

        //System.out.print("Introduce el nombre del segundo jugador:\s");
        //String nombreP2 = sc.nextLine();

        String nombreP2 = "b";

        System.out.print("Introduce el número de filas:\s");
        int filas = sc.nextInt();

        System.out.print("Introduce el número de columnas:\s");
        int columnas = sc.nextInt();

        Player p1 = new Player(nombreP1);
        Player p2 = new Player(nombreP2);

        new Juego(filas, columnas, p1, p2);
    }
}
