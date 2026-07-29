package service;

public class PuzzleData {

    private int [][] puzzle = new int[9][9];
    private int [][] solution = new int[9][9];

    public PuzzleData(int[][] puzzle, int[][] solution) {
        this.puzzle = puzzle;
        this.solution = solution;
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    public int[][] getSolution() {
        return solution;
    }
    
    public void setPuzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public void setSolution(int[][] solution) {
        this.solution = solution;
    }
}
