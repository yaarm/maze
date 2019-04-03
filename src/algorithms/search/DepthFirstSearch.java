package algorithms.search;

import java.util.ArrayList;

public class DepthFirstSearch extends ASearchingAlgorithm {

    private static double countCost = 0;

    public DepthFirstSearch() {
        super();
    }

     private void pushQueueStates(AState state){
        state.setCost(countCost);
        countCost--;
        queueStates.add(state);
    }

    @Override
    public String getName() {
        return "DepthFirstSearch";
    }

    @Override
    public AState search(ISearchable search) {
        AState startState = search.getStartState();
        AState goalState = search.getGoalState();
        AState currentState;
        ArrayList<AState> stateSuccessors;
        pushQueueStates(startState);

        while(!queueStates.isEmpty()){
            currentState = popQueueStates();
            //check if the state already been visited
            if (visitedStates.containsKey(currentState.getState())){
                //currentState = currentState.getPreviousState();
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


}
