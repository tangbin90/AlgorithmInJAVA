package MinimumSpanningTree;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author TangBin
 * @version V1.0
 * @date 24/04/2017 9:27 PM
 */
public class PrimMST {
    private Edge[] edgeTo;
    private double[] distTo;
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G){
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for(int v = 0;v<G.V();v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        pq = new IndexMinPQ<>(G.V());

        distTo[0] = 0.0;
        pq.insert(0, 0.0);
        while(!pq.isEmpty())
            visit(G, pq.delMin());
    }

    private void visit(EdgeWeightedGraph G, int v){
        marked[v] = true;
        for(Edge e:G.adj(v)){
            int w = e.other(v);
            if(marked[w]) continue;
            if(e.weight()<distTo[w]){
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if(pq.contains(w))pq.changeKey(w,distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges(){
        List<Edge> le = new LinkedList<>(Arrays.asList(edgeTo));
        return le;
    }

    public double weight(){
        double weight = 0.0;
        for(Edge e:edges())
            weight+=e.weight();
        return weight;
    }
}
