/**
 * The class represents a maze that can be solved using a searching algorithm
 */
package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    private Maze maze;

    /**
     * The function creates a searchable maze
     * @param maze
     */
    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    public Maze getMaze() {
        return maze;
    }

    /**
     * The function returns the start state of the maze
     * @return AState
     */
    @Override
    public AState getStartState() {
        return new MazeState(maze.getStartPosition(), null, 0);
    }

    /**
     * The function returns the goal state of the maze
     * @return AState
     */
    @Override
    public AState getGoalState() {
        return new MazeState(maze.getGoalPosition(), null, 0);
    }

    /**
     * The function returns a list of successors that accessible from the current state
     * @param state
     * @return
     */
    @Override
    public ArrayList<AState> getAllSuccessors(AState state) {
        ArrayList<AState> possibleMoves = new ArrayList<>();

        //check if the state is null
        if (state == null) {
            return null;
        }

        Position currPosition = ((MazeState)state).getStatePosition();

        //define the x, y coordinates of the current position
        int x = currPosition.getRowIndex();
        int y = currPosition.getColumnIndex();


        //check the option to go up
        if (isPositionValid(x-1, y)) {
            possibleMoves.add(new MazeState(new Position(x-1, y), (MazeState)state, 10));
        }

        //check the option to go up and right - diagonal
        if ((isPositionValid(x-1, y) || isPositionValid(x, y+1)) && isPositionValid(x-1, y+1)) {
            possibleMoves.add(new MazeState(new Position(x-1, y+1), (MazeState)state, 15));
        }

        //check the option to go right
        if (isPositionValid(x, y+1)) {
            possibleMoves.add(new MazeState(new Position(x, y+1), (MazeState)state, 10));
        }

        //check the option to go down and right - diagonal
        if ((isPositionValid(x+1, y)  || isPositionValid(x, y+1)) && isPositionValid(x+1, y+1)) {
            possibleMoves.add(new MazeState(new Position(x+1, y+1), (MazeState)state, 15));
        }

        //check the option to go down
        if (isPositionValid(x+1, y)) {
            possibleMoves.add(new MazeState(new Position(x+1, y), (MazeState)state, 10));
        }

        //check the option to go down and left - diagonal
        if ((isPositionValid(x+1, y) || isPositionValid(x, y-1)) && isPositionValid(x+1, y-1)) {
            possibleMoves.add(new MazeState(new Position(x+1, y-1), (MazeState)state, 15));
        }

        //check the option to go left
        if (isPositionValid(x, y-1)) {
            possibleMoves.add(new MazeState(new Position(x, y-1), (MazeState)state, 10));
        }

        //check the option to go up and left - diagonal
        if ((isPositionValid(x-1, y) || isPositionValid(x, y-1)) && isPositionValid(x-1, y-1)) {
            possibleMoves.add(new MazeState(new Position(x-1, y-1), (MazeState)state, 15));
        }

        return  possibleMoves;
    }

    /**
     * The function return true if the coordinates is valid - in the boundaries of the matrix maze and not a wall,
     * otherwise returns false
     * @param x
     * @param y
     * @return return true if the coordinates is valid
     */
    private boolean isPositionValid(int x, int y) {
        //check if the position is in the boundaries of the matrix maze
        if (x < 0 || x >= maze.getMaze().length || y < 0 || y >= maze.getMaze()[0].length) {
            return false;
        }

        //check if the position is a wall
        if (maze.getMaze()[x][y] == 1) {
            return false;
        }

        return true;

    }


}
