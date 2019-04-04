/**
 * The class represents a position - as a point with 2 coordinates (row and column)
 */
package algorithms.mazeGenerators;

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

    /**
     * The function set the row
     * @param row
     */
    public void setRow(int row) {
        if (row >= 0) {
            this.row = row;
        }
    }

    /**
     * The function set the column
     * @param column
     */
    public void setColumn(int column) {
        if (column >=0) {
            this.column = column;
        }
    }

    /**
     * The function returns true if this Position is equal to the other object, otherwise returns false
     * @param o
     * @return true if this Position is equal to the other object
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && column == position.column;
    }

    /**
     * The function returns the position as a string - {row,column}
     * @return String
     */
    @Override
    public String toString() {
        return "{" + row + "," + column + "}";
    }
}
