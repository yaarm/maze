/**
 * The class represent an empty maze without any walls, with start position and goal position
 */
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
        //create the maze
        Maze maze = new Maze(row, column);
        int [][] matrixMaze = maze.getMaze();

        //get random position for the start and goal of the maze
        Position startPosition = getRandomPosition(row,column);

        if (startPosition == null) {
            return null;
        }

        maze.setStartPosition(startPosition);

        Position goalPosition;
        int startRow,startColumn,goalRow,goalColumn;
        startRow = startPosition.getRowIndex();
        startColumn = startPosition.getColumnIndex();
        //get goal position that will be different from the start position
        do {
            goalPosition = getRandomPosition(row, column);
            goalRow = goalPosition.getRowIndex();
            goalColumn = goalPosition.getColumnIndex();
        } while (startPosition.equals(goalPosition) || startRow == goalRow || startColumn == goalColumn);

        if (goalPosition == null) {
            return null;
        }

        maze.setGoalPosition(goalPosition);

        //mark the start and goal position
        matrixMaze[startPosition.getRowIndex()][startPosition.getColumnIndex()] = 2;
        matrixMaze[goalPosition.getRowIndex()][goalPosition.getColumnIndex()] = 3;

        return maze;
    }
}
