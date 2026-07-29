package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PuzzleRepository {

    //private List<String> lines = new ArrayList<>();
    private List<PuzzleData> Puzzles = new ArrayList<>();

    public PuzzleRepository() {
        List<String> linhas = loadLines();
        this.Puzzles = popularMatrizes(linhas);
    }

    public List<PuzzleData> getPuzzles() {
        return Puzzles;
    }    

    public List<String> loadLines() {
        Path path = Path.of("resources", "puzzles.txt");
        System.out.println(Path.of("").toAbsolutePath());
        List<String> linhas = new ArrayList<>();
        try { 
            linhas = Files.readAllLines(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return linhas;        
    }

    public List<PuzzleData> sortGame(){
        List<PuzzleData> gamesorted = new ArrayList<>();

        return gamesorted;
    }

    public List<PuzzleData> popularMatrizes(List<String> linhas) {
        List<PuzzleData> puzzlesList = new ArrayList<>();
        String state = "none";
        int[][] puzData = new int[9][9];
        int[][] solvData = new int[9][9];
        int row = 0;

        for (String linha : linhas) {
            linha = linha.trim();

            if (linha.equals("---")) {
                PuzzleData puzzleData = new PuzzleData(puzData,solvData);
                puzzlesList.add(puzzleData);
            }

            if (linha.equalsIgnoreCase("#Puzzle")) {
                state = "PUZZLE";
                row = 0;
            } else if (linha.equalsIgnoreCase("#Solution")) {
                state = "SOLUTION";
                row = 0;
            } else if (state.equals("PUZZLE") && row < 9) {
                for (int col = 0; col < 9; col++) {
                    puzData[row][col] = Character.getNumericValue(linha.charAt(col));
                }
                row++;
            } else if (state.equals("SOLUTION") && row < 9) {
                for (int col = 0; col < 9; col++) {
                    solvData[row][col] = Character.getNumericValue(linha.charAt(col));
                }
                row++;
            } else {
                continue;
            }
        }
        return puzzlesList;
    }
}

