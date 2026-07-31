package service;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.Cell;

public class PuzzleFactory {

    int[][] solution = new int[9][9];
    int[][] puzzle = new int[9][9];

    public List<List<Cell>> cells = new ArrayList<>();
    public Board board;

    public PuzzleFactory(PuzzleData puzzleData) {
        this.puzzle = puzzleData.getPuzzle();
        this.solution = puzzleData.getSolution();

        for (int i = 0; i < 9; i++) {
            List<Cell> line = new ArrayList<>();

            for (int j = 0; j < 9; j++) {
                int AnsValue = solution[i][j];
                int PuzzleValue = puzzle[i][j];

                boolean isFixed = (AnsValue == PuzzleValue) ? true : false;

                Cell cell = new Cell(AnsValue, isFixed);

                if (isFixed) {
                    cell.setActualValue(PuzzleValue);
                }
                line.add(cell);
            }
            cells.add(line);
        }
        this.board = new Board(cells);
    }
    
    public void setSolution(int[][] solution) {
        this.solution = solution;
    }

    public void setPuzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public Board createBoard() {
        return board;
    }

    public Board createBoardBack() {
        return board;
    }    
}
