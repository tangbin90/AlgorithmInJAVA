import com.sun.xml.internal.bind.v2.TODO;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author TangBin
 * @version V1.0
 * @date 19/04/2017 10:00 AM
 */
public class UF {
    private int[] id;//分量id
    private int count;//分量数量

    public UF(int N){
        count = N;
        id = new int[N];
        for(int i=0;i<N;i++)
            id[i]=i;
    }

    public int count(){
        return count;
    }


    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);

        if(pID==qID) return;

        for(int i=0;i<id.length;i++)
            if(id[i]==pID) id[i] = qID;
        count--;

    }

    public int quickFind(int p){
        while(p!=id[p]) p=id[p];
        return p;
    }

    public void quickUnion(int p, int q){
        int pRoot = quickFind(p);
        int qRoot = quickFind(q);

        if(pRoot==qRoot) return;
        id[pRoot]=qRoot;
        count--;
    }

    public int find(int p){
        return id[p];
    }

    public boolean connected(int p, int q){
        return id[p]==id[q];
    }

    public static void main(String[] args){
        int N = StdIn.readInt();
        UF uf = new UF(N);

        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(uf.connected(p,q)) continue;
            uf.union(p,q);
            StdOut.println(p+" "+q);
        }
        StdOut.println(uf.count()+"components");
    }
}
