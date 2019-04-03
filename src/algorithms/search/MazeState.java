package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

public class MazeState extends AState {

    private Position statePosition;

    public MazeState(Position position, MazeState previousState) {
        super(position.toString(), 1, previousState);
        this.statePosition = position;
    }


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
