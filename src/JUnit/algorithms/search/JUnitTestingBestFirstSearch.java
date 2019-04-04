package algorithms.search;

import algorithms.mazeGenerators.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JUnitTestingBestFirstSearch {
    BestFirstSearch bfs = new BestFirstSearch();

    @Test
    public void TestGetName() {
        assertEquals("Best First Search", bfs.getName());
    }

    @Test
    public void TestSearchNullISearchable() {
        ISearchable is = null;
        assertEquals(null, bfs.search(is));

    }

    @Test
    public void TestSolutionForEmptyMaze() {
        IMazeGenerator mg = new EmptyMazeGenerator();
        ISearchable maze = new SearchableMaze(mg.generate(100,100));
        assertNotNull(bfs.search(maze));
    }

    @Test
    public void TestSolutionForSimpleMaze() {
        IMazeGenerator mg = new SimpleMazeGenerator();
        ISearchable maze = new SearchableMaze(mg.generate(100,100));
        assertNotNull(bfs.search(maze));
    }

    @Test
    public void TestSolutionForMyMaze() {
        IMazeGenerator mg = new MyMazeGenerator();
        ISearchable maze = new SearchableMaze(mg.generate(100,100));
        assertNotNull(bfs.search(maze));
    }

    @Test
    public void TestSolutionTimeForSimpleMaze() {
        IMazeGenerator mg = new SimpleMazeGenerator();
        ISearchable maze = new SearchableMaze(mg.generate(1000,1000));
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        Solution solution = new Solution(bfs.search(maze));
        endTime = System.currentTimeMillis();
        assertTrue(60000 > endTime-startTime);
    }

    @Test
    public void TestSolutionTimeForMyMaze() {
        IMazeGenerator mg = new MyMazeGenerator();
        ISearchable maze = new SearchableMaze(mg.generate(1000,1000));
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        Solution solution = new Solution(bfs.search(maze));
        endTime = System.currentTimeMillis();
        assertTrue(60000 > endTime-startTime);
    }


}