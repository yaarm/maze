package algorithms.search;

import java.util.ArrayList;

public class BestFirstSearch extends BreadthFirstSearch {

   // private static double countCost = 0;

    public  BestFirstSearch(){
        super();
    }

    @Override
    public String getName() {
        return "BestFirstSearch";
    }


    private void pushQueueStates(AState state){
        if (state.getPreviousState() != null) {
            state.setCost(state.getCost() + state.getPreviousState().getCost());
        }
        //check if the doesnt exist in the queue
        if(!queueStates.contains(state)) {
            queueStates.add(state);
        }
    }

    @Override
    public AState search(ISearchable search) {
        if (search == null){
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

}
