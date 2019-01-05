package guavatravellingsalesmansolver;

import com.google.common.graph.MutableValueGraph;

public class TenNodeExample
{
    /**
     * An example of how to use the HeldKarpSolver.
     */
    public static void main( String[] args )
    {

        int numberOfCities = 10;
        int startNode = 0;
        MutableValueGraph<Integer, Double> roads = GraphGen.generateCompleteGraph(numberOfCities);

        HeldKarpSolver solver = new HeldKarpSolver();

        double cost = solver.solveGraph(startNode, roads);
        System.out.println(cost);
    }
}
