package DirectedGraph;

import edu.princeton.cs.algs4.DirectedDFS;

/**
 * @author TangBin
 * @version V1.0
 * @date 24/04/2017 1:48 PM
 */
public class TransitiveClosure {
    private DepthFirstSearch[] all;
    TransitiveClosure(Digraph G){
        all = new DepthFirstSearch[G.V()];
        for(int v=0;v<G.V();v++)
            all[v] = new DepthFirstSearch(G, v);
    }

    boolean reachable(int v, int w){
        return all[v].marked(w);
    }
}
