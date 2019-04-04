/**
 * The interface defines functions of a searchable object
 */
package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {

    AState getStartState();
    AState getGoalState();
    ArrayList<AState> getAllSuccessors(AState state);

}
