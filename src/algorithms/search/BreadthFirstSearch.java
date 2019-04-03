package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    public BreadthFirstSearch(){
        super();
    }

    @Override
    public String getName() {
        return "BreadthFirstSearch";
    }


    private void pushQueueStates(AState state){
        state.setCost(10);
        if (state.getPreviousState() != null) {
            state.setCost(state.getCost() + state.getPreviousState().getCost());
        }
        //check if the doesnt exist in the queue
        if(!queueStates.contains(state)) {
            queueStates.add(state);
        }
        queueStates.add(state);
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
