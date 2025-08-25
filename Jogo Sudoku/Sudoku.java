
public class Sudoku {


    public static final int BOARD_SIZE = 9;

    public static void main(String[] args) {

        int[][] SudokuBoard = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}


        };

        if (SudokuResolve(SudokuBoard)){
            System.out.println("\n\nSudoku resolvido!");
        }
        else {
            System.out.println("Falha na tentativa de resolver o Sudoku");
        }

        printSudokuResult(SudokuBoard);

        }

        public static  void printSudokuResult(int[][] SudokuBoard){
        for(int row = 0; row< BOARD_SIZE; row++){
            if (row % 3 == 0 && row!= 0){
                System.out.println("-------+--------+-------");
            }
            for(int column = 0; column< BOARD_SIZE; column++) {
                if (column % 3 == 0 && column!= 0) {
                    System.out.print(" | ");

                }


                System.out.print(SudokuBoard[row] [column]+ " ");
            }
            System.out.println();
            }

        }




    //VERIFICAR PRE-EXISTENCIA DO NUMERO NA LINHA
    public static boolean isnumberInRow(int[][] SudokuBoard, int row, int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (SudokuBoard[row][i] == number) {
                return true;
            }

        }
        return false;


    }

    //VERIFICAR PRE-EXISTENCIA DO NUMERO NA COLUNA
    public static boolean isnumberInColumn(int[][] SudokuBoard, int column, int number) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (SudokuBoard[i][column] == number) {
                return true;
            }

        }
        return false;

    }

    //VERIFICAR PRE-EXISTENCIA DO NUMERO NO QUADRADO 3X3
    public static boolean isnumberInQuad(int[][] SudokuBoard, int column, int row, int number) {

        int localBoxRow = row - row % 3;
        int localBoxColumn = column - column % 3;


        for (int i = localBoxRow; i < localBoxRow + 3; i++) {
            for (int j = localBoxColumn ; j < localBoxColumn  + 3; j++) {
                if (SudokuBoard[i][j] == number) {
                    return true;
                }
            }

        }
        return false;
    }


    //VERIFICAR SE O ESPAÇO VAZIO É VÁLIDO
    public static boolean isValidPlace(int[][] SudokuBoard, int column, int row, int number) {
        return !isnumberInColumn(SudokuBoard, column, number) &&  /*NOT (!) foi usado para checar   se nenhuma regra do jogo  está sendo ferida*/
                !isnumberInRow(SudokuBoard, row, number) &&
                !isnumberInQuad(SudokuBoard,  column, row,  number);
    }

    public static boolean SudokuResolve(int[][] SudokuBoard) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if (SudokuBoard[row][column] == 0) {
                    for (int number = 1; number <= BOARD_SIZE; number++) {
                        if (isValidPlace(SudokuBoard,  column, row, number)) {
                            SudokuBoard[row][column] = number;
                            if (SudokuResolve(SudokuBoard)) {
                                return true;
                            } else {
                                SudokuBoard[row] [column] = 0;
                             }
                        }
                    }
                    return false;
                }

            }
        }
        return true;

    }
}













