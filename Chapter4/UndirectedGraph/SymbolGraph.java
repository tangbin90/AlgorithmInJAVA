package UndirectedGraph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author TangBin
 * @version V1.0
 * @date 21/04/2017 2:23 PM
 */
public class SymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Graph G;

    SymbolGraph(String stream, String delim){
        st = new ST<>();
        In in = new In(stream);
        while(in.hasNextLine()){
            String[] a = in.readLine().split(delim);
            for(int i = 0;i<a.length;i++)
                if(!st.contains(a[i]))
                    st.put(a[i], st.size());
        }

        keys = new String[st.size()];
        for(String name:st.keys())
            keys[st.get(name)] = name;

        G = new Graph(st.size());
        in = new In(stream);
        while(in.hasNextLine()){
            String[] a = in.readLine().split(delim);
            int v = st.get(a[0]);
            for(int i=1;i<a.length;i++)
                G.addEdge(v,st.get(a[i]));
        }
    }

    boolean contains(String s){
        return st.contains(s);
    }

    int index(String s){
        return st.get(s);
    }

    public Graph G(){
        return G;
    }

    public String name(int v){
        return keys[v];
    }

    public static void main(String[] args){
        String filename = args[0];
        String delim = args[1];
        SymbolGraph sg = new SymbolGraph(filename, delim);
        Graph G = sg.G();

        while(StdIn.hasNextLine()){
            String source = StdIn.readLine();
            for(int w:G.adj(sg.index(source)))
                StdOut.println(" "+sg.name(w));
        }

    }

}
