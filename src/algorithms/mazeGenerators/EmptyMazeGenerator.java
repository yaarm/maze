package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {

    /**
     * The function receives number of rows and columns and creates a empty maze - without any walls
     * @param row
     * @param column
     * @return
     */
    @Override
    public Maze generate(int row, int column) {
        if ((row < 0) || (row > 1000) || (column < 0) || (column > 1000)) {
            return null;
        }
        Position startPosition = getRandomPosition(row,column);
        Position endPosition = getRandomPosition(row,column);
        return new Maze(startPosition, endPosition, row, column);
    }
}
