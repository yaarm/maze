/**
 * The class represents a maze with start and goal position
 */
package algorithms.mazeGenerators;

public class Maze {

    private Position startPosition;
    private Position goalPosition;
    private int[][] maze;

    /**
     * The function receives start and goal positions and the number of rows and columns and creates new maze
     *
     * @param numOfRows
     * @param numOfColumns
     */
    public Maze(int numOfRows, int numOfColumns) {
        if (numOfRows > 0 && numOfColumns > 0) {
            this.maze = new int[numOfRows][numOfColumns];
        }
        else {
            System.out.println("Invalid Arguments. number of rows and columns must be grater then 0");
            System.exit(1);
        }
        this.startPosition = null;
        this.goalPosition = null;

    }

    /**
     * The function returns the start position of the maze
     *
     * @return startPosition
     */
    public Position getStartPosition() {
        return startPosition;
    }

    /**
     * The function returns the goal position of the maze
     *
     * @return goalPosition
     */
    public Position getGoalPosition() {
        return goalPosition;
    }

    /**
     * The function returns the maze represented by two dimensional array
     *
     * @return maze
     */
    public int[][] getMaze() {
        return maze;
    }

    /**
     * The function set new start position
     *
     * @param startPosition
     */
    public void setStartPosition(Position startPosition) {
        if (startPosition != null) {
            this.startPosition = startPosition;
        }
    }

    /**
     * The function set new goal position
     *
     * @param goalPosition
     */
    public void setGoalPosition(Position goalPosition) {
        if (goalPosition != null) {
            this.goalPosition = goalPosition;
        }
    }

    /**
     * The function prints the maze
     */
    public void print() {
        //define the coordinates of the start and goal positions
        int rowStart, columnStart, rowGoal, columnGoal;
        rowStart = startPosition.getRowIndex();
        columnStart = startPosition.getColumnIndex();
        rowGoal = goalPosition.getRowIndex();
        columnGoal = goalPosition.getColumnIndex();

        //go over the matrix maze and print it
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                //this is the start position
                if (i == rowStart && j == columnStart) {
                    System.out.print(" " + "\u001B[46m" + "S");
                }
                //this is the start position
                else if (i == rowGoal && j == columnGoal) {
                    System.out.print(" " + "\u001B[46m" + "E");
                }
                else if (maze[i][j] == 1) {
                    System.out.print(" " + "\u001B[40m" + " ");
                }

                else if (maze[i][j] == 5) {
                    System.out.print(" " + "\u001B[43m" + " ");
                }

                else {
                    System.out.print(" " + "\u001B[107m" + " ");
                }
            }
            System.out.println(" " + "\u001B[107m");
        }

    }

}


