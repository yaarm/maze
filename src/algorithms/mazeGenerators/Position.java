package algorithms.mazeGenerators;

import java.util.Objects;

public class Position {
    private int row;
    private int column;

    /**
     * constructor - The function receives two integers and creates position
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * The function returns the row of the position
     * @return row
     */
    public int getRowIndex() {
        return row;
    }

    /**
     * The function returns the column of the position
     * @return column
     */
    public int getColumnIndex() {
        return  column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    @Override
    public String toString() {
        return "{" + row + "," + column + "}";
    }
}
