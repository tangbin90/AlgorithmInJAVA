package MinimumPath;

import edu.princeton.cs.algs4.DirectedDFS;

/**
 * @author TangBin
 * @version V1.0
 * @date 25/04/2017 10:47 PM
 */
public class DirectedEdge {
    private final int v;//start
    private final int w;//end
    private final double weight;

    public DirectedEdge(int v, int w , double weight){
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight(){
        return this.weight;
    }

    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public String toString(){
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
