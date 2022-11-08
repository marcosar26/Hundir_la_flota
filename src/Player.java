public class Player {
    private final String nombre;
    private Tablero tablero;
    private int barcosRestantes;

    public Player(String nombre) {
        this.nombre = nombre;
    }

    public boolean atacar(int fila, int columna) {
        if (this.tablero.tocado(fila, columna)) {
            this.barcosRestantes--;
            return true;
        } else return false;
    }

    public void imprimirTablero() {
        this.tablero.imprimirTablero();
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public int getBarcosRestantes() {
        return barcosRestantes;
    }

    public void updateBarcos() {
        this.barcosRestantes = this.tablero.getBarcosTotales();
    }

    public String getNombre() {
        return nombre;
    }
}
