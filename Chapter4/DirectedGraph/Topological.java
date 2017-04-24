package DirectedGraph;
/**
 * @author TangBin
 * @version V1.0
 * @date 21/04/2017 6:07 PM
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G){
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if(!cyclefinder.hasCycle()){
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order(){
        return order;
    }

    public boolean idDAG(){
        return order != null;
    }


}
