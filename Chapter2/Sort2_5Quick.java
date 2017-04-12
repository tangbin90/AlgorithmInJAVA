import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Comparator;

/**
 * @author TangBin
 * @version V1.0
 * @date 11/04/2017 4:19 PM
 */
public class Sort2_5Quick {
    public static void QuickSort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi){
        if(lo>=hi) return;
        int mid=partitionDoubleDirection(a,lo,hi);
        sort(a,lo,mid-1);
        sort(a,mid+1,hi);
    }

    public static int partitionOneDirection(Comparable[] a, int lo, int hi){
        int i=lo-1;
        Comparable v = a[hi];
        for(int j=lo;j<hi;j++){
            if(less(a[j],v)){
                i++;
                exch(a,j,i);
            }
        }
        exch(a,hi, ++i);
        return i;

    }

    public static int partitionDoubleDirection(Comparable[] a, int lo, int hi){
        int j=hi;
        int i=lo+1;
        Comparable key = a[lo];
        while(i<=j){
            while(less(a[i],key)) {
                i++;
                if(i>=hi)
                    break;
            }
            while(less(key,a[j])) {
                j--;
                if(j<=lo)
                    break;
            }
            if(i<j)
                exch(a,i++,j--);
            else
                break;
        }
        System.out.println(i+" "+j);
        exch(a,lo,i-1);
        return j;
    }

    private void sortUseThreePartition(Comparable[] a, int lo, int hi){
        if(hi<=lo) return;
        int lt = lo;
        int gt = hi;
        int eq = lo+1;
        Comparable key =a[lo];
        while(eq<gt){
            int com = a[eq].compareTo(key);

            if(com<0) exch(a,lt++,eq++);
            else if(com==0) eq++;
            else exch(a,lt,gt--);
        }

        sortUseThreePartition(a,lo,lt-1);
        sortUseThreePartition(a,gt+1,hi);
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }

    private static void exch(Comparable[] a, int i, int j){
        if(i==j)
            return;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
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
        Integer[] a={0,4,3,1,5};
        //partition2(a,0,a.length-1);
        sort(a,0,a.length-1);
        show(a);
    }
}
