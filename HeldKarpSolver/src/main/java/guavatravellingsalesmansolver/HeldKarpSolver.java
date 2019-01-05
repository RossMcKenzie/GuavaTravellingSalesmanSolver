package guavatravellingsalesmansolver;

import java.util.HashMap;
import java.util.HashSet;
import com.google.common.graph.MutableValueGraph;

public class HeldKarpSolver
{
    /**
     * Solves the travelling salesman problem for a fully connected Guava ValueGraph using the Held-Karp algorithm.
     * The complexity of this algorithm is O(2^n n^2) and it returns an exact answer rather than an approximation.
     */
    private HashMap<Integer, HashMap<HashSet<Integer>, Double>> setCosts;
    private MutableValueGraph<Integer, Double> graph;
    private int startNode;

    HeldKarpSolver()
    {
        this.setCosts = new HashMap<>();
        this.graph = null;
        this.startNode = 0;
    }

    private double calculateSetCost(int endNode, HashSet<Integer> testSet){
        double minimumCost;
        if (testSet.size() == 0) {
            minimumCost = graph.edgeValue(endNode, startNode).get();
        }else{
            minimumCost = Double.POSITIVE_INFINITY;
            for(Integer node : testSet){
                double cost = graph.edgeValue(endNode, node).get();
                HashSet<Integer> nextSet = new HashSet<>(testSet);
                nextSet.remove(node);
                cost += getSetCost(node, nextSet);
                if (cost < minimumCost){
                    minimumCost = cost;
                }
            }
        }
        return minimumCost;
    }

    private double getSetCost(int endNode, HashSet<Integer> testSet)
    {
        double cost;
        try {
            cost = setCosts.get(endNode).get(testSet);
        }catch (NullPointerException e){
            cost = calculateSetCost(endNode, testSet);
            setCosts.put(endNode, new HashMap<>());
            setCosts.get(endNode).put(testSet, cost);
        }
        return cost;
    }

    public double solveGraph(int startNode, MutableValueGraph<Integer, Double> graph)
    {
        this.graph = graph;
        this.startNode = startNode;

        HashSet<Integer> fullSet = new HashSet<Integer>(graph.nodes());
        fullSet.remove(startNode);
        double cost = getSetCost(startNode, fullSet);
        return cost;
    }

}
