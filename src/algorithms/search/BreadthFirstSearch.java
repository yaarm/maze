/**
 * The class represents a breadth first search
 */
package algorithms.search;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    public BreadthFirstSearch(){
        super();
    }

    /**
     * The function returns the name of the search algorithm
     * @return String
     */
    @Override
    public String getName() {
        return "Breadth First Search";
    }

    /**
     * The function receives an AState, set it's cost and push it to the queue if it doesn't exist already
     * @param state
     */
    @Override
    protected void pushQueueStates(AState state){
        if (state.getPreviousState() != null) {
            state.setCost(10 + state.getPreviousState().getCost());
        }
        else {
            state.setCost(10);
        }
        //check if the doesnt exist in the queue
        if(!queueStates.contains(state)) {
            queueStates.add(state);
        }
    }


}
