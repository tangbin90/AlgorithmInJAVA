package MinimumPath;

import edu.princeton.cs.algs4.Stack;

/**
 * @author TangBin
 * @version V1.0
 * @date 27/04/2017 1:23 PM
 */
public class SP {
    private DirectedEdge[] edgeTo;
    private Double[] distTo;
    SP(EdgeWeightedDigraph G, int s){
        distTo = new Double[G.V()];
        for(int i=0;i<distTo.length;i++)
            distTo[i] = Double.POSITIVE_INFINITY;
        distTo[0]=0.0;

        edgeTo = new DirectedEdge[G.V()];
    }

    private void relax(DirectedEdge e){
        int v = e.from(), w = e.to();
        if(distTo[w]>distTo[v]+e.weight()){
            distTo[w] = distTo[v]+e.weight();
            edgeTo[w] = e;
        }
    }

    private void relax(EdgeWeightedDigraph G, int v){
        for(DirectedEdge e: G.adj(v)){
            int w = e.to();
            if(distTo[w]>distTo[v]+e.weight()){
                distTo[w] = distTo[v] + e.weight();
            }
        }
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int v){
        return distTo[v]<Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v))return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for(DirectedEdge e = edgeTo[v]; e!=null; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }
}
