package guavatravellingsalesmansolver;

import com.google.common.graph.MutableValueGraph;
import  com.google.common.graph.ValueGraphBuilder;
import java.util.Random;

public class GraphGen
{
    /**
     * Produces a random, fully connected Guava ValueGraph.
     */

    public static MutableValueGraph<Integer, Double> generateCompleteGraph(int numberOfCities)
    {
        MutableValueGraph<Integer, Double> roads = ValueGraphBuilder.undirected().build();
        Random rng = new Random();
        for(int cityA = 0; cityA<numberOfCities; cityA++){
            for (int cityB = cityA+1; cityB<numberOfCities; cityB++){
                double distance = rng.nextDouble();
                try {
                    roads.putEdgeValue(cityA, cityB, distance);
                }catch (IllegalArgumentException e){}
            }
        }
        return roads;
    }
}
