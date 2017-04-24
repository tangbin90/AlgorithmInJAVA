package UndirectedGraph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author TangBin
 * @version V1.0
 * @date 18/04/2017 4:17 PM
 */
public class TestSearch {
    public static void main(String[] args){
        Graph G = new Graph(new In(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(G, s);

        for(int v = 0; v<G.V(); v++){
            if(depthFirstSearch.marked(v))
                StdOut.print(v+" ");
        }
        StdOut.println();

        if(depthFirstSearch.count() != G.V())
            StdOut.print("NOT");
        StdOut.println("connected");

    }
}
