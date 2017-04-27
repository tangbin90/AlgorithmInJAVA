package MinimumSpanningTree;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

/**
 * @author TangBin
 * @version V1.0
 * @date 25/04/2017 10:32 AM
 */
public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G){
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<>();
        for(Edge e:G.edges()) pq.insert(e);
        UF uf = new UF(G.V());

        while(!pq.isEmpty() && mst.size()<G.V()-1){
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if(uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }

    public double weight(){
        double weight=0.0;
        for(Edge e : mst){
            weight+=e.weight();
        }
        return weight;
    }
}
