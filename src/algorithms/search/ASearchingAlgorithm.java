/**
 * The class represents searching algorithms to solve a problem
 */
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

    /**
     * The function search for the goal state of a searchable object
      * @param search
     * @return AState - goal state
     */
    @Override
    public AState search(ISearchable search) {
        if (search == null || search.getStartState() == null || search.getGoalState() == null){
            return null;
        }
        AState startState = search.getStartState();
        AState goalState = search.getGoalState();
        AState currentState;
        ArrayList<AState> stateSuccessors;
        pushQueueStates(startState);

        while(!queueStates.isEmpty()){
            currentState = popQueueStates();
            //check if the state already been visited
            if (visitedStates.containsKey(currentState.getState())){
                continue;
            }
            visitedStates.put(currentState.toString(),currentState);
            //check if we made to the goal state
            if(currentState.equals(goalState)){
                return currentState;
            }

            //add the possible options to advance from the current state
            stateSuccessors = search.getAllSuccessors(currentState);
            //get unvisited options to advance
            stateSuccessors = getUnvisitedMoveOptions(stateSuccessors);
            //check if there is no option to advance
            if (stateSuccessors == null) {
                continue;
            }

            for (AState state: stateSuccessors) {
                pushQueueStates(state);
            }

        }
        return null;
    }

    /**
     * The function receives an AState, set it's cost and push it to the queue if it doesn't exist already
     * @param state
     */
    protected abstract void pushQueueStates(AState state);

    /**
     * The function returns the last state in the queue and increase the number of visited junctions
     * @return
     */
    protected AState popQueueStates(){
        numberOfVisitedJunctions++;
        return queueStates.poll();
    }

    /**
     * The function returns the number of nodes that have been evaluated
     * @return int
     */
    @Override
    public int getNumberOfNodesEvaluated() {
        return numberOfVisitedJunctions;
    }

    /**
     * The function returns a solution for the searchable object
     * @param domain
     * @return Solution
     */
    public Solution solve(ISearchable domain) {
        if (domain == null) {
            return null;
        }
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

