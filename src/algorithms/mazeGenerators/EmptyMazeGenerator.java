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
        //check if the arguments are valid
        if ((row < 0) || (row > 1000) || (column < 0) || (column > 1000)) {
            return null;
        }

        //get random position for the start and goal of the maze
        Position startPosition = getRandomPosition(row,column);

        if (startPosition == null) {
            return null;
        }
        Position goalPosition;
        int startRow,startColumn,goalRow,goalColumn;
        startRow = startPosition.getRowIndex();
        startColumn = startPosition.getColumnIndex();
        do {
            goalPosition = getRandomPosition(row, column);
            goalRow = goalPosition.getRowIndex();
            goalColumn = goalPosition.getColumnIndex();
        } while (startPosition.equals(goalPosition) || startRow == goalRow || startColumn == goalColumn);

        if (goalPosition == null) {
            return null;
        }

        //create the maze
        Maze maze = new Maze(startPosition, goalPosition, row, column);
        int [][] matrixMaze = maze.getMaze();
        //mark the start and goal position
        matrixMaze[startPosition.getRowIndex()][startPosition.getColumnIndex()] = 2;
        matrixMaze[goalPosition.getRowIndex()][goalPosition.getColumnIndex()] = 3;

        return maze;
    }
}
