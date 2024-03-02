package BusinessLogic.entities;
public class SudokuGrid {
    private NodoLs[] cuadricula;
    private NodoLs verificarNod;

    public SudokuGrid() {
        cuadricula = new NodoLs[9];
        for (int i = 0; i < 9; i++) {
            cuadricula[i] = new NodoLs(); // Crea una nueva fila
        }
    }

    public void inicializarCuadricula(String[][] valores) {
        for (int i = 0; i < 9; i++) {
            NodoLs actual = cuadricula[i];
            for (int j = 0; j < 9; j++) {
                actual.setINFO(valores[i][j]);
                if (j < 8) {
                    NodoLs Q = new NodoLs();
                    actual.setLIGA(Q);
                    Q.setLIGA(null); // Avanza al siguiente nodo
                    actual = actual.getLIGA();
                }
            }
        }
    }

    public NodoLs[] getCuadricula() {
        return cuadricula;
    }

    public SudokuGrid createSudokuGrid() {
        String[][] valores = { { "5", "3", "6", "", "7", "", "", "", "" },
                { "6", "", "", "1", "9", "5", "", "", "" },
                { "", "9", "8", "", "", "", "", "6", "" },
                { "8", "", "", "", "", "", "", "", "3" },
                { "4", "", "", "8", "", "3", "", "", "1" },
                { "7", "", "", "", "2", "", "", "", "6" },
                { "", "6", "", "", "", "", "2", "8", "" },
                { "", "", "", "4", "1", "9", "", "", "5" },
                { "", "", "", "", "8", "", "", "7", "9" } };
        SudokuGrid sudokuGrid = new SudokuGrid();
        sudokuGrid.inicializarCuadricula(valores);
        return sudokuGrid;
    }

    public void imprimirSudokuGrid(SudokuGrid sudokuGrid) {
        NodoLs[] cuadricula = sudokuGrid.getCuadricula();
        for (int i = 0; i < 9; i++) {
            NodoLs actual = cuadricula[i];
            for (int j = 0; j < 9; j++) {
                System.out.print(actual.getINFO() + " ");
                actual = actual.getLIGA();
            }
            System.out.println();
        }
    }

    public boolean validarSudokuFila(SudokuGrid sudokuGrid) {
        boolean bandera = true;
        int contador;
        String valorSiguiente;
        NodoLs[] cuadricula = sudokuGrid.getCuadricula();
        for (int i = 0; i < 9; i++) {
            NodoLs actual = cuadricula[i];
            for (int j = 0; j < 9; j++) {
                System.out.print(actual.getINFO() + " ");
                if (!(actual.getINFO().equals(""))) {
                    contador = 0;
                    NodoLs actual2 = cuadricula[i];
                    for (int j2 = 0; j2 < 9; j2++) {
                        if (!(actual2.getINFO().equals(""))) {
                            valorSiguiente = actual2.getINFO();
                            System.out.println(valorSiguiente);
                            if (actual.getINFO().toString().equals(valorSiguiente)) {
                                contador = contador + 1;
                            }
                        }
                        actual2 = actual2.getLIGA();
                    }
                    if (contador > 1) {
                        bandera = false;
                        return bandera;
                    } else if (contador == 1) {
                        bandera = true;
                    }
                }
                actual = actual.getLIGA();
            }
            System.out.println();
        }
        return bandera;
    }
}
