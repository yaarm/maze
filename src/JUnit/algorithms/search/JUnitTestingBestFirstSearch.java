package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JUnitTestingBestFirstSearch {
    BestFirstSearch bfs = new BestFirstSearch();

    @Test
    public void TestGetName() {
        assertEquals("BestFirstSearch", bfs.getName());
    }

    @Test
    public void TestSearchNullISearcable() {
        ISearchable is = null;
        assertEquals(null, bfs.search(is));

    }

    @Test
    public void TestSearchMazeSizeZero() {
        ISearchable is = new SearchableMaze(new Maze(new Position(0,0), new Position(0,0), 0, 0));
        assertEquals(null, bfs.search(is));

    }
}