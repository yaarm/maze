/**
 * The class represent a generator of a simple maze
 */
package algorithms.mazeGenerators;

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
        Maze simpleMaze = new Maze(row, column);
        int[][] matrixMaze = simpleMaze.getMaze();
        //set start and goal positions
        simpleMaze.setStartPosition(new Position(0,0));
        simpleMaze.setGoalPosition(new Position(row-1, column-1));

        //create the walls of the maze
        createMazeWalls(matrixMaze);
        //mark the start and goal position
        matrixMaze[0][0] = 2;
        matrixMaze[row - 1][column - 1] = 3;
        return simpleMaze;
    }


    /**
     * The function creates the walls of the maze
     * @param maze
     */
    private void createMazeWalls(int[][] maze) {
        boolean wallStartFromBegining = true;
        int wallsLength = (int)Math.floor(maze.length * 0.8);
        //go over the columns
        for (int i = 1; i < maze[0].length; i+=2) {
            int size = maze.length-1;
            //go over the rows
            for (int j = 0;  j < wallsLength; j++) {
                if (wallStartFromBegining) {
                    maze[j][i] = 1;
                }
                else {
                    maze[size-j][i] = 1;
                }
            }
            wallStartFromBegining = !wallStartFromBegining;
        }

    }


}
