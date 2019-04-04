/**
 * The class represent an maze that created by recursive backtracking algorithm
 */

package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class MyMazeGenerator extends AMazeGenerator {

    /**
     * The function receives the size of matrix to generate a maze using recursive backtracking algorithm
     * @param row
     * @param column
     * @return Maze
     */
    @Override
    public Maze generate(int row, int column) {
        //create the maze
        Maze myMaze = new Maze(row, column);
        //get start and goal Position
        Position startPosition = getRandomPosition(row, column);
        Position goalPosition = new Position(startPosition.getRowIndex(),startPosition.getColumnIndex());
        myMaze.setStartPosition(startPosition);
        myMaze.setGoalPosition(goalPosition);

        int[][] matrixMaze = myMaze.getMaze();
        Stack<Position> stackPosition = new Stack<>();
        stackPosition.push(startPosition);

        //init the maze with walls
        initTheMaze(matrixMaze);
        //set the start of the maze
        matrixMaze[startPosition.getRowIndex()][startPosition.getColumnIndex()] = 0;
        //set the current position to the start position
        Position currPosition = new Position(startPosition.getRowIndex(),startPosition.getColumnIndex());
        ArrayList<Direction> moveOptions = new ArrayList<>();
        while (!stackPosition.empty()) {
            //check the options to advance in the maze
            moveOptions.clear();
            moveOptions = checkOptionToMove(matrixMaze,currPosition, moveOptions);
            //there is no option to move from the current position
            if (moveOptions.size() == 0) {
                stackPosition.pop();
                if (!stackPosition.empty()) {
                    currPosition.setRow(stackPosition.peek().getRowIndex());
                    currPosition.setColumn(stackPosition.peek().getColumnIndex());
                }
            }
            //choose a random move from the possible options
            else {
                generateRandomMove(currPosition, moveOptions, matrixMaze, stackPosition);
                //update the goal position only if a move was made and the position is farther
                if(Math.abs(startPosition.getRowIndex()-currPosition.getRowIndex()) > Math.abs(startPosition.getRowIndex()-goalPosition.getRowIndex()) ||
                        Math.abs(startPosition.getColumnIndex()-currPosition.getColumnIndex()) > Math.abs(startPosition.getColumnIndex()-goalPosition.getColumnIndex())) {
                    goalPosition.setRow(currPosition.getRowIndex());
                    goalPosition.setColumn(currPosition.getColumnIndex());

                }
            }
        }
        matrixMaze[startPosition.getRowIndex()][startPosition.getColumnIndex()] = 2;
        matrixMaze[goalPosition.getRowIndex()][goalPosition.getColumnIndex()] = 3;

        return myMaze;
    }


    private static enum Direction {
        up,
        down,
        right,
        left
    }

    /**
     * The function receives the matrix of an empty maze and init it with a value that represent a wall
     * @param maze
     */
    private void initTheMaze(int[][] maze) {
        for (int i=0; i<maze.length; i++) {
            java.util.Arrays.fill(maze[i], 1);
        }
    }

    /**
     * The function receives the matrix of the maze and the current position and returns the options to move
     * in the maze - up / down / right / left
     * @param matrixMaze
     * @param currPosition
     * @return arrayList with the options to move
     */
    private ArrayList<Direction> checkOptionToMove(int[][] matrixMaze, Position currPosition, ArrayList<Direction> moveOptions){
        //define the x, y coordinates of the current position
        int x = currPosition.getRowIndex();
        int y = currPosition.getColumnIndex();

        //check the option to go up
        if (x > 1 && matrixMaze[x-1][y] == 1 && matrixMaze[x-2][y] == 1 &&
                isValidMove(matrixMaze, Direction.up, x-2, y)) {
            moveOptions.add(Direction.up);
        }

        //check the option to go down
        if (x < matrixMaze.length-2 && matrixMaze[x+1][y] == 1 && matrixMaze[x+2][y] == 1 &&
                isValidMove(matrixMaze, Direction.down, x+2, y)) {
            moveOptions.add(Direction.down);
        }

        //check the option to go right
        if (y < matrixMaze[0].length - 2 && matrixMaze[x][y+1] == 1 && matrixMaze[x][y+2] == 1 &&
                isValidMove(matrixMaze, Direction.right, x, y+2)) {
            moveOptions.add(Direction.right);
        }

        //check the option to go left
        if (y > 1 && matrixMaze[x][y-1] == 1 && matrixMaze[x][y-2] == 1 &&
                isValidMove(matrixMaze, Direction.left, x, y-2)) {
            moveOptions.add(Direction.left);
        }

        return moveOptions;
    }

    /**
     * The function receives the matrix of the maze and the movement location and returns true if this is
     * a valid move, otherwise returns false
     * @param matrixMaze
     * @param move
     * @param x
     * @param y
     * @return true if the move is valid, otherwise returns false
     */
    private boolean isValidMove(int[][] matrixMaze,Direction move, int x, int y) {
        //check if this is a valid move in the row - up or down
        if (move == Direction.up || move == Direction.down) {
            if (y == 0) {
                if (matrixMaze[x][y + 1] == 0) {
                    return false;
                }
                return true;
            }
            else if (y == matrixMaze[0].length-1) {
                if (matrixMaze[x][y - 1] == 0) {
                    return false;
                }
                return true;
            }
            else {
                if (matrixMaze[x][y-1] == 0 || matrixMaze[x][y+1] == 0) {
                    return false;
                }
                return true;
            }
        }
        //check if this is a valid move in the row - right or left
        else {
            if (x == 0) {
                if (matrixMaze[x+1][y] == 0) {
                    return false;
                }
                return true;
            }
            else if (x == matrixMaze.length-1) {
                if (matrixMaze[x-1][y] == 0) {
                    return false;
                }
                return true;
            }
            else {
                if (matrixMaze[x-1][y] == 0 || matrixMaze[x+1][y] == 0){
                    return false;
                }
                return true;
            }

        }

    }

    /**
     * The function receives the current position, the matrix of the maze and the array of options to move
     * and randomly moves to one of the directions and update the current position
     * @param currPosition
     * @param moveOptions
     * @param matrixMaze
     */
    private void generateRandomMove(Position currPosition, ArrayList<Direction> moveOptions, int[][] matrixMaze, Stack<Position> stackPosition) {
        int numOfOptions = moveOptions.size();
        int directionMove = ThreadLocalRandom.current().nextInt(0, numOfOptions);
        int x = currPosition.getRowIndex();
        int y = currPosition.getColumnIndex();

        //move the current position up
        if (moveOptions.get(directionMove) == Direction.up) {
            makeTheMove(new Position(x-1, y), new Position(x-2, y),stackPosition, matrixMaze, currPosition);
        }

        //move the current position down
        else if (moveOptions.get(directionMove) == Direction.down) {
            makeTheMove(new Position(x+1, y), new Position(x+2, y),stackPosition, matrixMaze, currPosition);
        }

        //move the current position right
        else if (moveOptions.get(directionMove) == Direction.right) {
            makeTheMove(new Position(x, y+1), new Position(x, y+2),stackPosition, matrixMaze, currPosition);
        }

        //move the current position left
        else {
            makeTheMove(new Position(x, y-1), new Position(x, y-2),stackPosition, matrixMaze, currPosition);
        }
    }

    /**
     * The function receives two positions to set to the path in the maze and update the matrix maze accordingly
     * and insert the the new positions to the stack
     * @param position1
     * @param position2
     * @param stackPositions
     * @param matrixMaze
     * @param currPosition
     */
    private void makeTheMove(Position position1, Position position2, Stack<Position> stackPositions, int[][] matrixMaze, Position currPosition) {
        //set the path in the maze
        matrixMaze[position1.getRowIndex()][position1.getColumnIndex()] = 0;
        matrixMaze[position2.getRowIndex()][position2.getColumnIndex()] = 0;

        //insert the positions to the stack
        stackPositions.push(position1);
        stackPositions.push(position2);

        //set the new current position
        currPosition.setRow(position2.getRowIndex());
        currPosition.setColumn(position2.getColumnIndex());
    }

}
