package DirectedGraph;

import UndirectedGraph.Graph;

/**
 * @author TangBin
 * @version V1.0
 * @date 21/04/2017 4:27 PM
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        count++;
        for(int w:G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }

    public DepthFirstSearch(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for(int s:sources)
            if(!marked[s]) dfs(G, s);
    }


    public boolean marked(int v){//是否与v连通
        return marked[v];
    }

    public int count(){
        return count;
    }
}


