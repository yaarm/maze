package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    private AState solutionState;

    public Solution(AState state) {
        this.solutionState = state;
    }

    /**
     * The function returns the path of the solution
     * @return ArrayList<AState>
     */
    public ArrayList<AState> getSolutionPath() {
        ArrayList<AState> solutionPath = new ArrayList<>();
        AState currState = solutionState;
        while (currState != null) {
            solutionPath.add(currState);
            currState = currState.getPreviousState();
        }
        Collections.reverse(solutionPath);
        return solutionPath;
    }
}
