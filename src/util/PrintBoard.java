package util;

//import java.util.List;

import model.Board;
//import model.Cell;

public class PrintBoard {

    public static void solveBoard(Board matriz) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                System.out.print(matriz.getCell(r, c).getTrueValue() + " ");
            }
            System.out.println();
        }
    }

    public static void puzzleBoard(Board matriz) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if(matriz.getCell(r, c).getActualValue() != null) {
                    System.out.print(matriz.getCell(r, c).getActualValue() + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }    
}
