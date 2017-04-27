package MinimumSpanningTree;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * @author TangBin
 * @version V1.0
 * @date 24/04/2017 2:57 PM
 */
public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (Bag<Edge>[]) new Bag[V];
        for(int v = 0; v<V;v++)
            adj[v]=new Bag<>();
    }

    public EdgeWeightedGraph(In in){
        this(in.readInt());
        int E = in.readInt();

        for(int i = 0;i<E;i++){
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v,w,weight);
            addEdge(e);
        }
    }

    public int V() {
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(Edge e){
        int v = e.either(), w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        Bag<Edge> b = new Bag<>();
        for(int v=0;v<V;v++)
            for(Edge e:adj[v])
                if(e.other(v)>v) b.add(e);
        return b;
    }

}
