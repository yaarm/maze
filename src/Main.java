import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        IMazeGenerator mg = new EmptyMazeGenerator();
        long m = mg.measureAlgorithmTimeMillis(10,10);
        System.out.println(m);
    }
}
