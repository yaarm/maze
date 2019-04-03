package algorithms.search;

public abstract class AState implements Comparable<AState>{

    private String state;
    private double cost;
    private AState previousState;

    public AState(String state, double cost, AState previousState) {
        this.state = state;
        this.cost = cost;
        this.previousState = previousState;
    }

    @Override
    public abstract boolean equals(Object obj);

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public AState getPreviousState() {
        return previousState;
    }

    public void setPreviousState(AState previousState) {
        this.previousState = previousState;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return state;
    }

    @Override
    public int compareTo(AState state) {
        Double d1 = this.getCost();
        Double d2 = state.getCost();

        return Double.compare(d1, d2);
    }


    /*
    @Override
    public int compare(AState o1, AState o2) {
        Double d1 = o1.getCost();
        Double d2 = o2.getCost();

        return Double.compare(d1, d2);
    }
    */
}
