/**
 * The class represents a state of a maze - using the position in the maze
 */
package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState {

    private Position statePosition;

    /**
     * The function creates a maze state
     * @param position
     * @param previousState
     */
    public MazeState(Position position, MazeState previousState, double cost) {
        super(position.toString(), cost, previousState);
        this.statePosition = position;
    }

    /**
     * The function returns the state position
     * @return Position
     */
    public Position getStatePosition() {
        return statePosition;
    }

    /**
     * The function returns true if the states are equals - means this is the same position
     * @param obj
     * @return true if the states are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || getClass() != obj.getClass()) {
            return false;
        }

        Position p1 = ((MazeState)obj).getStatePosition();
        if (p1 != null) {
            return this.statePosition.equals(p1);
        }

        return false;
    }
}
