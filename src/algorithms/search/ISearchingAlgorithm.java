package algorithms.search;

public interface ISearchingAlgorithm {

    AState search(ISearchable search);

    int getNumberOfNodesEvaluated();

    String getName();

    Solution solve(ISearchable domain);
}
