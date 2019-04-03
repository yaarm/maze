package test;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import algorithms.search.*;
import javafx.geometry.Pos;

import java.util.ArrayList;
public class RunSearchOnMaze {
    public static void main(String[] args) {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(25, 25);
        maze.print();
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        long startTime, endTime,sum;
        startTime = System.currentTimeMillis();
        solveProblem(searchableMaze, new BreadthFirstSearch());
        endTime = System.currentTimeMillis();
        System.out.println("BFS Time:" + String.valueOf(endTime-startTime));
        startTime = System.currentTimeMillis();
        solveProblem(searchableMaze, new DepthFirstSearch());
        endTime = System.currentTimeMillis();
        System.out.println("DFS Time:"+ String.valueOf(endTime-startTime));
        startTime = System.currentTimeMillis();
        solveProblem(searchableMaze, new BestFirstSearch());
        endTime = System.currentTimeMillis();
        System.out.println("Best Time:" + String.valueOf(endTime-startTime));
    }
    private static void solveProblem(ISearchable domain, ISearchingAlgorithm
            searcher) {
        //Solve a searching problem with a searcher
        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
                //Printing Solution Path
                System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        System.out.println(solutionPath.size());
        //for (int i = 0; i < solutionPath.size(); i++) {
        //    System.out.println(String.format("%s.%s",i,solutionPath.get(i)));
        //}
    }
}
