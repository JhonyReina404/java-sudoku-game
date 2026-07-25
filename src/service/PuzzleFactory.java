package service;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.Cell;

public class PuzzleFactory {

    int[][] solution = {
            { 5, 3, 4, 6, 7, 8, 9, 1, 2 },
            { 6, 7, 2, 1, 9, 5, 3, 4, 8 },
            { 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 6, 1, 4, 2, 3 },
            { 4, 2, 6, 8, 5, 3, 7, 9, 1 },
            { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
            { 9, 6, 1, 5, 3, 7, 2, 8, 4 },
            { 2, 8, 7, 4, 1, 9, 6, 3, 5 },
            { 3, 4, 5, 2, 8, 6, 1, 7, 9 }};

    int[][] puzzle = {
            { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
            { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
            { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
            { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
            { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
            { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
            { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
            { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
            { 0, 0, 0, 0, 8, 0, 0, 7, 9 }};

    public Board createBoard() {
        List<List<Cell>> cells = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            List<Cell> line = new ArrayList<>();       
            
            for (int j = 0; j < 9; j++) {
                int AnsValue = solution[i][j];
                int PuzzleValue = puzzle[i][j];

                boolean isFixed = (AnsValue == PuzzleValue)? true : false;
                
                Cell cell = new Cell(AnsValue, isFixed);

                if (isFixed) {
                    cell.setActualValue(PuzzleValue);
                }
                line.add(cell);
                //System.out.print(cell.getTrueValue() + " ");
            }
            //System.out.println();
            cells.add(line);
        }
        return new Board(cells);
    }
}
