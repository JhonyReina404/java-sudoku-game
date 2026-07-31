package service;

import java.util.List;
import java.util.Random;

public class RandomGame {   

    public RandomGame() {
    }

    public PuzzleData gamePicker() {
        int[][] solution = new int[9][9];
        int[][] puzzle = new int[9][9];         
        PuzzleRepository gameRepo = new PuzzleRepository();
        List<PuzzleData> sort = gameRepo.getPuzzles();

        Random random = new Random();
        int randomIndex = random.nextInt(sort.size());

        puzzle = sort.get(randomIndex).getPuzzle();
        solution = sort.get(randomIndex).getSolution();        
        PuzzleData gamePicked = new PuzzleData(puzzle, solution);

        return gamePicked;
    }
}