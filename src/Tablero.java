import java.util.Random;

public class Tablero {
    private final int[][] barcos;
    private int barcosTotales;

    public Tablero(int[][] barcos) {
        this.barcos = barcos;
        this.randomizar();
    }

    private void randomizar() {
        Random random = new Random();

        for (int i = 0; i < barcos.length; i++) {
            for (int i1 = 0; i1 < barcos[i].length; i1++) {
                barcos[i][i1] = random.nextInt(0, 2);
                if (barcos[i][i1] == 1) barcosTotales++;
            }
        }
    }

    public boolean tocado(int fila, int columna) {
        if (barcos[fila][columna] == 1) {
            barcos[fila][columna] = 2;
            return true;
        } else {
            return false;
        }
    }

    public void imprimirTablero() {
        int c = 0;

        System.out.print("\s\s");
        for (int i = 0; i < barcos.length; i++) {
            System.out.print(i + "\s");
        }
        System.out.println();
        for (int[] barco : barcos) {
            System.out.print(c + "\s");
            c++;
            for (int i : barco) {
                if (i == 0) {
                    System.out.print("-\s");
                } else if (i == 1) {
                    System.out.print("*\s");
                } else if (i == 2) {
                    System.out.print("x\s");
                }
            }
            System.out.println();
        }
    }

    public int getBarcosTotales() {
        return barcosTotales;
    }
}
