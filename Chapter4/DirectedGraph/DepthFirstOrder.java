package DirectedGraph;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

import java.util.Iterator;

/**
 * @author TangBin
 * @version V1.0
 * @date 21/04/2017 5:34 PM
 */
public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G){
        pre = new Queue<>();
        post = new Queue<>();
        reversePost = new Stack<>();

        marked = new boolean[G.V()];
        for(int v = 0;v<G.V();v++)
            if(!marked[v])dfs(G,v);
    }

    private void dfs(Digraph G, int v){
        pre.enqueue(v);

        marked[v] = true;
        for(int w:G.adj(v))
            if(!marked[w])
                dfs(G,w);

        post.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
