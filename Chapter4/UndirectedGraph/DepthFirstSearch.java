package UndirectedGraph;

/**
 * @author TangBin
 * @version V1.0
 * @date 18/04/2017 4:22 PM
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        count++;
        for(int w:G.adj(v))
            if(!marked[w])
                dfs(G, w);
    }

    public boolean marked(int v){//是否与v连通
        return marked[v];
    }

    public int count(){
        return count;
    }
}
