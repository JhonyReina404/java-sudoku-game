package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    private final List<List<Cell>> cells;

    public Board(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public List<List<Cell>> getBoard() {
        return cells;
    }

    public Cell getCell(int indexRow, int indexCol){
        return cells.get(indexRow).get(indexCol);
    }

    public List<Cell> getLine(int index){
        return cells.get(index);
    }

    public List<Cell> getCol(int index){
        return cells.stream().map(line -> line.get(index)).collect(Collectors.toList());
    }

    public List<Cell> getBlock(int row, int col) {
        List<Cell> block = new ArrayList<>();

        int startRow = (row/3) * 3;
        int startCol = (col/3) * 3;
        
        for(int r = startRow; r < startRow+3; r++) {
            for(int c = startCol; c < startCol+3; c++) {
                block.add(getCell(r, c));
            }
        }
        return block;
    }

    public void changeCellValue(int indexRow, int indexCol, Integer value){
        if(getCell(indexRow, indexCol).isFixed()){
            return;
        }
        getCell(indexRow, indexCol).setActualValue(value);
    }

    public void clearCellValue(int indexRow, int indexCol){
        if(getCell(indexRow, indexCol).isFixed()){
            return;
        }
        getCell(indexRow, indexCol).clearCell();
    }
}
