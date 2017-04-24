package DirectedGraph;

/**
 * @author TangBin
 * @version V1.0
 * @date 23/04/2017 11:16 PM
 */
public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());
        for(int s : order.reversePost())
            if(!marked[s])
            {
                dfs(G,s);
                count++;
            }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;
        id[v] = count;
        for(int i : G.adj(v)){
            if(!marked[i])
                dfs(G, i);
        }
    }

    public boolean stronglyConnected(int v, int w){
        return id[v] == id[w];
    }

    public int id(int v){
        return id[v];
    }

    public int count(){
        return count;
    }
}
