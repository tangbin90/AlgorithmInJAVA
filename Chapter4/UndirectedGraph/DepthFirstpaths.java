package UndirectedGraph;

import java.util.Stack;

/**
 * @author TangBin
 * @version V1.0
 * @date 19/04/2017 2:26 PM
 */
public class DepthFirstpaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstpaths(Graph G, int s){
        marked = new boolean[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v]=true;
        for(int w:G.adj(v))
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,w);
            }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v))return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int x=v;x!=s;x=edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
