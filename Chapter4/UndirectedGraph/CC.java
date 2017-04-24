package UndirectedGraph;

/**
 * @author TangBin
 * @version V1.0
 * @date 19/04/2017 10:53 PM
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    CC(Graph G){
       marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int s=0;s<G.V();s++)
            if(!marked[s]){
                dfs(G, s);
                count++;
            }
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        id[v]=count;
        for(int w:G.adj(v))
            if(!marked[w])
                dfs(G,w);
    }
    boolean connected(int v, int w){
        return id[v] == id[w];
    }

    int count(){
        return count;
    }

    int id(int v){
        return id[v];
    }

}
