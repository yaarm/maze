package algorithms.mazeGenerators;

public class Maze {

    //private int numOfRows;
    //private int numOfColumns;
    private Position startPosition;
    private Position goalPosition;
    private int [][]maze;

    /**
     * The function receives start and goal positions and the number of rows and columns and creates new maze
     * @param startPosition
     * @param goalPosition
     * @param numOfRows
     * @param numOfColumns
     */
    public Maze(Position startPosition, Position goalPosition, int numOfRows, int numOfColumns) {
        this.startPosition = startPosition;
        this.goalPosition = goalPosition;
        this.maze = new int[numOfRows][numOfColumns];
    }

    /**
     * The function returns the start position of the maze
     * @return startPosition
     */
    public Position getStartPosition() {
        return startPosition;
    }

    /**
     * The function returns the goal position of the maze
     * @return goalPosition
     */
    public Position getGoalPosition() {
        return goalPosition;
    }

    /**
     * The function returns the maze represented by two dimensional array
     * @return maze
     */
    public int[][] getMaze() {
        return maze;
    }

    /**
     * The function receives two dimensional array and changes the maze
     * @param maze
     */
    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    /**
     * The function prints the maze
     */
    public void print() {
        for (int i=0; i<maze.length; i++) {
            for (int j=0; j<maze[i].length; j++) {
                if(maze[i][j] == 1) {
                    System.out.print("#");
                }
                else if (maze[i][j] == 2) {
                    System.out.print("S");
                }
                else if (maze[i][j] == 3) {
                    System.out.print("E");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
