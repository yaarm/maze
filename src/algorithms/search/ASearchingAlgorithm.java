package algorithms.search;

import java.util.*;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {

    protected PriorityQueue<AState> queueStates;
    protected HashMap<String,AState> visitedStates;
    protected int numberOfVisitedJunctions;

    public ASearchingAlgorithm(){
        queueStates = new PriorityQueue<>();
        this.visitedStates = new HashMap<>();
        numberOfVisitedJunctions = 0;
    }

    @Override
    public abstract AState search(ISearchable search);

    protected AState popQueueStates(){
        numberOfVisitedJunctions++;
        return queueStates.poll();
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numberOfVisitedJunctions;
    }


    public Solution solve(ISearchable domain) {
        return new Solution(search(domain));
    }

    /**
     * The function receives the options to advance and returns only unvisited moves
     * @param stateSuccessors
     * @return AState
     */
    protected ArrayList<AState> getUnvisitedMoveOptions(ArrayList<AState> stateSuccessors) {
        if (stateSuccessors == null) {
            return null;
        }
        //go over the options and remove moves that are been visited already
        for (Iterator<AState> iterator = stateSuccessors.iterator(); iterator.hasNext(); ) {
            AState value = iterator.next();
            if (visitedStates.containsKey(value.getState())) {
                iterator.remove();
            }
        }

        //check if there are no moves to do
        if (stateSuccessors.size() == 0) {
            return null;
        }

        else {
            return stateSuccessors;
        }
    }

}

