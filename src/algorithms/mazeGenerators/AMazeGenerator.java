package algorithms.mazeGenerators;
import java.util.concurrent.ThreadLocalRandom;

public abstract class AMazeGenerator implements IMazeGenerator{

    public long measureAlgorithmTimeMillis(int row, int column){
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        generate(row, column);
        endTime = System.currentTimeMillis();
        return endTime-startTime;
    }

    public Position getRandomPosition(int row, int column) {
        //select random wall
        int wall = ThreadLocalRandom.current().nextInt(1, 5);
        Position p;

        if (wall == 1) {
            p = new Position(0, ThreadLocalRandom.current().nextInt(0, column));
        }
        else if (wall == 2) {
            p = new Position(ThreadLocalRandom.current().nextInt(0, row), column-1);
        }
        else if (wall == 3) {
            p = new Position(row-1, ThreadLocalRandom.current().nextInt(0, column));
        }
        else {
            p = new Position(ThreadLocalRandom.current().nextInt(0, row), 0);
        }

        return p;
    }
}
