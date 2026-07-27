package service;

import java.util.List;
import java.util.Objects;

import model.Board;
import model.Cell;

public class Validator {

    public boolean isValidValue(Integer value) { //checks if the value is acceptable
        if(value >= 0 && value <= 9) { return true;}
        else{return false;}
    }

    public boolean isValidPosition(int posRow, int posCol, Cell cell) {//checks if the position is valid
        if((posRow >= 0 && posRow <= 8) && (posCol >= 0 && posCol <= 8) && (!cell.isFixed())) { return true;}
        else{return false;}
    } 

    public boolean isPlayValidLine(Board board, int indexLine, Integer value) {//Checks if there are no repeated numbers in the row.
        List<Cell> line = board.getLine(indexLine);
        return line.stream().noneMatch(cell -> cell.getActualValue() != null && cell.getActualValue() == value);
    }
    
    public boolean isPlayValidColumn(Board board, int indexLine, Integer value) {//Checks if there are no repeated numbers in the column.
        List<Cell> line = board.getCol(indexLine);
        return line.stream().noneMatch(cell -> cell.getActualValue() != null && cell.getActualValue() == value);
    }

    public boolean isValidMoveBlock(Board board, int indexRow, int indexCol, Integer value) {//Checks if there are no repeated numbers in the block.
        List<Cell> block = board.getBlock(indexRow, indexCol);
        return block.stream().noneMatch(cell -> cell.getActualValue() != null && cell.getActualValue() == value);
    }

    public boolean boardIsComplete(Board board) {//Checks if the board is fully.
        return !(board.getBoard().stream().flatMap(List::stream).anyMatch(cell -> cell.getActualValue() == null));
    }
    
    public boolean boardIsSolved(Board board) {//Checks if the full board is correct
        return boardIsComplete(board) &&
               (board.getBoard().stream().flatMap(List::stream).allMatch(cell -> Objects.equals(cell.getActualValue(), cell.getTrueValue())));
    }
}
/*

Mais tarde você pode fazer algo interessante. Isso abre espaço para um botão "Verificar tabuleiro" quando você migrar para Swing.

O Validator pode responder:

Existem 3 conflitos.

Ou

As posições erradas são:

(2,4)

(5,7)

(8,1)
*/
