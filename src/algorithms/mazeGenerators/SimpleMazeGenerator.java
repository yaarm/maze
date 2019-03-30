package algorithms.mazeGenerators;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleMazeGenerator extends AMazeGenerator{

    /**
     * The function receives the number of columns and rows and creates a simple maze
     * @param row
     * @param column
     * @return simple maze
     */
    @Override
    public Maze generate(int row, int column) {
        //create new empty maze
        IMazeGenerator mg = new EmptyMazeGenerator();
        Maze simpleMaze = mg.generate(row, column);
        int[][] matrixMaze = simpleMaze.getMaze();
        //create a simple maze - using a blank empty maze
        createTheMaze(simpleMaze.getStartPosition(), simpleMaze.getGoalPosition() ,matrixMaze);
        simpleMaze.setMaze(matrixMaze);
        return simpleMaze;
    }

    /**
     * The function receives the start position and the goal position and the matrix of the an empty maze
     * and creates a simple maze
     * @param startPosition
     * @param goalPosition
     * @param maze
     */
    private void createTheMaze(Position startPosition, Position goalPosition ,int[][] maze) {
        //init the matrix
        initTheMaze(maze);
        //create a random path - the solution of the maze
        createTheMazePath(startPosition, goalPosition, maze);
        //create random walls in the maze
        generateWalls(maze);
        //mark the start and goal position
        maze[startPosition.getRowIndex()][startPosition.getColumnIndex()] = 2;
        maze[goalPosition.getRowIndex()][goalPosition.getColumnIndex()] = 3;
    }

    /**
     * The function receives the matrix of an empty maze and init it with a value that do not represent wall or path
     * @param maze
     */
    private void initTheMaze(int[][] maze) {
        for (int i=0; i<maze.length; i++) {
            java.util.Arrays.fill(maze[i], -1);
        }
    }

    /**
     * The function creates start position and goal position and the matrix of the maze and create a random path in it
     * @param startPosition
     * @param goalPosition
     * @param maze
     */
    private void createTheMazePath(Position startPosition, Position goalPosition, int[][] maze) {
        Position currPosition = new Position(startPosition.getRowIndex(), startPosition.getColumnIndex());
        int rowDirection, columnDirection;
        //set the cell as part of the path
        maze[currPosition.getRowIndex()][currPosition.getColumnIndex()] = 0;
        //generate a path until reaching the goal position of the maze
        while(!currPosition.equals(goalPosition)){
            //get the moving options - row and column
            rowDirection = getRowMoveOption(currPosition, goalPosition);
            columnDirection = getColumnMoveOption(currPosition, goalPosition);
            //make a random move - row or column
            currPosition = generateRandomMove(currPosition,rowDirection,columnDirection);
            //set the cell as part of the path
            maze[currPosition.getRowIndex()][currPosition.getColumnIndex()] = 0;
        }
    }

    /**
     * The function receives the current position and returns the right option to move in the row
     * @param currPosition
     * @param goalPosition
     * @return 1: go down in the row, -1: go up in the row, 0: stay in the same row
     */
    private int getRowMoveOption(Position currPosition, Position goalPosition) {
        if (currPosition.getRowIndex() < goalPosition.getRowIndex()) {
            return 1;
        }
        else if (currPosition.getRowIndex() > goalPosition.getRowIndex()){
            return -1;
        }
        else {
            return 0;
        }
    }

    /**
     * The function receives the current position and returns the right option to move in the column
     * @param currPosition
     * @param goalPosition
     * @return 1: go right in the row, -1: go left in the row, 0: stay in the same column
     */
    private int getColumnMoveOption(Position currPosition, Position goalPosition) {
        if (currPosition.getColumnIndex() < goalPosition.getColumnIndex()) {
            return 1;
        }
        else if (currPosition.getColumnIndex() > goalPosition.getColumnIndex()) {
            return -1;
        }
        else {
            return 0;
        }
    }

    /**
     * The function receives the current position, the options to move in the row and column and decides
     * randomly which way to go
     * @param currPosition
     * @param rowDirection
     * @param columnDirection
     * @return the position after the change (row or column)
     */
    private Position generateRandomMove(Position currPosition, int rowDirection, int columnDirection) {
        //there is only an option to change the column
        if (rowDirection == 0) {
            currPosition.setColumn(currPosition.getColumnIndex() + columnDirection);
        }
        //there is only an option to change the raw
        else if (columnDirection == 0) {
            currPosition.setRow(currPosition.getRowIndex() + rowDirection);
        }
        //need to choose random the change - row or column
        else {
            int advanceSide = ThreadLocalRandom.current().nextInt(1, 3);
            // 1 - means row direction, 2 - means column direction
            if (advanceSide == 1) {
                currPosition.setRow(currPosition.getRowIndex() + rowDirection);
            }
            else {
                currPosition.setColumn(currPosition.getColumnIndex() + columnDirection);
            }
        }
        return currPosition;
    }

    /**
     * The function creates walls in the matrix maze randomly
     * @param maze
     */
    private void generateWalls(int[][] maze) {
        for (int i=0; i<maze.length; i++) {
            for (int j=0; j<maze[i].length; j++) {
                if (maze[i][j] == -1) {
                    maze[i][j] = ThreadLocalRandom.current().nextInt(0, 2);

                }
            }
        }
    }

}
