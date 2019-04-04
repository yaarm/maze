/**
 * The function represents a state of a problem
 */
package algorithms.search;

public abstract class AState implements Comparable<AState>{

    private String state;
    private double cost;
    private AState previousState;

    /**
     * The function creates AState
     * @param state
     * @param cost
     * @param previousState
     */
    public AState(String state, double cost, AState previousState) {
        this.state = state;
        this.cost = cost;
        this.previousState = previousState;
    }

    /**
     * The function returns true of the states are equal, otherwise returns false
     * @param obj
     * @return true if the states are equal
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * The function returns the cost of the state
     * @return double cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * The function set the new cost of the state
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * The function returns the previous state
     * @return AState previous
     */
    public AState getPreviousState() {
        return previousState;
    }

    /**
     * The function returns the string that represents state
     * @return String
     */
    public String getState() {
        return state;
    }

    /**
     * The function returns the to string of the AState
     * @return String
     */
    @Override
    public String toString() {
        return state;
    }

    /**
     * The function returns true if the states are equal - compares by the cost of the state,
     * otherwise returns false
     * @param state
     * @return true if the states are equal, otherwise returns false
     */
    @Override
    public int compareTo(AState state) {
        Double d1 = this.getCost();
        Double d2 = state.getCost();

        return Double.compare(d1, d2);
    }


}
