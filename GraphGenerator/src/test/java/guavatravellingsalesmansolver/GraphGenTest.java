package guavatravellingsalesmansolver;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.google.common.graph.MutableValueGraph;


/**
 * Unit test for simple GraphGen.
 */
public class GraphGenTest
{

    @Test
    public void matchNumberOfNodes(){
        int test = 10;
        MutableValueGraph<Integer, Double> g = GraphGen.generateCompleteGraph(test);
        System.out.println(g.nodes().size());
        assertEquals(g.nodes().size(), test);
    }
}
