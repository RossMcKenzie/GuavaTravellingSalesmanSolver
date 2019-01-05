package guavatravellingsalesmansolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.graph.MutableValueGraph;
import org.junit.Test;

/**
 * Unit test for HeldKarpSolver.
 */
public class HeldKarpSolverTest
{

    @Test
    public void twoNodeLength()
    {
        int numberOfCities = 2;
        int startNode = 0;
        MutableValueGraph<Integer, Double> roads = GraphGen.generateCompleteGraph(numberOfCities);
        double expectedCost = roads.edgeValue(0, 1).get() * 2;
        HeldKarpSolver solver = new HeldKarpSolver();
        double cost = solver.solveGraph(startNode, roads);
        System.out.println(expectedCost-cost);
        assertEquals(expectedCost, cost, 0.00001);
    }
}
