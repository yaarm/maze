/**
 * The class represents best first search algorithm
 */
package algorithms.search;

public class BestFirstSearch extends BreadthFirstSearch {

    public  BestFirstSearch(){
        super();
    }

    /**
     * The function returns the name of the search algorithm
     * @return String
     */
    @Override
    public String getName() {
        return "Best First Search";
    }

    /**
     * The function receives an AState, set it's cost and push it to the queue if it doesn't exist already
     * @param state
     */
    @Override
    protected void pushQueueStates(AState state){
        if (state.getPreviousState() != null) {
            state.setCost(state.getCost() + state.getPreviousState().getCost());
        }
        //check if the doesnt exist in the queue
        if(!queueStates.contains(state)) {
            queueStates.add(state);
        }
    }

}
