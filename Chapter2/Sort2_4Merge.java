import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

/**
 * @author TangBin
 * @version V1.0
 * @date 11/04/2017 3:04 PM
 */
public class Sort2_4Merge {
    public static Comparable[] aux;
    public static void merge(Comparable[] a, int lo, int mid, int hi)
    {
        int i = lo, j = mid+1;


        for(int k=lo;k<=hi;k++)
            aux[k] = a[k];

        for(int k=lo;k<=hi;k++){
            if(i>mid)
                a[k]=aux[j++];
            else if(j>hi)
                a[k]=aux[i++];
            else if(less(a[j], a[i]))
                a[k]=aux[j++];
            else
                a[k]=aux[i++];
        }
    }

    public static void sort(Comparable[] a){
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a,int lo, int hi){
        if(hi<=lo) return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a, mid+1,hi);
        merge(a, lo, mid, hi);
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparator[] a, int i, int j){
        Comparable t = (Comparable) a[i];
        a[i] = a[j];
        a[j] = (Comparator) t;
    }

    private static void show(Comparable[] a){
        for(int i = 0; i<a.length;i++){
            StdOut.print(a[i]+" ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a){
        for(int i = 1;i<a.length;i++)
            if(less(a[i],a[i-1])) return false;
        return true;
    }

    public static void main(String... args){
        Integer[] a = new Integer[]{2,1,12,1,56,13,897,12};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
