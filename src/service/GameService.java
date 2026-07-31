package service;
import model.Board;

public class GameService {
    /*
    iniciar jogo, fazer jogada, limpar célula, consultar o tabuleiro, verificar se venceu e reiniciar o jogo */
    private Board board;
    Validator v;
    PuzzleData puzzleData;

    public GameService(Validator validator) {
        this.v = validator;
    }

    public void startGame() {
        RandomGame randomGame = new RandomGame();
        this.puzzleData = randomGame.gamePicker();
        PuzzleFactory puzzleFactory = new PuzzleFactory(puzzleData);
        board = puzzleFactory.createBoard();
    }

    public void restartGame() {
        PuzzleFactory puzzleFactory = new PuzzleFactory(puzzleData);
        board = puzzleFactory.createBoard();
    }

    public void makeMove(int row, int col, Integer value) {
        if(v.isValidValue(value) && v.isValidPosition(row, col, board.getCell(row, col))  ) {
            board.changeCellValue(row, col, value);
        }
    }

    public void clearMove(int row, int col) {
        if(v.isValidPosition(row, col, board.getCell(row, col))) {
            board.clearCellValue(row, col);
        }
    }

    public Board getBoard() {
        return board;
    }

    public boolean isConclude() {
        if(v.boardIsComplete(board)) {return v.boardIsSolved(board);}
        else{return false;}
    } 
}