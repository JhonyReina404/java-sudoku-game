package model;

public class Cell {
    private Integer actualValue;
    private final int trueValue;
    private final boolean fixed;

    public Cell(int trueValue, boolean fixed) {
        this.trueValue = trueValue;
        this.fixed = fixed;
    }

    public void setActualValue(Integer actualValue) {
        this.actualValue = actualValue;
    }

    public Integer getActualValue() {
        return actualValue;
    }

    public int getTrueValue() {
        return trueValue;
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isEmpty() {
        return actualValue == null;
    }

    public void clearCell() {
        setActualValue(null);
    } 
}
