package algorithms.search;

public class DepthFirstSearch extends ASearchingAlgorithm {

    private static double countCost = 0;

    /**
     * The function creates a DepthFirstSearch
     */
    public DepthFirstSearch() {
        super();
    }

    /**
     * The The function receives an AState, set it's cost and push it to the queue if it doesn't exist already
     * @param state
     */
    @Override
    protected void pushQueueStates(AState state){
        state.setCost(countCost);
        countCost--;
        queueStates.add(state);
    }

    /**
     * The function returns the name of the search algorithm
     * @return String
     */
    @Override
    public String getName() {
        return "Depth First Search";
    }


}
