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
}
