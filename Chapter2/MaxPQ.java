/**
 * @author TangBin
 * @version V1.0
 * @date 12/04/2017 9:39 AM
 */
public class MaxPQ {

    private Comparable[] pq;
    private int N = 0;

    public MaxPQ(){

    }

    public MaxPQ(int maxN){
        pq = new Comparable[maxN+1];
    }

    public MaxPQ(Comparable[] a){
        pq=a;
        N=a.length;
    }

    void Insert(Comparable v){
        pq[++N]=v;
        swim(N);
    }

    Comparable delMax(){
        Comparable max=pq[1];
        exch(1,N--);
        pq[N+1]=null;
        sink(1);
        return max;
    }


    public boolean isEmpty(){
        return N==0;
    }

    int size(){
        return N;
    }

    private void swim(int k){
        while(k>1&&less(k/2,k)){
            exch(k/2,k);
            k=k/2;
        }
    }

    private void sink(int k){
        while(k*2<=N){
            int j = k*2;
            if(j<N&&less(j,j+1))j++;
            if(!less(k,j))
                break;
            exch(k,j);
            k=j;
        }
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j])<0;
    }

    private void exch(int i, int j){
        Comparable t = pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }

    Comparable max(){
        return pq[1];
    }


}
