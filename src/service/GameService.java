package service;

import model.Board;
import util.PrintBoard;

public class GameService {
    /*
    iniciar jogo, fazer jogada, limpar célula, consultar o tabuleiro, verificar se venceu e reiniciar o jogo */
    Board board;
    Validator v;

    public GameService(Validator validator) {
        this.v = validator;
    }

    public void startGame() {
        board = new PuzzleFactory().createBoard();
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

    public void printBoard(){
        PrintBoard.puzzleBoard(board);
    }   

    public Board getBoard() {
        return board;
    }

    public void gameState() {

    }    
}